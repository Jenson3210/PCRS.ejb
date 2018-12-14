package colruyt.pcrs.views;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.CreateScript;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingEmailException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Named
@SessionScoped
public class LogonView implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IUserFacade userFacade;
	
	@Inject
	private CreateScript createScript;

	private String email; 
	private String password;
	
	@PostConstruct
	private void fillDb() {
		createScript.fillCompetencesDb(false);
		if (userFacade.getAll().isEmpty()) {
			createScript.fillDb();
		}
	}
	
	public void login() {

		FacesContext context = FacesContext.getCurrentInstance();

		try {

			UserBo user = this.userFacade.login(email, password);
			if (user != null) {
				context.getExternalContext().getSessionMap().put("user", user);
				try {
					context.getExternalContext().redirect("profile.xhtml");

				} catch (IOException e) {
					context.addMessage("#myform", new FacesMessage("Authentication Failed. Check username or password."));

				}
			} else {
				// Send an error message on Login Failure
				context.addMessage("#myform", new FacesMessage("Authentication Failed. Check username or password."));

			}

		} catch (ValidationException e1) {

			context.addMessage("#myform", new FacesMessage("Authentication Failed. Check username or password."));
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