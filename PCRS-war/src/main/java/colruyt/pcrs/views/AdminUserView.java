package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.user.IUserFacade;

@Named
@ViewScoped
public class AdminUserView implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private IUserFacade userFacade;
	private UserBo addedUser;
	private List<UserBo> users; 
	private Boolean adminSelected;

	@PostConstruct 
	private void fillusers() {
		users = userFacade.getAll();
	}

	public List<UserBo> getUsers() {
		return users;
	}
	
	public void setUsers(List<UserBo> users) {
		this.users = users;
	}

	public UserBo getAddedUser() {
		return addedUser;
	}

	public void setAddedUser(UserBo addedUser) {
		this.addedUser = addedUser;
		adminSelected = false;
		for (UserPrivilegeBo up : addedUser.getPrivileges()) {
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.ADMINISTRATOR)) {
				adminSelected = true;
			}
		}
	}

	public void addUser() {
		Set<UserPrivilegeBo> privs = new HashSet<UserPrivilegeBo>();
		if (adminSelected) {
			privs.add(new UserPrivilegeBo(PrivilegeTypeBo.ADMINISTRATOR, true));
		}
		addedUser.setPrivileges(privs);
		users.add(userFacade.save(addedUser));
    }
	
	public void editUser() {
		UserBo u = null;
		for (UserBo user : users) {
			if (user.getId() == addedUser.getId()) {
				user.setFirstName(addedUser.getFirstName());
				user.setLastName(addedUser.getLastName());
				user.setCountry(addedUser.getCountry());
				user.setEmail(addedUser.getEmail());
				user.setPassword(addedUser.getPassword());
				user.setShortName(addedUser.getShortName());

				HashSet<UserPrivilegeBo> privs = (HashSet<UserPrivilegeBo>) user.getPrivileges();
				if (adminSelected) {
					if (!(hasAdminPrivilege(addedUser))) {
						addedUser.getPrivileges().add(new UserPrivilegeBo(PrivilegeTypeBo.ADMINISTRATOR, true));
					}
				}
				else {
					if (!(hasAdminPrivilege(addedUser))) {
						UserPrivilegeBo userPrivilegeBo = null;
						for (UserPrivilegeBo up : addedUser.getPrivileges()) {
							if (up.getPrivilegeType().equals(PrivilegeTypeBo.ADMINISTRATOR)) {
								userPrivilegeBo = up;
							}
						}
						addedUser.getPrivileges().remove(userPrivilegeBo);
					}
				}
				user.setPrivileges(privs);
				u = user;
			}
		}
		userFacade.save(u); 
	}
	
	public void deleteUser() {
		UserBo u = null;
		for (UserBo user : users) {
			if (user.getId() == addedUser.getId()) {
				u = user;
			}
		}
		users.remove(u);
		userFacade.delete(addedUser);
		adminSelected = false;
	}
	
	public Boolean hasAdminPrivilege(UserBo userBo)
	{
		return userFacade.hasPrivilege(userBo, PrivilegeTypeBo.ADMINISTRATOR, true);
	}

	public void newUser() {
        addedUser = new UserBo(); 
        adminSelected = false;
    }

	public Boolean getAdminSelected() {
		return adminSelected;
	}

	public void setAdminSelected(Boolean adminSelected) {
		this.adminSelected = adminSelected;
	} 
}

