package colruyt.pcrs.views;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;

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
	private SurveyDefinitionBo surveyDefinition;

	@PostConstruct
	private void fillList() {
		teams = teamFacade.getAll();
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
	}

	public void newEnrolment() {
		manipulatedEnrolmentBo = new EnrolmentBo();
	}

	public void deleteEnrolment() {
		System.out.println(manipulatedEnrolmentBo.getUser().getFirstName());
		EnrolmentBo e = null;
		for (TeamBo team : teams) {
			for (EnrolmentBo enrolment : team.getEnrolments()) {
				if (enrolment.getId() == manipulatedEnrolmentBo.getId()) {
					e = enrolment;
				}
			}
			if(e != null) {
				enrolmentFacade.delete(e);
				team.getEnrolments().remove(e);
			}
		}
	}

	public void addEnrolment() {
    	UserPrivilegeBo privilege = null;
    	EnrolmentBo enrolment = new EnrolmentBo();
    	
    	try {
    	if(PrivilegeTypeBo.TEAMMEMBER.getShortName().equals(userPrivilege)) {
    		List<TeamMemberUserPrivilegeBo> memberPrivs = new ArrayList<>();
    			for (UserPrivilegeBo p : user.getPrivileges()) {
        			if (p.getPrivilegeType().equals(PrivilegeTypeBo.TEAMMEMBER)) {
        				if (p.isActive()) {
        					//TODO FACESMESSAGE TOEVOEGEN
        					throw new MemberAlreadyHasATeamException();
        				}
        				memberPrivs.add((TeamMemberUserPrivilegeBo) p);
        			}
        		}
    			for (TeamMemberUserPrivilegeBo p : memberPrivs) {
    				if (p.getSurveyDefinition().getName().equalsIgnoreCase(surveyDefinition.getName())) {
    					privilege = p;
    				}
    			}	
    			if (privilege == null) {
    				privilege = new TeamMemberUserPrivilegeBo();
    	    		privilege.setPrivilegeType(PrivilegeTypeBo.TEAMMEMBER);
    	    		//((TeamMemberUserPrivilegeBo) privilege).setStartDateCurrentSurveyDefinition(LocalDate.now());
    	    		((TeamMemberUserPrivilegeBo) privilege).setSurveyDefinition(surveyDefinition);
    			}   	    		
        	}else {    		
    			for (UserPrivilegeBo p : user.getPrivileges()) {
        			if (p.getPrivilegeType().equals(PrivilegeTypeBo.TEAMMANAGER)) {
        				privilege = p;
        			}
        		}
        		if (privilege == null) {
        			privilege = new UserPrivilegeBo();
        			privilege.setPrivilegeType(PrivilegeTypeBo.TEAMMANAGER);
        		}
        	}
        	
    		privilege.setActive(true);
    		user.getPrivileges().add(privilege);
        	enrolment.setUser(user); 
        	enrolment.setActive(true);

        	manipulatedTeamBo.getEnrolments().add(enrolment);
        	
        	teamFacade.save(manipulatedTeamBo);
    	} catch (MemberAlreadyHasATeamException ex) {
    		
    	}
	}

	public List<UserBo> completeUser(String query) {
		return userFacade.getUsersByShortName("%" + query + "%");
	}

}
