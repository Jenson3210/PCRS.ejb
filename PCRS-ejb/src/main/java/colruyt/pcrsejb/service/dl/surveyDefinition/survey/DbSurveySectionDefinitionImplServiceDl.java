package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.user.User;

@Stateless
public class DbSurveySectionDefinitionImplServiceDl implements ISurveySectionDefinitionImplServiceDl {

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	@Override
	public SurveySectionDefinitionImpl save(SurveySectionDefinitionImpl element) {
		// TODO add logic for existing element
		SurveySectionDefinitionImpl impl = null;
		em.persist(element);
		impl = element;
		return impl;
	}

	@Override
	public SurveySectionDefinitionImpl get(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySectionDefinitionImpl> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub

	}

}
