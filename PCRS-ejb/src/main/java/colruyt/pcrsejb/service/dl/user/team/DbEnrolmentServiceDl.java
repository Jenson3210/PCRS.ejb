package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Enrolment;
import colruyt.pcrsejb.entity.user.team.Team;

@Stateless
public class DbEnrolmentServiceDl implements IEnrolmentServiceDl{
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	@Override
	public Enrolment save(Enrolment element) {
		return em.merge(element);
	}

	@Override
	public Enrolment get(Enrolment element) {
		return em.find(Enrolment.class, element.getId());
	}

	@Override
	public List<Enrolment> getAll() {
		TypedQuery<Enrolment> q = em.createNamedQuery("ENROLMENT.GETALL", Enrolment.class);
		List<Enrolment> listOfEnrolments = q.getResultList();
		return listOfEnrolments;
	}

	@Override
	public void delete(Enrolment element) {
		Enrolment enrolment = em.find(Enrolment.class, element.getId());
		if (enrolment != null) {
			em.remove(enrolment);
			element.getUserPrivilege().setActive(false);
			em.createNamedQuery("ENROLMENT.DEACTIVATE", Enrolment.class)
			.setParameter("active", false)
			.setParameter("id", element.getUserPrivilege().getId())
			.executeUpdate();
		}
	}

}
