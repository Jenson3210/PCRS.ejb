package colruyt.pcrsejb.service.bl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityExistsException;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.service.dl.user.IUserServiceDl;
import colruyt.pcrsejb.util.exceptions.LoginException;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;
import colruyt.pcrsejb.util.exceptions.UserDoesNotExistException;
import colruyt.pcrsejb.util.exceptions.UserEmailAddressAlreadyExistsException;
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

	public User save(User user) throws ValidationException {
		try {
		return usersDb.save(user);
		
		}catch(Exception e) {	
			
			
				throw new UserEmailAddressAlreadyExistsException();
		}
	}

	public void delete(User user) throws ValidationException {
		try {
		usersDb.delete(user);
		}
		catch(EntityExistsException e) {
			throw new UserDoesNotExistException();
			
		}
	}

	public User get(User user) throws ValidationException{
		
		try {
		return usersDb.get(user);
		}
		catch(EntityExistsException e) {
			throw new UserDoesNotExistException();
			
		}
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

	@Override
	public User login(String email, String password) throws ValidationException {
		User u;
		try {
			u = this.usersDb.getElementByEmail(email);
			if(u.getPassword().equals(password)) {
				return u;
			} 
		}
			catch (NoExistingEmailException e) {
				throw new LoginException();
			}
		
		throw new LoginException();
			
	}
}
