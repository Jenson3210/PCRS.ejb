<<<<<<< HEAD
package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;

@Stateless
public class DbSurveyDefinitionDl implements Serializable, ISurveyDefinitionDl {

	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	
	@Override
	public SurveyDefinition save(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.merge(element);
		if (surveyDefinition == null) {
			throw new EmptyStackException();
		}
		return surveyDefinition;
	}

	@Override
	public SurveyDefinition get(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.find(SurveyDefinition.class, element.getId());
		if (surveyDefinition == null) {
			throw new EmptyStackException();
		}
		return surveyDefinition;
	}

	@Override
	public List<SurveyDefinition> getAll() {
		TypedQuery<SurveyDefinition> query = em.createNamedQuery("SurveyDefinition.getAllSurveyDefinitions", SurveyDefinition.class);
		return query.getResultList();
	}

	@Override
	public void delete(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.find(SurveyDefinition.class, element);
		if (surveyDefinition == null) {
			throw new EmptyStackException();
		}
		em.remove(element);
	}

	@Override
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user) {
		TypedQuery<SurveyDefinition> q = em.createQuery("Select sd from SurveyDefinition sd where sd.responsibleUser = ?1",SurveyDefinition.class);
		return q.getResultList();
		
		
	}


}
=======
package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;

@Stateless
public class DbSurveyDefinitionDl implements Serializable, ISurveyDefinitionDl {

	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	
	@Override
	public SurveyDefinition save(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.merge(element);
		if (surveyDefinition == null) {
			throw new EmptyStackException();
		}
		return surveyDefinition;
	}

	@Override
	public SurveyDefinition get(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.find(SurveyDefinition.class, element.getId());
		if (surveyDefinition == null) {
			throw new EmptyStackException();
		}
		return surveyDefinition;
	}

	@Override
	public List<SurveyDefinition> getAll() {
		TypedQuery<SurveyDefinition> query = em.createNamedQuery("SurveyDefinition.getAllSurveyDefinitions", SurveyDefinition.class);
		return query.getResultList();
	}

	@Override
	public void delete(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.merge(element);
		if (null != surveyDefinition) {
			em.remove(surveyDefinition);
		} else {
			throw new EmptyStackException();
		}
	}


}
>>>>>>> branch 'master' of https://github.com/Jenson3210/PCRS.ejb.git
