package colruyt.pcrs.views;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;

@Named
@SessionScoped
public class LogonView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserFacade userFacade;

	private String email; 
	private String password;
	
	@PostConstruct
	private void fillDb() {
		if (userFacade.getAll().isEmpty()) {
			Set<UserPrivilegeBo> privs = new HashSet<>();
			privs.add(new UserPrivilegeBo(PrivilegeTypeBo.ADMINISTRATOR, true));
			UserBo user = new UserBo("Root", "Woot", "Root.Woot@gmail.com", "RootWoot", "BE", "RoWoo", privs);
			userFacade.save(user);
		}
	}
	
	public void login() {

		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
		UserBo user = userFacade.getUserByEmail(email);
		if (user != null && this.password.equals(user.getPassword())) {
			context.getExternalContext().getSessionMap().put("user", user);
			try {
				context.getExternalContext().redirect("profile.xhtml");
				
			} catch (IOException e) {
				e.printStackTrace(); 
			}
		} else {
			// Send an error message on Login Failure
			context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));

		}
		
		
		}
		catch(NoExistingEmailException e) {
			context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
		}
		
	}

	public void logout() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("login.xhtml");
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}

	public void logoutURL() {
		logout();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}