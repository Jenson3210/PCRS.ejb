package colruyt.pcrsejb.service.dl.user;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.user.User;

@Stateless
public class DbUserServiceDl implements Serializable, IUserServiceDl {
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public User save(User element) {
		User user = em.merge(element);
		if (user == null) {
			throw new EmptyStackException();
		}
		return user;
	}
	
	@Override
	public User get(User element) {
		User user = em.find(User.class, element);
		if (user == null) {
			throw new EmptyStackException();
		} 
		return user;
	}
	
	@Override
	public List<User> getAll() {
		TypedQuery<User> q = em.createQuery("SELECT u from User u", User.class);
		List<User> userList = q.getResultList();
		return userList;
	}
	
	@Override
	public void delete(User element) {
		element = em.merge(element);
		if (element != null) {
			em.remove(element);
		}
		else {
			throw new EmptyStackException();
		}
	}
	
	@Override
	public User getElementByEmail(String email) {
		Query q = em.createQuery("SELECT u from User u where UPPER(u.email) = UPPER(:email)");
		q.setParameter("email", email);
		return (User) q.getSingleResult();
	}

	@Override
	public List<User> getUsersByShortName(String shortName) {
		Query q = em.createQuery("SELECT u from User u where UPPER(u.shortname) = UPPER(:shortname)");
		q.setParameter("shortname", shortName);
		return (List<User>) q.getResultList();
	}
}
