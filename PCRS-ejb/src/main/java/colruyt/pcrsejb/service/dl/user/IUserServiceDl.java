package colruyt.pcrsejb.service.dl.user;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface IUserServiceDl extends IDbService<User> {

	User getElementByEmail(String email);
	List<User> getUsersByShortName(String shortName);
}
