package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;

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
	private Map<TeamBo, Map<EnrolmentBo, UserBo>> teamMap = new TreeMap<TeamBo, Map<EnrolmentBo,UserBo>>();;

	@PostConstruct
	private void fillList() {
		teams = teamFacade.getAll();
		for(TeamBo t : teams) {
			Map<EnrolmentBo, UserBo> map = new TreeMap<>();
			for (EnrolmentBo e : t.getEnrolments()) {
				map.put(e, getUserFromEnrolment(e));
			}
			teamMap.put(t, map);
			
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
	}

	public void newEnrolment() {
		manipulatedEnrolmentBo = new EnrolmentBo();
	}

	public void deleteEnrolment() {
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
    	try {
    		EnrolmentBo enrolment = teamFacade.addUserToTeam(manipulatedTeamBo, user, userPrivilege);
			manipulatedTeamBo.getEnrolments().add(enrolment);
			addToTeamMap(manipulatedTeamBo, enrolment, user);
    	} catch (MemberAlreadyHasATeamException ex) {
    		
    	}
	}

	private void addToTeamMap(TeamBo team, EnrolmentBo enrolment, UserBo user) {
		for(TeamBo t : teamMap.keySet()) {
			if(t.equals(team)) {
				Map<EnrolmentBo, UserBo> map = new HashMap<>();
				map.put(enrolment, user);
				teamMap.put(t, map);
			}
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


	public Map<TeamBo, Map<EnrolmentBo, UserBo>> getTeamMap() {
		return teamMap;
	}

	public void setTeamMap(Map<TeamBo, Map<EnrolmentBo, UserBo>> teamMap) {
		this.teamMap = teamMap;
	}

	
}
