package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Local;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.facade.IFacade;

@Local
public interface ISurveySectionDefinitionFacade extends IFacade<SurveySectionDefinitionBo> {

	List<SurveySectionDefinitionBo> getSurveySectionDefinitionsForTitle(SurveySectionTitleBo t);

}
