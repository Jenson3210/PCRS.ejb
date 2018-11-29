package colruyt.pcrsejb.service.dl.user.privilege;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;

@Stateless
public class DbUserPrivilegeServiceDl implements IUserPrivilegeServiceDl{
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	@Override
	public UserPrivilege save(UserPrivilege element) {
		UserPrivilege userPrivilege;
		if(element.getId() == null)
		{
			em.persist(element);
			userPrivilege= element;
		}
		else
		{
			userPrivilege = em.merge(element);
		}
		return userPrivilege;
		
		/*return em.merge(element);*/
	}

	@Override
	public UserPrivilege get(UserPrivilege element) {
		return em.find(UserPrivilege.class, element.getId());
	}

	@Override
	public List<UserPrivilege> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(UserPrivilege element) {
		// TODO Auto-generated method stub
		
	}

}
