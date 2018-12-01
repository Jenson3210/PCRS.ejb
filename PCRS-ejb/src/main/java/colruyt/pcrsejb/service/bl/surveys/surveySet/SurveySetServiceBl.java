package colruyt.pcrsejb.service.bl.surveys.surveySet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.surveys.rating.ConsensusRating;
import colruyt.pcrsejb.entity.surveys.rating.Rating;
import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.entity.surveys.survey.SurveyKind;
import colruyt.pcrsejb.entity.surveys.survey.SurveySection;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.surveys.surveySet.ISurveySetServiceDl;

@Stateless
public class SurveySetServiceBl implements Serializable, ISurveySetServiceBl{

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySetServiceDl surveySetServiceDb;
	
	@Override
	public SurveySet save(SurveySet element) {
		return surveySetServiceDb.save(element);
	}

	@Override
	public SurveySet get(SurveySet element) {
		return surveySetServiceDb.get(element);
	}

	@Override
	public List<SurveySet> getAll() {
		return surveySetServiceDb.getAll();
	}

	@Override
	public void delete(SurveySet element) {
		surveySetServiceDb.delete(element);
	}

	@Override
	public SurveySet createSurveySetForUser(User user, List<SurveySectionDefinitionImpl> sections) {
		SurveySet surveySet = new SurveySet();
		List<Survey> surveys = new ArrayList<>();
		for (SurveyKind kind : SurveyKind.values()) {
			surveys.add(createSurvey(kind, sections));
		}
		surveySet.setSurveyList(surveys);
		surveySet = this.save(surveySet);
		return surveySet;
	}

	private Survey createSurvey(SurveyKind kind, List<SurveySectionDefinitionImpl> sections) {
		Survey survey = new Survey();
		List<SurveySection> tempSections = new ArrayList<>();
		for (SurveySectionDefinitionImpl surveySectionDefinitionImpl : sections) {
			SurveySection tempSection = new SurveySection();
			tempSection.setSurveySectionDefinition(surveySectionDefinitionImpl);
			List<Rating> ratings = new ArrayList<>();
			for (CompetenceImpl competence : surveySectionDefinitionImpl.getSurveySectionDefinition().getSurveySectionCompetences()) {
				Rating rating = null;
				if (kind.equals(SurveyKind.Consensus)) {
					rating = new ConsensusRating();
				}
				else {
					rating = new Rating();
				}
				rating.setCompetence(competence);
				ratings.add(rating);
			}
			tempSection.setRatings(ratings);
			tempSections.add(tempSection);
		}
		survey.setSurveySections(tempSections);
		survey.setSurveyKind(kind);
		return survey;
	}
}
