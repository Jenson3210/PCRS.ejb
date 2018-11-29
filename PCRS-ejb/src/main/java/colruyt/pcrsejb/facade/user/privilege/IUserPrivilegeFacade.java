package colruyt.pcrsejb.facade.user.privilege;

import javax.ejb.Remote;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.IFacade;

@Remote
public interface IUserPrivilegeFacade extends IFacade<UserPrivilegeBo>{
	public UserPrivilegeBo grantUserPrivilegeToUser(UserBo user, UserPrivilegeBo userPrivilege);
	public void revokeUserPrivilegeFromUser(UserBo user, UserPrivilegeBo userPrivilege);
}
