package colruyt.pcrsejb.service.bl.user;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface IUserServiceBl extends IServiceBl<User> {
	public Boolean hasPrivilege(User user, PrivilegeType privilegeType, Boolean active);
	public User getUserByEmail(String email);
	public List<User> getUsersByShortName(String shortName);
}
