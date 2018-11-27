package colruyt.pcrsejb.service.bl.user.team;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Local
public interface ITeamServiceBl extends IServiceBl<Team>{

	User getManagerForUser(User user) throws UserIsNotMemberOfTeamException;
	Team getTeamForUser(User user) throws UserIsNotMemberOfTeamException;
	
}
