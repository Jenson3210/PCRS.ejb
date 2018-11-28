package colruyt.pcrsejb.service.bl.user;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.user.IUserServiceDl;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;

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

	public void delete(User user) {
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
}
