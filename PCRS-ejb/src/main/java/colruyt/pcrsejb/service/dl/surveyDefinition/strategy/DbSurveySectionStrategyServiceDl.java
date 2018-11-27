package colruyt.pcrsejb.service.dl.surveyDefinition.strategy;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;

@Stateless
public class DbSurveySectionStrategyServiceDl implements Serializable, ISurveySectionStrategyServiceDL{
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionStrategy save(SurveySectionStrategy element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SurveySectionStrategy get(SurveySectionStrategy element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySectionStrategy> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySectionStrategy element) {
		// TODO Auto-generated method stub
		
	}
	
	
}
