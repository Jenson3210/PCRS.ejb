package colruyt.pcrsejb.service.bl.user.privilege;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.user.privilege.IUserPrivilegeServiceDl;

@Stateless
public class UserPrivilegeServiceBl implements Serializable, IUserPrivilegeServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	IUserPrivilegeServiceDl userPrivilegeServiceDl;

	@Override
	public UserPrivilege save(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrivilege get(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserPrivilege> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserPrivilege element) {
		// TODO Auto-generated method stub
		
	}
	
}
