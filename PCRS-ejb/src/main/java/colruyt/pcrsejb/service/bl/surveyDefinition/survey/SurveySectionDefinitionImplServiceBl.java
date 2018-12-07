package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.SurveyUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionDefinitionImplServiceDl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveySectionDefinitionImplServiceBl implements ISurveySectionDefinitionImplServiceBl, Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionDefinitionImplServiceDl surveySectionDefinitionImplServiceDl;

	@Override
	public SurveySectionDefinitionImpl save(SurveySectionDefinitionImpl element) {
		return surveySectionDefinitionImplServiceDl.save(element);
	}

	@Override
	public SurveySectionDefinitionImpl get(SurveySectionDefinitionImpl element) {
		return surveySectionDefinitionImplServiceDl.get(element);
	}

	@Override
	public List<SurveySectionDefinitionImpl> getAll() {
		return surveySectionDefinitionImplServiceDl.getAll();
	}

	@Override
	public void delete(SurveySectionDefinitionImpl element) throws ValidationException {
		surveySectionDefinitionImplServiceDl.delete(element);
	}
	
	@Override
	public List<SurveySectionDefinitionImpl> getAllByUser(User user) {
		List<SurveySectionDefinitionImpl> sections = null;
		for (Iterator<UserPrivilege> privileges = user.getPrivileges().iterator(); privileges.hasNext(); ) {
			UserPrivilege up = privileges.next();
			if(up.isActive() && up.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER)) {
				sections = ((SurveyUserPrivilege) up).getSurveyDefinition().getSurveySections();
			}
		}
		return sections;
	}



}
