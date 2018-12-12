package colruyt.pcrsejb.service.bl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.service.dl.user.IUserServiceDl;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class UserServiceBl implements IUserServiceBl {

	@EJB
	private IUserServiceDl usersDb;

	public User getUserByEmail(String email) throws NoExistingEmailException {
		return usersDb.getElementByEmail(email); 
	}

	public List<User> getAll() { 
		return usersDb.getAll();
	}

	public User save(User user) {
		return usersDb.save(user);
	}

	public void delete(User user) throws ValidationException {
		usersDb.delete(user);
	}

	public User get(User user) {
		return usersDb.get(user);
	}
	

	public Boolean hasPrivilege(User user, PrivilegeType privilegeType, Boolean active) {
		Boolean hasPrivilege = false;
		for (UserPrivilege privilege : user.getPrivileges()) {
			if (privilege.getPrivilegeType().equals(privilegeType) && privilege.isActive() == active) {
				hasPrivilege = true;
			}
		}
		return hasPrivilege;
	}

	@Override
	public List<User> getUsersByShortName(String shortName) {
		return usersDb.getUsersByShortName(shortName);
	}

	@Override
	public User getUserByEnrolment(Enrolment enrolment) throws NoExistingMemberException {
		return usersDb.getUserByEnrolment(enrolment);
	}

	@Override
	public TeamMemberUserPrivilege getActiveTeamMemberPrivilege(User user) {
		TeamMemberUserPrivilege returnPrivilege = null;
		
		for(UserPrivilege tmup : user.getPrivileges()) {
			if(tmup.isActive() && tmup.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER)) {
				returnPrivilege = (TeamMemberUserPrivilege) tmup;
			}
		}
		return returnPrivilege;
	}
}
