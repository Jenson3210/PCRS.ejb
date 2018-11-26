package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Stateless
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

	@Override
	public User getManagerForUser(User user) throws UserIsNotMemberOfTeamException{
		return null;
	}

	@Override
	public Team getTeamForUser(User user) throws UserIsNotMemberOfTeamException{
		
		TypedQuery<Team> query = em.createQuery("select t from Team t join t.enrolments enrolment where enrolment.user = ?1 and enrolment.active = ?2",Team.class);
		query.setParameter(1, user);
		query.setParameter(2, true);
		return	query.getSingleResult();
		
	
		
	}

}
