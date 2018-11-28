package colruyt.pcrsejb.facade.user.privilege;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.user.privilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.user.privilege.UserPrivilegeServiceBl;

@Stateless
public class UserPrivilegeFacade implements Serializable, IUserPrivilegeFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	UserPrivilegeServiceBl userPrivilegeServiceBl;
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

	public UserPrivilegeBo getActivePrivilege(UserBo user) {
		return userPrivilegeConverter.convertToBo(userPrivilegeServiceBl.getActivePrivilege(userConverter.convertToEntity(user)));
	}
}
