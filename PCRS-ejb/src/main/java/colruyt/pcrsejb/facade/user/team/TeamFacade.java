package colruyt.pcrsejb.facade.user.team;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.user.team.TeamServiceBl;

@Stateless
public class TeamFacade implements Serializable, ITeamFacade {

	/**
	 * 
	 */
	
	@EJB
	private TeamServiceBl facade;
	
	
	private static final long serialVersionUID = 1L;

	@Override
	public TeamBo save(TeamBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TeamBo get(TeamBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TeamBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(TeamBo entityBo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UserBo getManagerForUser(UserBo user) {
		
		
		return null;
	}
	
}
