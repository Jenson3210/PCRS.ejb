package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionRequirementLevel;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;

@Stateless
public class DbSurveySectionDefinitionServiceDl implements Serializable, ISurveySectionDefinitionServiceDl {
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;

	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionDefinition save(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition = em.merge(element);
		if (surveySectionDefinition == null) {
			throw new EmptyStackException();
		}
		return surveySectionDefinition;
	}

	@Override
	public SurveySectionDefinition get(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition = em.find(SurveySectionDefinition.class, element);
		if (surveySectionDefinition == null) {
			throw new EmptyStackException();
		}
		return surveySectionDefinition;
	}

	@Override
	public List<SurveySectionDefinition> getAll() {
		TypedQuery<SurveySectionDefinition> q = em.createQuery("SELECT ssd from SurveySectionDefinition ssd",
				SurveySectionDefinition.class);
		List<SurveySectionDefinition> surveySectionDefinitionList = q.getResultList();
		return surveySectionDefinitionList;
	}

	@Override
	public void delete(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition = em.find(SurveySectionDefinition.class, element);
		if (surveySectionDefinition != null) {
			em.remove(element);
		}
		else {
			throw new EmptyStackException();
		}
	}

	@Override
	public SurveySectionDefinition getSurveySectionTitle(SurveySectionTitle surveySectionTitle) {
		Query q = em.createQuery("SELECT ssd from SurveySectionDefinition ssd WHERE(sss.surveySectionTitle) = :surveySectionTitle");
		q.setParameter("surveySectionTitle", surveySectionTitle);
		return (SurveySectionDefinition) q.getSingleResult();
	}

	@Override
	public SurveySectionDefinition getSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy) {
		Query q = em.createQuery("SELECT ssd from SurveySectionDefinition ssd WHERE(sss.surveySectionStrategy) = :surveySectionStrategy");
		q.setParameter("surveySectionStrategy", surveySectionStrategy);
		return (SurveySectionDefinition) q.getSingleResult();
	}

	@Override
	public SurveySectionDefinition getSurveySectionRequirementLevel(
			SurveySectionRequirementLevel surveySectionRequirementLevel) {
		Query q = em.createQuery("SELECT ssd from SurveySectionDefinition ssd WHERE(sss.surveySectionRequirementLevel) = :surveySectionRequirementLevel");
		q.setParameter("surveySectionRequirementLevel", surveySectionRequirementLevel);
		return (SurveySectionDefinition) q.getSingleResult();
	}

	@Override
	public List<SurveySectionDefinition> getSurveySectionCompetences() {
		Query q = em.createQuery("SELECT ssd from SurveySectionDefinition ssd WHERE(sss.surveySectionCompetences) = :surveySectionCompetences");
		q.setParameter("surveySectionCompetences", surveySectionCompetences);
		return (List<SurveySectionDefinition>) q.getResultList();
	}

}
