package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.user.User;

@Stateless
public class DbSurveySectionDefinitionImplServiceDl implements ISurveySectionDefinitionImplServiceDl {

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	@Override
	public SurveySectionDefinitionImpl save(SurveySectionDefinitionImpl element) {
		// TODO add logic for existing element
		SurveySectionDefinitionImpl impl;
		if (element.getId() == null) {
			em.persist(element);
			impl = element;
		} else {
			impl = em.merge(element);
		}
		return impl;
	}

	@Override
	public SurveySectionDefinitionImpl get(SurveySectionDefinitionImpl element) {
		SurveySectionDefinitionImpl impl = em.find(SurveySectionDefinitionImpl.class, element.getId());
		if(element.getId() == null){
			throw new EmptyStackException();
		}
		return impl;
	}

	@Override
	public List<SurveySectionDefinitionImpl> getAll() {
		TypedQuery<SurveySectionDefinitionImpl> q = em.createNamedQuery("SURVEYSECTIONDEFINITIONIMPL.GETALL", SurveySectionDefinitionImpl.class);
		List<SurveySectionDefinitionImpl> listOfSurveySectionDefinitions = q.getResultList();
		return listOfSurveySectionDefinitions;
	}

	@Override
	public void delete(SurveySectionDefinitionImpl element) {
		element = em.merge(element);
		if(element != null){
			em.remove(element);
			em.flush();
		}
		else {
			throw new EmptyStackException();
		}
	}

}
