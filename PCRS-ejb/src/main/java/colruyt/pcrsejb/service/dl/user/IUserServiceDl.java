package colruyt.pcrsejb.service.dl.user;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;

@Local
public interface IUserServiceDl extends IDbService<User> {

	User getElementByEmail(String email);

}
