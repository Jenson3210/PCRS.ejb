package colruyt.pcrsejb.facade.user.team;

import javax.ejb.Remote;

import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.IFacade;

@Remote
public interface ITeamFacade extends IFacade<TeamBo>  {

}
