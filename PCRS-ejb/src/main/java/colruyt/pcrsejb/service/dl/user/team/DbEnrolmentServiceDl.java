package colruyt.pcrsejb.service.dl.user.team;

import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.team.Enrolment;

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
		return em.createQuery("select e from Enrolment", Enrolment.class).getResultList();
	}

	@Override
	public void delete(Enrolment element) {
		Enrolment enrolment = em.find(Enrolment.class, element);
		if (enrolment != null) {
			em.remove(element);
		}
	}

}
