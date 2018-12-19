package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.team.Team;
import colruyt.pcrsejb.util.exceptions.TeamHasNoManagerException;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class DbTeamServiceDl implements ITeamServiceDl {
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	

	@Override
	public Team save(Team element) {
		Team team;
		if(element.getId()==null)
		{
			em.persist(element);
			team = element;
		}
		else
		{
			team = em.merge(element);
		}
		return team;
		
		
		/*return em.merge(element);*/
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
		Team team = em.find(Team.class, element.getId());
		if (team != null) {
			em.remove(team);
		}
	}

	@Override
	public User getManagerForUser(User user) throws ValidationException{
		Team team = this.getTeamForUser(user);
		return this.getManagerOfTeam(team);
	}

	@Override
	public Team getTeamForUser(User user) throws ValidationException{
		
		TypedQuery<Team> q = em.createNamedQuery("TEAM.GETTEAMFORUSER", Team.class);
		q.setParameter("member", user);
		q.setParameter("isActive", true);
	
		try {
			
		List<Team> teams = 	q.getResultList();
		Team team = teams.stream().filter(x-> this.checkUserMetPrivilege(x, PrivilegeType.TEAMMEMBER)).findFirst().get();
		return team;
		}
		catch(NoSuchElementException e) {
			throw new UserIsNotMemberOfTeamException();
		}
		
		catch(NonUniqueResultException ex) {
			throw new IllegalArgumentException("User mag maar in 1 team zitten");
		}
		
	}
	
	private boolean checkUserMetPrivilege(Team team,PrivilegeType type) {
		return team.getEnrolments().stream()
				.filter(x->x.getUserPrivilege().getPrivilegeType().equals(type) && x.isActive())
				.collect(Collectors.toList()).size() > 0;
	}
	
	

	@Override
	public List<Team> getTeamsOfManager(User manager) {
		TypedQuery<Team> q = em.createNamedQuery("TEAM.GETTEAMSOFMANAGER", Team.class);
		
		q.setParameter("privilegeType", PrivilegeType.TEAMMANAGER);
		
		q.setParameter("teamManager", manager);
		
		List<Team> listOfTeams = q.getResultList();
		return listOfTeams;
	}

	@Override
	public User getManagerOfTeam(Team team) throws ValidationException {
		TypedQuery<User> q = em.createNamedQuery("TEAM.GETMANAGEROFTEAM", User.class);
		
		q.setParameter("userPrivilegeType", PrivilegeType.TEAMMANAGER);
		q.setParameter("team", team);
		
		User user;
		try {
			user = q.getSingleResult(); 
		} catch(PersistenceException e) {
			throw new TeamHasNoManagerException();
		}
		
		return user;
		
	}

	@Override
	public List<User> getUsersOfTeam(Team team) {
		TypedQuery<User> q = em.createNamedQuery("TEAM.GETUSERSOFTEAM", User.class);
		
		q.setParameter("team", team);
		
		List<User> listOfUsers = q.getResultList();
		return listOfUsers;
	}

}
