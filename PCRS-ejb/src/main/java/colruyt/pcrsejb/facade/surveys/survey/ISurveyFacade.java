package colruyt.pcrsejb.facade.surveys.survey;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;
import colruyt.pcrsejb.facade.IFacade;

@Local
public interface ISurveyFacade extends IFacade<SurveyBo> {

}
