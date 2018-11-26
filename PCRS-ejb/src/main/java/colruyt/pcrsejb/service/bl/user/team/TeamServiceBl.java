package colruyt.pcrsejb.service.bl.user.team;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.service.dl.user.team.ITeamServiceDl;

@Stateless
public class TeamServiceBl implements Serializable {

	/**
	 * 
	 */
	@EJB
	private ITeamServiceDl dlService;
	
	
	
	
	private static final long serialVersionUID = 1L;

	
	
	
	
}
