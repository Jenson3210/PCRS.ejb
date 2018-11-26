package colruyt.pcrsejb.facade.user.team;

import javax.ejb.Remote;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.IFacade;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Remote
public interface ITeamFacade extends IFacade<TeamBo>  {
	
	
	UserBo getManagerForUser(UserBo user) throws UserIsNotMemberOfTeamException;
	TeamBo getTeamForUser(UserBo user) throws UserIsNotMemberOfTeamException;
	

}
