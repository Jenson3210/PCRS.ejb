package colruyt.pcrsejb.service.dl.user.team;

import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;

@Stateless
public class DbTeamServiceDl implements ITeamServiceDl {
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	

	@Override
	public Team save(Team element) {
		Team team = em.find(Team.class, element.getId());
		if (team == null) {
			em.persist(element);
			team = element;
		}else {
			element.setId(team.getId());
			team = em.merge(element);
		}
		return team;
	}

	@Override
	public Team get(Team element) {
		return em.find(Team.class, element.getId());
	}

	@Override
	public List<Team> getAll() {
		TypedQuery<Team> q = em.createNamedQuery("TEAM.GETALL", Team.class);
		List<Team> listOfTeams = q.getResultList();
		return listOfTeams;
	}

	@Override
	public void delete(Team element) {
		element = em.merge(element);
		if (element != null) {
			em.remove(element);
		}
		else {
			throw new EmptyStackException();
		}
	}

	@Override
	public User getManagerForUser(User user) throws UserIsNotMemberOfTeamException{
		Team team = this.getTeamForUser(user);
		return team.getEnrolments().stream().filter(x-> x.getUserPrivilege().getPrivilegeType().equals(PrivilegeType.TEAMMANAGER) && x.isActive() )
											.findFirst().get().getUser();
	}

	@Override
	public Team getTeamForUser(User user) throws UserIsNotMemberOfTeamException{
		
		TypedQuery<Team> q = em.createNamedQuery("TEAM.GETTEAMFORUSER", Team.class);
		q.setParameter("member", user);
		q.setParameter("isActive", true);
		try {
		Team team = q.getSingleResult();
		return team;
		}
		catch(NoResultException e) {
			throw new UserIsNotMemberOfTeamException();
		}
		catch(NonUniqueResultException ex) {
			throw new IllegalArgumentException("User mag maar in 1 team zitten");
		}
		
	}

	@Override
	public List<Team> getTeamsOfManager(UserBo manager) {
		TypedQuery<Team> q = em.createNamedQuery("TEAM.GETTEAMSOFMANAGER", Team.class);
		q.setParameter("privilegeType", PrivilegeType.TEAMMANAGER);
		q.setParameter("teamManager", manager.getId());
		List<Team> listOfTeams = q.getResultList();
		return listOfTeams;
	}

}
