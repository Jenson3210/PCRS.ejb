package colruyt.pcrsejb.service.bl.surveys.surveySet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.surveys.rating.ConsensusRating;
import colruyt.pcrsejb.entity.surveys.rating.Rating;
import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.entity.surveys.survey.SurveyKind;
import colruyt.pcrsejb.entity.surveys.survey.SurveySection;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.user.IUserServiceBl;
import colruyt.pcrsejb.service.dl.surveys.surveySet.ISurveySetServiceDl;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveySetServiceBl implements Serializable, ISurveySetServiceBl {

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySetServiceDl surveySetServiceDb;
	@EJB
	private IUserServiceBl userServiceBl;

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
	public void delete(SurveySet element) throws ValidationException {
		surveySetServiceDb.delete(element);
	}

	@Override
	public SurveySet createSurveySetForUser(List<SurveySectionDefinitionImpl> sections) {
		SurveySet surveySet = new SurveySet();
		List<Survey> surveys = new ArrayList<>();
		for (SurveyKind kind : SurveyKind.values()) {
			surveys.add(createSurvey(kind, sections));
		}
		surveySet.setSurveyList(surveys);
		surveySet.setSurveyYear(LocalDate.now());
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
			for (CompetenceImpl competence : surveySectionDefinitionImpl.getSurveySectionDefinition()
					.getSurveySectionCompetences()) {
				Rating rating = null;
				if (kind.equals(SurveyKind.Consensus)) {
					rating = new ConsensusRating();
				} else {
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

	@Override
	public Integer getPercentageCompleteForMemberSurvey(User user) throws NoSurveySetException {
		SurveySet set = surveySetServiceDb.getLatestSetFor(user);

		Survey survey = set.getSurveyList().stream().filter(x -> x.getSurveyKind().equals(SurveyKind.TeamMember))
				.findFirst().get();

		return this.berekenPercentage(survey);

	}

	private Integer berekenPercentage(Survey surv) {

		int totaal = 0;
		int beantwoord = 0;

		for (SurveySection suy : surv.getSurveySections()) {

			for (Rating r : suy.getRatings()) {
				totaal = totaal + 1;
				if (r.getLevel() != 0) {
					beantwoord = beantwoord + 1;
				}
			}
		}

		return Math.round(beantwoord / totaal);
	}

	@Override
	public Integer getPercentageCompleteForManagerSurvey(User user) throws NoSurveySetException {

		SurveySet set = surveySetServiceDb.getLatestSetFor(user);
		Survey survey = set.getSurveyList().stream().filter(x -> x.getSurveyKind().equals(SurveyKind.TeamManager))
				.findFirst().get();

		return this.berekenPercentage(survey);
	}

	@Override
	public Integer getPercentageCompleteForConsensusSurvey(User user) throws NoSurveySetException {
		SurveySet set = surveySetServiceDb.getLatestSetFor(user);

		Survey survey = set.getSurveyList().stream().filter(x -> x.getSurveyKind().equals(SurveyKind.Consensus))
				.findFirst().get();

		return this.berekenPercentage(survey);
	}

	@Override
	public Survey getSurveyForUser(User user, SurveyKind surveyKind) throws NoSurveySetException {
		Survey survey = null;
		for (Survey s : surveySetServiceDb.getLatestSetFor(user).getSurveyList()) {
			if (survey.getSurveyKind().equals(surveyKind)) {
				survey = s;
			}
		}
		return survey;
	}
}
