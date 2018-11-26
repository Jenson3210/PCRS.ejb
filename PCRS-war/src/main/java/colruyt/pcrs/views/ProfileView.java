package colruyt.pcrs.views;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Named
@SessionScoped
public class ProfileView implements Serializable{

	/**
	 * 
	 */
	
	private String newpassword, repeatpassword, currentpass;

	@EJB
	private IUserFacade userfac;
	@EJB
	private ITeamFacade teamFacade;
	
	@Inject
	private WebUser webuser;

	
	
	private static final long serialVersionUID = 1L;

	public String getTeamLeaderNaam() {
		try {
		  return null;
		}
		catch(Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			return  context.getApplication().evaluateExpressionGet(context, "#{msgs['error.noteam']}",
					String.class);
		}
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRepeatpassword() {
		return repeatpassword;
	}

	public void setRepeatpassword(String repeatpassword) {
		this.repeatpassword = repeatpassword;
	}

	public String getCurrentpass() {
		return currentpass;
	}

	public void setCurrentpass(String currentpass) {
		this.currentpass = currentpass;
	}

	



	public String getTeamnaam(){
		//return this.teamFacade.getTeam(this.getUser()).getName(); 
		return null;
	}

	public UserBo getUser() {
		return this.webuser.getUser();
	}

	public void setUser(UserBo user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("user", user);
	}

	public void changePass() {

		if (this.isCurrentPassword() && this.isSamePassword()) {

			this.getUser().setPassword(newpassword);	

			this.setUser(userfac.save(this.getUser()));
		}
	}

	public boolean isSamePassword() {
		if (!this.newpassword.equals(this.repeatpassword)) {

			FacesContext context = FacesContext.getCurrentInstance();
			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.passmissmatch']}",
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(message);

			context.addMessage(null, myFacesMessage);
			context.validationFailed();
			return  false;
		}
		else {
			return true;
		}
	}
	
	public boolean isCurrentPassword() {
		if(!this.currentpass.equals(this.getUser().getPassword())) {
			   FacesContext context = FacesContext.getCurrentInstance();
			   String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.wrongpassword']}", String.class);
			   FacesMessage myFacesMessage = new FacesMessage(message);
			   context.addMessage(null,myFacesMessage);

			   context.validationFailed();


			return false;
		} else {

			return true;
		}
	}

	
	
	
	
	
	
	
}
