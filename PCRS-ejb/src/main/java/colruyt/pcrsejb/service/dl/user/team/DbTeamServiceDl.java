package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.user.team.Team;

public class DbTeamServiceDl implements ITeamServiceDl {
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	

	@Override
	public Team save(Team element) {
		
		return em.merge(element);
	}

	@Override
	public Team get(Team element) {
		
		return em.find(Team.class, element.getId());
	}

	@Override
	public List<Team> getAll() {
		
		return (List<Team>) em.createNamedQuery("Team.getAllElements").getResultList();
		
		
	}

	@Override
	public void delete(Team element) {
		em.remove(element);
		
	}

}
