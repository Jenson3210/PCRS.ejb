package colruyt.pcrsejb.facade.user;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;

@Local
public interface IUserFacade extends IFacade<UserBo> {

	UserBo getUserByEmail(String email) throws NoExistingEmailException;
	Boolean hasPrivilege(UserBo userBo, PrivilegeTypeBo privilege, Boolean active);
	List<UserBo> getUsersByShortName(String shortName);
}
