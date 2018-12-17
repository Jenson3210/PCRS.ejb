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
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * USER PROFILE VIEW
 * @author jda1mbw
 */
@Named
@ViewScoped
public class UserProfileView implements Serializable {

	@Inject
	private WebUser webuser;
	private static final long serialVersionUID = 1L;
	private String newPassword, repeatPassword, currentPassword;  
	@EJB
	private IUserFacade userfac;
	@EJB 
	private ITeamFacade teamFacade;
	@EJB
	private ISurveySetFacade surveyFacade;
	private boolean hasTeam = true;
	
	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	public void init() { 
		this.setHasTeam(true);  

	}

	/**
	 * Method to check if the user has a team
	 * @return hasTeam
	 */
	public boolean isHasTeam() {
		return hasTeam;
	}

	/**
	 * Set has team
	 * @param hasTeam
	 */
	public void setHasTeam(boolean hasTeam) {
		this.hasTeam = hasTeam;
	}

	/**
	 * Get survey facade
	 * @return surveyFacade
	 */
	public ISurveySetFacade getSurveyFacade() {
		return surveyFacade;   
	}

	/**
	 * Set survey facade
	 * @param surveyFacade
	 */
	public void setSurveyFacade(ISurveySetFacade surveyFacade) {
		this.surveyFacade = surveyFacade;
	}

	/**
	 * Get name of the team leader
	 * @return
	 */
	public String getTeamLeaderName() {
		try {
			return this.teamFacade.getManagerForUser(webuser.getUser()).getFirstName();
		} catch (Exception e) {
			FacesContext context = FacesContext.getCurrentInstance();
			return context.getApplication().evaluateExpressionGet(context, "#{msgs['error.noteam']}", String.class);
		}
	}

	/**
	 * 
	 * @return newPassword
	 */
	public String getNewpassword() {
		return newPassword;
	}

	/**
	 * Set new password
	 * @param newpassword
	 */
	public void setNewpassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * Get the repeated password
	 * @return repeatPassword
	 */
	public String getRepeatpassword() {
		return repeatPassword;
	}

	/**
	 * Set the repeated password
	 * @param repeatpassword
	 */
	public void setRepeatpassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}

	/**
	 * Get the current password
	 * @return currentPassword
	 */
	public String getCurrentpassword() {
		return currentPassword;
	}

	/**
	 * Set the current password
	 * @param currentpass
	 */
	public void setCurrentpassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	/**
	 * Get the name of the team
	 * @return teamName
	 */
	public String getTeamName() {
		try {
			return this.teamFacade.getTeamForUser(this.getUser()).getName();
		} catch (UserIsNotMemberOfTeamException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			this.setHasTeam(false);
			return context.getApplication().evaluateExpressionGet(context, "#{msgs['error.noteam']}", String.class);		
		}
	}

	/**
	 * Get user
	 * @return user
	 */
	public UserBo getUser() {
		return this.webuser.getUser();
	}

	/**
	 * Set user
	 * @param user
	 */
	public void setUser(UserBo user) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().put("user", user);
	}

	/**
	 * Change password
	 */
	public void changePassword() { 
		FacesContext context = FacesContext.getCurrentInstance();
		if (this.isCurrentPassword() && this.isSamePassword()) {
			this.getUser().setPassword(newPassword);
			try {
				this.setUser(userfac.save(this.getUser()));
			} catch (ValidationException e) {
				//NOP
			}
			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['succes.changepass']}",
					String.class);
			String title = context.getApplication().evaluateExpressionGet(context, "#{msgs['succes.changepass.title']}",
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, title, message);
			context.addMessage(null, myFacesMessage);
		}
	}

	/**
	 * Method to check if the password is the same
	 * @return boolean
	 */
	public boolean isSamePassword() {
		if (this.newPassword.isEmpty() || this.repeatPassword.isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.required']}", 
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message,"");
			context.addMessage(null, myFacesMessage);
			return false;
		} else {
			if (!this.newPassword.equals(this.repeatPassword)) {
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

	/**
	 * Method to check if the current password is correct
	 * @return boolean
	 */
	public boolean isCurrentPassword() {
		if (this.currentPassword.isEmpty()) {
			FacesContext context = FacesContext.getCurrentInstance();
			String message = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.required']}",
					String.class);
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,  message,"" );
			context.addMessage(null, myFacesMessage);
			return false;		
		} else {
			if (!this.currentPassword.equals(this.getUser().getPassword())) {
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
	
	/**
	 * Gives the percentage of the manager survey
	 * @return percentage
	 */
	public Integer getManagerSurveyPercentage() { 
		try {
			return this.getSurveyFacade().getPercentageCompleteForManagerSurvey(webuser.getUser());
		} catch (NoSurveySetException e) {
			return 0;
		}
	}

	/**
	 * Gives the percentage of the member survey
	 * @return percentage
	 */
	public Integer getMemberSurveyPercentage() {
		try {
			return this.getSurveyFacade().getPercentageCompleteForMemberSurvey(this.teamFacade.getManagerForUser(webuser.getUser()));
		} catch (NoSurveySetException e) {
			return 0;
		} catch (UserIsNotMemberOfTeamException e) {
			return 0;
		}
	}

	/**
	 * Gives the percentage of the consensus survey
	 * @param user
	 * @return percentage
	 */
	public Integer getConsensusSurveyPercentage(UserBo user) {
		try {
			return this.getSurveyFacade().getPercentageCompleteForConsensusSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}
	}
}
