package colruyt.pcrsejb.service.bl.user.privilege;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface IUserPrivilegeServiceBl extends IServiceBl<UserPrivilege> {
	public UserPrivilege getActivePrivilege(User user);
}
