package colruyt.pcrsejb.service.dl.user;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.IDbService;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;

@Local
public interface IUserServiceDl extends IDbService<User> {

	User getElementByEmail(String email) throws NoExistingEmailException;
	List<User> getUsersByShortName(String shortName);
}
