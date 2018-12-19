package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.service.dl.IDbService;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Local
public interface ITeamServiceDl extends IDbService<Team> {
	
	User getManagerForUser(User user) throws ValidationException;
	Team getTeamForUser(User user) throws ValidationException;
	List<Team> getTeamsOfManager(User manager);
	User getManagerOfTeam(Team team) throws ValidationException;
	List<User> getUsersOfTeam(Team team);
}
