package colruyt.pcrsejb.service.bl.user.privilege;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;

@Local
public interface IUserPrivilegeServiceBl extends IServiceBl<UserPrivilege> {

	UserPrivilege grantUserPrivilegeToUser(User convertToEntity, UserPrivilege convertToEntity2);
	void revokeUserPrivilegeToUser(User convertToEntity, UserPrivilege convertToEntity2);
	UserPrivilege setUserPrivilege(User user, String userPrivilege) throws MemberAlreadyHasATeamException;
}
