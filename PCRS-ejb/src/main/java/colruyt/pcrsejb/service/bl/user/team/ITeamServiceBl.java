package colruyt.pcrsejb.service.bl.user.team;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface ITeamServiceBl extends IServiceBl<Team>{

	User getManagerForUser(User user) throws UserIsNotMemberOfTeamException;
	Team getTeamForUser(User user) throws UserIsNotMemberOfTeamException;
	List<Team> getTeamsOfManager(User manager);
	void removeUserFromTeam(Team team, Enrolment enrolment, User user) throws ValidationException;
	Enrolment addUserToTeam(Team team, User user, String userPrivilege) throws MemberAlreadyHasATeamException;
	List<User> getUsersOfTeam(Team team);
}
