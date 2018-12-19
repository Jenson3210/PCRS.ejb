package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveySectionTitleServiceBl extends IServiceBl<SurveySectionTitle>{
	public Boolean isSurveySectionTitleUsed(SurveySectionTitle surveySectionTitle);

}
