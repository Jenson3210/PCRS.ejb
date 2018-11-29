package colruyt.pcrsejb.service.dl.surveys.surveySet;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
public class DbSurveySetServiceDl implements Serializable, ISurveySetServiceDl {

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySet save(SurveySet element) {
		SurveySet surveySet;
		if(element.getId() == null)
		{
			em.persist(element);
			surveySet=element;
		}
		else
		{
			surveySet=em.merge(element);
		}
		return surveySet;
		
		/*SurveySet surveySet = em.merge(element);
		if(surveySet == null)
		{
			throw new EmptyStackException();
		}
		return surveySet;*/
	}

	@Override
	public SurveySet get(SurveySet element) {
		SurveySet  surveySet = em.find(SurveySet.class, element);
		if(surveySet == null)
		{
			throw new EmptyStackException();
		}
		return surveySet;
	}

	@Override
	public List<SurveySet> getAll() {
		TypedQuery<SurveySet> q = em.createNamedQuery("SURVEYSET.GETALL", SurveySet.class);
		List<SurveySet> surveySetList = q.getResultList();
		return surveySetList;
	}

	@Override
	public void delete(SurveySet element) {
		element = em.merge(element);
		if (element != null) {
			em.remove(element);
		}
		else {
			throw new EmptyStackException();
		}
	}



}
