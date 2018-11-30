package colruyt.pcrsejb.service.bl.surveys.survey;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.SurveyUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;

@Stateless
public class SurveySectionDefinitionImplServiceBl implements Serializable, ISurveySectionDefinitionImplBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionDefinitionImpl save(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveySectionDefinitionImpl get(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySectionDefinitionImpl> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub
		
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
