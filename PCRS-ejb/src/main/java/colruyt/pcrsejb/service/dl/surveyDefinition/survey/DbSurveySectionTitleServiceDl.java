package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;

@Stateless
public class DbSurveySectionTitleServiceDl implements Serializable, ISurveySectionTitleServiceDl{

	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionTitle save(SurveySectionTitle element) {
		SurveySectionTitle surveySectionTitle = em.merge(element);
		if(surveySectionTitle == null)
		{
			throw new EmptyStackException();
		}
		return surveySectionTitle;
	}

	@Override
	public SurveySectionTitle get(SurveySectionTitle element) {
		SurveySectionTitle  surveySectionTitle = em.find(SurveySectionTitle.class, element);
		if(surveySectionTitle == null)
		{
			throw new EmptyStackException();
		}
		return surveySectionTitle;
	}

	@Override
	public List<SurveySectionTitle> getAll() {
		TypedQuery<SurveySectionTitle> q = em.createQuery("SELECT s from SurveySectionTitle s", SurveySectionTitle.class);
		List<SurveySectionTitle> surveySectionTitleList = q.getResultList();
		return surveySectionTitleList;
	}

	@Override
	public void delete(SurveySectionTitle element) {
		element = em.merge(element);
		if (element != null) {
			em.remove(element);
		}
		else {
			throw new EmptyStackException();
		}
	}


}
