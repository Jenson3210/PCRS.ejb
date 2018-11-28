package colruyt.pcrsejb.service.dl.user.privilege;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;
import colruyt.pcrsejb.entity.user.team.Enrolment;

@Stateless
public class DbUserPrivilegeServiceDl implements IUserPrivilegeServiceDl{
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	@Override
	public UserPrivilege save(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrivilege get(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
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
	
	@Override
	public UserPrivilege getActivePrivilege(User user) {
		return em.createNamedQuery("USER.GETACTIVEPRIVILEGE", UserPrivilege.class)
				.setParameter("userId", user.getId())
				.getSingleResult();
	}

}
