package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveyDefinitionDl;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionDefinitionImplAlreadyUsedException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveyDefinitionServiceBl implements ISurveyDefinitionServiceBl {
	
	@EJB
	private ISurveyDefinitionDl surveyDefinitionDl;

	
	@Override
	public SurveyDefinition save(SurveyDefinition element) {
		return surveyDefinitionDl.save(element);
	}

	@Override
	public SurveyDefinition get(SurveyDefinition element) {
		return surveyDefinitionDl.get(element);
	}

	@Override
	public List<SurveyDefinition> getAll() {
		return surveyDefinitionDl.getAll();
	}

	@Override
	public void delete(SurveyDefinition element) throws ValidationException {
		surveyDefinitionDl.delete(element);
	}

	@Override
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user) {
		
		return surveyDefinitionDl.getSurveyDefinitionsOfUser(user);
	}

	@Override
	public User getResponsible(SurveyDefinition surveyDefinition) {
		return surveyDefinitionDl.getResponsible(surveyDefinition);
	}

	@Override
	public void validateSectionDefinitionImpl(SurveyDefinitionBo surveyDefinition, SurveySectionDefinitionImplBo def) throws ValidationException {
		for (SurveySectionDefinitionImplBo bo : surveyDefinition.getSurveySections()) {
			if (bo.getSurveySectionDefinitionBo().getSurveySectionTitle().equals(
					def.getSurveySectionDefinitionBo().getSurveySectionTitle())) {
				throw new SurveySectionDefinitionImplAlreadyUsedException("Survey section definition is already defined for this function.");
			}
		}
		
	}
	
	
}
