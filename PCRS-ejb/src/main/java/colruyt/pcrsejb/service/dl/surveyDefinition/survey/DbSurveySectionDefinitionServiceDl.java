package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class DbSurveySectionDefinitionServiceDl implements Serializable, ISurveySectionDefinitionServiceDl {

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionDefinition save(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition;
		if (element.getId() == null) {
			em.persist(element);
			surveySectionDefinition = element;
		} else {
			surveySectionDefinition = em.merge(element);
		}
		return surveySectionDefinition;

		/*
		 * SurveySectionDefinition surveySectionDefinition = em.merge(element);
		 * if(surveySectionDefinition == null) { throw new EmptyStackException(); }
		 * return surveySectionDefinition;
		 */
	}

	@Override
	public SurveySectionDefinition get(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition = em.find(SurveySectionDefinition.class, element.getId());
		if (surveySectionDefinition == null) {
			throw new EmptyStackException();
		}
		return surveySectionDefinition;
	}

	@Override
	public List<SurveySectionDefinition> getAll() {
		TypedQuery<SurveySectionDefinition> q = em.createNamedQuery("SURVEYSECTIONDEFINITION.GETALL",
				SurveySectionDefinition.class);
		List<SurveySectionDefinition> listOfSurveySectionDefinitions = q.getResultList();
		return listOfSurveySectionDefinitions;
	}

	// TODO: Add logic (given dependencies for element)
	@Override
	public void delete(SurveySectionDefinition element) throws ValidationException {
		element = em.find(SurveySectionDefinition.class, element.getId());
		if (element != null) {
			try {
				em.remove(element);
				em.flush();
			} catch (Exception e) {
				throw new ValidationException("Can not remove survey section definition");
			}
		} else {
			throw new EmptyStackException();
		}
	}

	@Override
	public List<SurveySectionDefinition> getSurveySectionDefinitionsForTitle(SurveySectionTitle t) {
		TypedQuery<SurveySectionDefinition> q = em.createNamedQuery(
				"SURVEYSECTIONDEFINITION.GETSURVEYSECTIONDEFINITIONSFORTITLE", SurveySectionDefinition.class);
		q.setParameter("title", t);
		List<SurveySectionDefinition> listOfSurveySectionDefinitions = q.getResultList();
		return listOfSurveySectionDefinitions;
	}

}
