package colruyt.pcrsejb.service.bl.surveys.survey;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ISurveySectionDefinitionImplBl extends IServiceBl<SurveySectionDefinitionImpl> {

	List<SurveySectionDefinitionImpl> getAllByUser(User user);

}
