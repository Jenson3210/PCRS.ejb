package colruyt.pcrsejb.facade.user.privilege;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.user.privilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.user.privilege.IUserPrivilegeServiceBl;

@Stateless
public class UserPrivilegeFacade implements Serializable, IUserPrivilegeFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	IUserPrivilegeServiceBl userPrivilegeServiceBl;
	UserPrivilegeConverter userPrivilegeConverter = new UserPrivilegeConverter();
	UserConverter userConverter = new UserConverter();

	@Override
	public UserPrivilegeBo save(UserPrivilegeBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrivilegeBo get(UserPrivilegeBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPrivilegeBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserPrivilegeBo entityBo) {
		// TODO Auto-generated method stub
	}

	@Override
	public UserPrivilegeBo grantUserPrivilegeToUser(UserBo user, UserPrivilegeBo userPrivilege) {
		return userPrivilegeConverter.convertToBo(userPrivilegeServiceBl.grantUserPrivilegeToUser(userConverter.convertToEntity(user), userPrivilegeConverter.convertToEntity(userPrivilege)));
	}

	@Override
	public void revokeUserPrivilegeFromUser(UserBo user, UserPrivilegeBo userPrivilege) {
		userPrivilegeServiceBl.revokeUserPrivilegeToUser(userConverter.convertToEntity(user), userPrivilegeConverter.convertToEntity(userPrivilege));
	}
	
	
	
}
