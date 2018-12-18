package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface ISurveySectionDefinitionFacade extends IFacade<SurveySectionDefinitionBo> {
	List<SurveySectionDefinitionBo> getSurveySectionDefinitionsForTitle(SurveySectionTitleBo t);
	
	SurveySectionDefinitionBo addCompetenceImpl(SurveySectionDefinitionBo section, CompetenceImplBo competence) throws ValidationException;
	
	SurveySectionDefinitionBo removeCompetenceImpl(SurveySectionDefinitionBo section, CompetenceImplBo competence) throws ValidationException;
}
