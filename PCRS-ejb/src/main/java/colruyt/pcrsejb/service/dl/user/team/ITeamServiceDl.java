package colruyt.pcrsejb.service.dl.user.team;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.service.dl.IDbService;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Local
public interface ITeamServiceDl extends IDbService<Team> {
	
	User getManagerForUser(User user) throws UserIsNotMemberOfTeamException;
	Team getTeamForUser(User user) throws UserIsNotMemberOfTeamException;

}
