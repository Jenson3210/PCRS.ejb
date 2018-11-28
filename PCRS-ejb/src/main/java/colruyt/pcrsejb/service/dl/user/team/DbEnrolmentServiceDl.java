package colruyt.pcrsejb.service.dl.user.team;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.user.team.Enrolment;

@Stateless
public class DbEnrolmentServiceDl implements IEnrolmentServiceDl{
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	@Override
	public Enrolment save(Enrolment element) {
		try {
			em.persist(element);
		} catch (PersistenceException e) {
			em.find(Enrolment.class, element.getId());
			element = em.merge(element);
		}
		return element;
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
			enrolment = em.merge(enrolment);
			em.remove(enrolment);
			em.createNamedQuery("ENROLMENT.DEACTIVATE", Enrolment.class)
			.setParameter("active", false)
			.setParameter("id", enrolment.getUserPrivilege().getId())
			.executeUpdate();
		}
	}

}
