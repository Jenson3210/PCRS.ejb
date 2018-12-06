package colruyt.pcrsejb.service.dl.user.privilege;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.IDbService;

@Local
public interface IUserPrivilegeServiceDl extends IDbService<UserPrivilege> {

}
