package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class DbSurveySectionTitleServiceDl implements Serializable, ISurveySectionTitleServiceDl {

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionTitle save(SurveySectionTitle element) {
		SurveySectionTitle surveySectionTitle;
		if (element.getId() == null) {
			em.persist(element);
			surveySectionTitle = element;
		} else {
			surveySectionTitle = em.merge(element);
		}
		return surveySectionTitle;

		/*
		 * SurveySectionTitle surveySectionTitle = em.merge(element);
		 * if(surveySectionTitle == null) { throw new EmptyStackException(); } return
		 * surveySectionTitle;
		 */
	}

	@Override
	public SurveySectionTitle get(SurveySectionTitle element) {
		SurveySectionTitle surveySectionTitle = em.find(SurveySectionTitle.class, element);
		if (surveySectionTitle == null) {
			throw new EmptyStackException();
		}
		return surveySectionTitle;
	}

	@Override
	public List<SurveySectionTitle> getAll() {
		TypedQuery<SurveySectionTitle> q = em.createNamedQuery("SURVEYSECTIONTITLE.GETALL", SurveySectionTitle.class);
		List<SurveySectionTitle> surveySectionTitleList = q.getResultList();
		return surveySectionTitleList;
	}

	@Override
	public void delete(SurveySectionTitle element) throws ValidationException {
		element = em.find(SurveySectionTitle.class, element.getId());
		if (element != null) {
			try {
				em.remove(element);
				em.flush();
			} catch (Exception e) {
				throw new ValidationException("Can not remove survey section title");
			}
		} else {
			throw new EmptyStackException();
		}
	}
}
