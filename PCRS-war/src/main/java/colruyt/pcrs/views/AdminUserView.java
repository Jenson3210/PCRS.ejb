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
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * ADMIN USER VIEW
 * @author jda1mbw
 */
@Named
@ViewScoped
public class AdminUserView implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private IUserFacade userFacade;
	private UserBo addedUser;
	private List<UserBo> users; 
	private Boolean adminSelected;

	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct 
	private void fillusers() {
		users = userFacade.getAll();
	}

	/**
	 * Get a list of users
	 * @return users
	 */
	public List<UserBo> getUsers() {
		return users;
	}
	
	/**
	 * Set a list of users
	 * @param users
	 */
	public void setUsers(List<UserBo> users) {
		this.users = users;
	}

	/**
	 * Get the added user
	 * @return addedUser
	 */
	public UserBo getAddedUser() {
		return addedUser;
	}

	/**
	 * Set the added user
	 * @param addedUser
	 */
	public void setAddedUser(UserBo addedUser) {
		this.addedUser = addedUser;
		adminSelected = false;
		for (UserPrivilegeBo up : addedUser.getPrivileges()) {
			if (up.getPrivilegeType().equals(PrivilegeTypeBo.ADMINISTRATOR)) {
				adminSelected = true;
			}
		}
	}

	/**
	 * Create new user
	 */
	public void newUser() {
        addedUser = new UserBo(); 
        adminSelected = false;
    }
	
	/**
	 * Add user
	 * @throws ValidationException 
	 */
	public void addUser() throws ValidationException {
		Set<UserPrivilegeBo> privs = new HashSet<UserPrivilegeBo>();
		if (adminSelected) {
			privs.add(new UserPrivilegeBo(PrivilegeTypeBo.ADMINISTRATOR, true));
		}
		addedUser.setPrivileges(privs);
		users.add(userFacade.save(addedUser));
    }
	
	/**
	 * Edit user
	 * @throws ValidationException 
	 */
	public void editUser() throws ValidationException {
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
	
	/**
	 * Delete user
	 */
	public void deleteUser() {
		UserBo u = null;
		for (UserBo user : users) {
			if (user.getId() == addedUser.getId()) {
				u = user;
			}
		}
		users.remove(u);
		try {
			userFacade.delete(addedUser);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
		adminSelected = false;
	}
	
	/**
	 * Method to show if there's an admin privilege
	 * @param userBo
	 * @return boolean
	 */
	public Boolean hasAdminPrivilege(UserBo userBo)
	{
		return userFacade.hasPrivilege(userBo, PrivilegeTypeBo.ADMINISTRATOR, true);
	}

	/**
	 * Method to show admin selected
	 * @return adminSelected
	 */
	public Boolean getAdminSelected() {
		return adminSelected;
	}

	/**
	 * Set the admin selected
	 * @param adminSelected
	 */
	public void setAdminSelected(Boolean adminSelected) {
		this.adminSelected = adminSelected;
	} 
}

