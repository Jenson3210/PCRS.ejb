package colruyt.pcrs.views;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Named
@ViewScoped
public class UserProfileView implements Serializable {

	private String newpassword, repeatpassword, currentpass; 

	@EJB
	private IUserFacade userfac;
	@EJB
	private ITeamFacade teamFacade;

	@EJB
	private ISurveySetFacade surveyFacade;

	private boolean hasTeam = true;

	@PostConstruct
	public void init() {
		this.setHasTeam(true);

	}

	public boolean isHasTeam() {
		return hasTeam;
	}

	public void setHasTeam(boolean hasTeam) {
		this.hasTeam = hasTeam;
	}

	public ISurveySetFacade getSurveyFacade() {
		return surveyFacade;
	}

	public void setSurveyFacade(ISurveySetFacade surveyFacade) {
		this.surveyFacade = surveyFacade;
	}

	@Inject
	private WebUser webuser;

	private static final long serialVersionUID = 1L;

	public String getTeamLeaderNaam() {
		try {
			return this.teamFacade.getManagerForUser(webuser.getUser()).getFirstName();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			return context.getApplication().evaluateExpressionGet(context, "#{msgs['error.noteam']}", String.class);

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

	public String getTeamnaam() {
		try {
			return this.teamFacade.getTeamForUser(this.getUser()).getName();
		} catch (UserIsNotMemberOfTeamException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			this.setHasTeam(false);
			return context.getApplication().evaluateExpressionGet(context, "#{msgs['error.noteam']}", String.class);
			
		}

	}

	public UserBo getUser() {
		return this.webuser.getUser();
	}

	public void setUser(UserBo user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("user", user);
	}

	public void changePass() { 

		FacesContext context = FacesContext.getCurrentInstance();
		if (this.isCurrentPassword() && this.isSamePassword()) {

			this.getUser().setPassword(newpassword);

			this.setUser(userfac.save(this.getUser()));

			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['succes.changepass']}",
					String.class);
			String title = context.getApplication().evaluateExpressionGet(context, "#{msgs['succes.changepass.title']}",
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, title, message);

			context.addMessage(null, myFacesMessage);
		}
	}

	public boolean isSamePassword() {
		if (this.newpassword.isEmpty() || this.repeatpassword.isEmpty()) {

			FacesContext context = FacesContext.getCurrentInstance();
			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.required']}", 
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,"");

			context.addMessage(null, myFacesMessage);
			return false;
		} else {

			if (!this.newpassword.equals(this.repeatpassword)) {

				FacesContext context = FacesContext.getCurrentInstance();
				String message = context.getApplication().evaluateExpressionGet(context,
						"#{msgs['error.passmissmatch']}", String.class);
				FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,"" );

				context.addMessage(null, myFacesMessage);

				return false;
			} else {
				return true;
			}
		}
	}

	public boolean isCurrentPassword() {

		if (this.currentpass.isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.required']}",
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,  message,"" );
			context.addMessage(null, myFacesMessage);
			return false;
		} else {

			if (!this.currentpass.equals(this.getUser().getPassword())) {
				FacesContext context = FacesContext.getCurrentInstance();
				String message = context.getApplication().evaluateExpressionGet(context,
						"#{msgs['error.wrongpassword']}", String.class);
				FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,  message,"" );
				context.addMessage(null, myFacesMessage);

				return false;
			} else {

				return true;
			}
		}
	}

}
