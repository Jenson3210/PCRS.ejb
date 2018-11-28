package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;

@Stateless
public class DbSurveySectionDefinitionServiceDl implements Serializable, ISurveySectionDefinitionServiceDl{

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionDefinition save(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition = em.merge(element);
		if(surveySectionDefinition == null)
		{
			throw new EmptyStackException();
		}
		return surveySectionDefinition;
	}

	@Override
	public SurveySectionDefinition get(SurveySectionDefinition element) {
		SurveySectionDefinition surveySectionDefinition = em.find(SurveySectionDefinition.class, element);
		if(surveySectionDefinition == null)
		{
			throw new EmptyStackException();
		}
		return surveySectionDefinition;
	}

	@Override
	public List<SurveySectionDefinition> getAll() {
		TypedQuery<SurveySectionDefinition> q = em.createNamedQuery("SURVEYSECTIONDEFINITION.GETALL", SurveySectionDefinition.class);
		List<SurveySectionDefinition> listOfSurveySectionDefinitions = q.getResultList();
		return listOfSurveySectionDefinitions;
	}

	@Override
	public void delete(SurveySectionDefinition element) {
		element = em.merge(element);
		if(element != null)
		{
			em.remove(element);
		}
		else {
			throw new EmptyStackException();
		}
	}

	@Override
	public List<SurveySectionDefinition> getSurveySectionDefinitionsForTitle(SurveySectionTitle t) {
		TypedQuery<SurveySectionDefinition> q = em.createNamedQuery("SURVEYSECTIONDEFINITION.GETSURVEYSECTIONDEFINITIONSFORTITLE", SurveySectionDefinition.class);
		q.setParameter("title", t);
		List<SurveySectionDefinition> listOfSurveySectionDefinitions = q.getResultList();
		return listOfSurveySectionDefinitions;
	}

}
