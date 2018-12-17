package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import colruyt.pcrs.DTO.TeamEnrolmentBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * The type Admin team view.
 */
@Named
@ViewScoped
public class AdminTeamView implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ITeamFacade teamFacade;
	@EJB
	private IEnrolmentFacade enrolmentFacade;
	@EJB
	private IUserFacade userFacade;
	private List<TeamBo> teams;
	private TeamBo manipulatedTeamBo;
	private EnrolmentBo manipulatedEnrolmentBo;
	private UserBo user;
	private String userPrivilege;
	private List<TeamEnrolmentBo> teamEnrolments = new ArrayList<>();
   
	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	private void fillList() {  
  		teams = teamFacade.getAll();
		for(TeamBo t : teams) {
			TeamEnrolmentBo teamEnrolment = new TeamEnrolmentBo(t);
			for (EnrolmentBo e : t.getEnrolments()) {
				teamEnrolment.addEnrolmentToMap(e, getUserFromEnrolment(e));
			}
			teamEnrolments.add(teamEnrolment);
		} 
	}

	/**
	 * Gets teams.
	 * @return the teams
	 */
	public List<TeamBo> getTeams() {
		return teams;
	}

	/**
	 * Sets teams.
	 * @param teams the teams
	 */
	public void setTeams(List<TeamBo> teams) {
		this.teams = teams;
	}

	/**
	 * Gets manipulated enrolment bo.
	 * @return the manipulated enrolment bo
	 */
	public EnrolmentBo getManipulatedEnrolmentBo() {
		return manipulatedEnrolmentBo;
	}

	/**
	 * Sets manipulated enrolment bo.
	 * @param manipulatedEnrolmentBo the manipulated enrolment bo
	 */
	public void setManipulatedEnrolmentBo(EnrolmentBo manipulatedEnrolmentBo) {
		this.manipulatedEnrolmentBo  = manipulatedEnrolmentBo;
	}

	/**
	 * Gets manipulated team bo.
	 * @return the manipulated team bo
	 */
	public TeamBo getManipulatedTeamBo() {
		return manipulatedTeamBo;
	}

	/**
	 * Sets manipulated team bo.
	 * @param manipulatedTeamBo the manipulated team bo
	 */
	public void setManipulatedTeamBo(TeamBo manipulatedTeamBo) {
		this.manipulatedTeamBo = manipulatedTeamBo; 
	}

	/**
	 * Gets user.
	 * @return the user
	 */
	public UserBo getUser() {
 		return user;   
	}

	/**
	 * Sets user.
	 * @param user the user
	 */
	public void setUser(UserBo user) {
		this.user = user;
	}

	/**
	 * Gets user privilege.
	 * @return the user privilege
	 */
	public String getUserPrivilege() {
		return userPrivilege;
	}

	/**
	 * Sets user privilege.a
	 * @param userPrivilege the user privilege
	 */
	public void setUserPrivilege(String userPrivilege) {
		this.userPrivilege = userPrivilege;
	}

	/**
	 * Create a new team.
	 */
	public void newTeam() {
		manipulatedTeamBo = new TeamBo();
	}

	/**
	 * Add a team.
	 */
	public void addTeam() {
		PrimeFaces pf = PrimeFaces.current();
		TeamBo tf = null;
		try {
			tf = teamFacade.save(manipulatedTeamBo);
			pf.ajax().addCallbackParam("validationSucces", true);

		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("addForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
		teams.add(tf);
		teamEnrolments.add(new TeamEnrolmentBo(manipulatedTeamBo));
	}

	/**
	 * Create a new enrolment.
	 */
	public void newEnrolment() {
 		manipulatedEnrolmentBo = new EnrolmentBo();

	}

	/**
	 * Add enrolment.
	 */
	public void addEnrolment() {
		PrimeFaces pf = PrimeFaces.current();
    	try {
    		EnrolmentBo enrolment = teamFacade.addUserToTeam(manipulatedTeamBo, user, userPrivilege);
			manipulatedTeamBo.getEnrolments().add(enrolment);
			for(TeamEnrolmentBo te : teamEnrolments) {
				if(te.getTeam().equals(manipulatedTeamBo)){
					te.addEnrolmentToMap(enrolment, user);
				}
			}
			pf.ajax().addCallbackParam("validationSucces", true);
    	} catch (MemberAlreadyHasATeamException | ValidationException ex) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("addForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));

		}
	}
	
	/**
	 * Delete an enrolment.
	 */
	public void deleteEnrolment() {
		for (TeamBo team : teams) {
			for (EnrolmentBo enrolment : team.getEnrolments()) {
				if (enrolment.getId() == manipulatedEnrolmentBo.getId()) {
					try {
						teamFacade.deleteUserFromTeam(team, enrolment, user);
					} catch (ValidationException e) {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
					}
					removeTeamEnrolment(team, enrolment);
				}
			}
		}
	}

	/**
	 * Remove an enrolment
	 * @param team
	 * @param enrolment
	 */
	private void removeTeamEnrolment(TeamBo team, EnrolmentBo enrolment) {
		for(TeamEnrolmentBo teb : teamEnrolments) {
			if(teb.getTeam().equals(team)) {
				Iterator<EnrolmentBo> iterator = teb.getEnrolmentMap().keySet().iterator();
				
				while (iterator.hasNext()) {
					EnrolmentBo e = iterator.next();
					if(enrolment.equals(e)) {
						iterator.remove();
					}
				}
			}
		}
	}

	/**
	 * Complete user list.
	 * @param query the query
	 * @return the list
	 */
	public List<UserBo> completeUser(String query) {
		return userFacade.getUsersByShortName("%" + query + "%");
	}

	/**
	 * Get user from enrolment user bo.
	 * @param enrolment the enrolment
	 * @return the user bo
	 */
	public UserBo getUserFromEnrolment(EnrolmentBo enrolment){
		UserBo user = null;
		
		try {
			user = userFacade.getUserByEnrolment(enrolment);
		} catch (NoExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	/**
	 * Gets team enrolments.
	 * @return the team enrolments
	 */
	public List<TeamEnrolmentBo> getTeamEnrolments() {
		return teamEnrolments; 
	}

	/**
	 * Sets team enrolments.
	 * @param teamEnrolments the team enrolments
	 */
	public void setTeamEnrolments(List<TeamEnrolmentBo> teamEnrolments) {
		this.teamEnrolments = teamEnrolments;
	}
	
}
