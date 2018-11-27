package colruyt.pcrs.views;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;

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

    @PostConstruct
    private void fillList() {
        teams = teamFacade.getAll();
    }


    public void editEnrolment() {
        enrolmentFacade.save(manipulatedEnrolmentBo);
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
        this.manipulatedEnrolmentBo = manipulatedEnrolmentBo;
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
    	EnrolmentBo e = null;
    	for(TeamBo team : teams) {
        	for (EnrolmentBo enrolment : team.getEnrolments()) {
        		if(enrolment.getId() == manipulatedEnrolmentBo.getId()) {
        			e = enrolment;
        		}
        	}
        	team.getEnrolments().remove(e);
        	
    	}
    	enrolmentFacade.delete(manipulatedEnrolmentBo);
    }
    
    public void addEnrolment() {
    	UserPrivilegeBo privilege;
    	EnrolmentBo enrolment = new EnrolmentBo();
    	
    	if(PrivilegeTypeBo.TEAMMEMBER.getShortName().equals(userPrivilege)) {
    		privilege = new TeamMemberUserPrivilegeBo();
    		privilege.setPrivilegeType(PrivilegeTypeBo.TEAMMEMBER);
    	}else {
    		privilege = new UserPrivilegeBo();
    		privilege.setPrivilegeType(PrivilegeTypeBo.TEAMMANAGER);
    	}
    	
		privilege.setActive(true);
		
    	enrolment.setUser(user);
    	enrolment.setUserPrivilege(privilege);
    	enrolment.setActive(true);
    	
    	manipulatedTeamBo.getEnrolments().add(enrolment);
    	teamFacade.save(manipulatedTeamBo);

    }
    
	
	public List<UserBo> completeUser(String query){
		return userFacade.getUsersByShortName("%"+query+"%");
	}
	
}
