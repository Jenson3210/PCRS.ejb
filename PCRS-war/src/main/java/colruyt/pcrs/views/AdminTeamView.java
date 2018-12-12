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
      
	public List<TeamBo> getTeams() {
		return teams;
	} 

	public void setTeams(List<TeamBo> teams) {
		this.teams = teams;
	}

	public EnrolmentBo getManipulatedEnrolmentBo() {
		return manipulatedEnrolmentBo;
	}

	public void setManipulatedEnrolmentBo(EnrolmentBo manipulatedEnrolmentBo) {
		this.manipulatedEnrolmentBo  = manipulatedEnrolmentBo;
	}

	public TeamBo getManipulatedTeamBo() {
		return manipulatedTeamBo;
	}

	public void setManipulatedTeamBo(TeamBo manipulatedTeamBo) {
		this.manipulatedTeamBo = manipulatedTeamBo; 
	}

	public UserBo getUser() {
 		return user;   
	}

	public void setUser(UserBo user) {
		this.user = user;
	}

	public String getUserPrivilege() {
		return userPrivilege;
	}

	public void setUserPrivilege(String userPrivilege) {
		this.userPrivilege = userPrivilege;
	}

	public void newTeam() {
		manipulatedTeamBo = new TeamBo();
	}

	public void addTeam() {
		teams.add(teamFacade.save(manipulatedTeamBo));
		teamEnrolments.add(new TeamEnrolmentBo(manipulatedTeamBo));
	}

	public void newEnrolment() {
 		manipulatedEnrolmentBo = new EnrolmentBo();

	}
	
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

	public void addEnrolment() {
    	try {
    		EnrolmentBo enrolment = teamFacade.addUserToTeam(manipulatedTeamBo, user, userPrivilege);
			manipulatedTeamBo.getEnrolments().add(enrolment);
			for(TeamEnrolmentBo te : teamEnrolments) {
				if(te.getTeam().equals(manipulatedTeamBo)){
					te.addEnrolmentToMap(enrolment, user);
				}
			}
    	} catch (MemberAlreadyHasATeamException ex) {
    		
    	}
	}

	public List<UserBo> completeUser(String query) {
		return userFacade.getUsersByShortName("%" + query + "%");
	}
	
	public UserBo getUserFromEnrolment(EnrolmentBo enrolment){
		UserBo user = null;
		
		try {
			user = userFacade.getUserByEnrolment(enrolment);
		} catch (NoExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public List<TeamEnrolmentBo> getTeamEnrolments() {
		return teamEnrolments; 
	}

	public void setTeamEnrolments(List<TeamEnrolmentBo> teamEnrolments) {
		this.teamEnrolments = teamEnrolments;
	}
	
}
