
package colruyt.pcrsejb.service.dl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;

@Stateless
public class DbSurveyDefinitionDl implements Serializable, ISurveyDefinitionDl {

	
	private static final long serialVersionUID = 1L;
	
	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	
	@Override
	public SurveyDefinition save(SurveyDefinition element) {
		SurveyDefinition surveyDefinition;
		if(element.getId()==null) {
			em.persist(element);
			surveyDefinition = element;
		} else {
			surveyDefinition = em.merge(element);
		}
		return surveyDefinition;
		
		/*SurveyDefinition surveyDefinition = null;
		try {
			surveyDefinition = em.find(SurveyDefinition.class, element.getId());
		}catch(Exception e) {}
		if(surveyDefinition == null)
		{
			em.persist(element);
			surveyDefinition = element;
		}
		else
		{
			element.setId(surveyDefinition.getId());
			surveyDefinition = em.merge(element);
		}
		return surveyDefinition;*/
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
		TypedQuery<SurveyDefinition> query = em.createNamedQuery("SURVEYDEFINITION.GETALL", SurveyDefinition.class);
		return query.getResultList();
	}

	@Override
	public void delete(SurveyDefinition element) {
		SurveyDefinition surveyDefinition = em.find(SurveyDefinition.class, element.getId());
		if (surveyDefinition != null) {
			em.remove(surveyDefinition);
		}
	}

	@Override
	public List<SurveyDefinition> getSurveyDefinitionsOfUser(User user) {
		TypedQuery<SurveyDefinition> q = em.createNamedQuery("SURVEYDEFINITION.GETBYRESPONSIBLE", SurveyDefinition.class);
		q.setParameter("responsibleUser", user);
		List<SurveyDefinition> listOfSurveyDefinitions = q.getResultList();
		return listOfSurveyDefinitions;

	}

	@Override
	public User getResponsible(SurveyDefinition surveyDefinition) {
		TypedQuery<User> q = em.createNamedQuery("SURVEYDEFINITION.GETRESPONSIBLE", User.class);
		q.setParameter("pt", PrivilegeType.SURVEYDEFINITIONRESPONSIBLE);
		q.setParameter("sd", surveyDefinition);
		User u = q.getSingleResult();
		return u;
	}


}


