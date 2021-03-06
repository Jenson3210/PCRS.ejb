package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
	public Team getTeamForUser(User user){

		/*
		select t From Team t, User u join t.enrolments e join e.userPrivilege up where up.active = :isActive and " +
			"e.active = :isActive and u = :member and up.privilegeType = :privilagetype
		 */
		Team t = null;
		TypedQuery<Team> q = em.createNamedQuery("TEAM.GETTEAMFORUSER", Team.class);
		q.setParameter("u_id", user.getId());
		q.setParameter("p_type", PrivilegeType.TEAMMEMBER);
		List resultList = q.getResultList();
		if (resultList != null && !resultList.isEmpty()) {
			t = (Team) resultList.get(0);     
	    }
		return t;
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
