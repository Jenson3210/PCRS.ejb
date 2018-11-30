package colruyt.pcrsejb.service.bl.user.team;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.service.bl.user.privilege.IUserPrivilegeServiceBl;
import colruyt.pcrsejb.service.dl.user.team.ITeamServiceDl;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Stateless
public class TeamServiceBl implements Serializable,ITeamServiceBl {

	/**
	 * 
	 */
	@EJB
	private ITeamServiceDl dlService;
	@EJB
	private IUserPrivilegeServiceBl userPrivilegeServiceBl;	
	
	private static final long serialVersionUID = 1L;

	public User getManagerOfUser(User u) {
		return null;
	}

	@Override
	public Team save(Team element) {
		return this.dlService.save(element);
	}

	@Override
	public Team get(Team element) {
		return this.dlService.get(element);
	}

	@Override
	public List<Team> getAll() {
		return this.dlService.getAll();
	}

	@Override
	public void delete(Team element) {
		 this.dlService.delete(element);
	}

	@Override
	public User getManagerForUser(User user) throws UserIsNotMemberOfTeamException {
		return this.dlService.getManagerForUser(user);
	}

	@Override
	public Team getTeamForUser(User user) throws UserIsNotMemberOfTeamException{
		return this.dlService.getTeamForUser(user);
	}

	@Override
	public List<Team> getTeamsOfManager(User manager) {
		return this.dlService.getTeamsOfManager(manager);
	}

	@Override
	public void removeUserFromTeam(Team convertToEntity, User convertToEntity2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Enrolment addUserToTeam(Team team, User user, String userPrivilege) throws MemberAlreadyHasATeamException {
		UserPrivilege enrolmentUserPrivilege = userPrivilegeServiceBl.setUserPrivilege(user, userPrivilege);
		
    	Enrolment enrolment = new Enrolment();
    	enrolment.setUserPrivilege(enrolmentUserPrivilege);
    	enrolment.setActive(true);
    	
    	team.getEnrolments().add(enrolment);
    	
    	save(team);
    	return enrolment;
	}

	@Override
	public List<User> getUsersOfTeam(Team team) {
	
		return this.dlService.getUsersOfTeam(team);
	}
	
	
}
