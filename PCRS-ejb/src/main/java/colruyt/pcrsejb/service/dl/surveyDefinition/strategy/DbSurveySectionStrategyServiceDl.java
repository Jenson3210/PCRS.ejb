package colruyt.pcrsejb.service.dl.surveyDefinition.strategy;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;

@Stateless
public class DbSurveySectionStrategyServiceDl implements Serializable, ISurveySectionStrategyServiceDL{
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionStrategy save(SurveySectionStrategy element) {
		SurveySectionStrategy surveySectionStrategy = em.merge(element);
		if (surveySectionStrategy == null) {
			throw new EmptyStackException();
		}
		return surveySectionStrategy;
	}

	@Override
	public SurveySectionStrategy get(SurveySectionStrategy element) {
		SurveySectionStrategy surveySectionStrategy = em.find(SurveySectionStrategy.class, element.getId());
		if (surveySectionStrategy == null) {
			throw new EmptyStackException();
		}
		return surveySectionStrategy;
	}

	@Override
	public List<SurveySectionStrategy> getAll() {
		TypedQuery<SurveySectionStrategy> q = em.createNamedQuery("SURVEYSECTIONSTRATEGY.GETALL", SurveySectionStrategy.class);
		List<SurveySectionStrategy> surveySectionStrategyList = q.getResultList();
		return surveySectionStrategyList;
	}

	@Override
	public void delete(SurveySectionStrategy element) {
		SurveySectionStrategy surveySectionStrategy = em.find(SurveySectionStrategy.class, element);
		if (surveySectionStrategy == null) {
			throw new EmptyStackException();
		}
		em.remove(element);
		
	}
	
	
}
