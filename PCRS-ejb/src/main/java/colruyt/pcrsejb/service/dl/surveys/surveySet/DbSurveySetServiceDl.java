package colruyt.pcrsejb.service.dl.surveys.surveySet;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privilege.PrivilegeType;
import colruyt.pcrsejb.entity.user.privilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;

@Stateless
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
		
		}

	@Override
	public SurveySet get(SurveySet element) {
		SurveySet  surveySet = em.find(SurveySet.class, element.getId());
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

	@Override
	public SurveySet getLatestSetFor(User user) throws NoSurveySetException { 
		
		try {
		User u = em.find(User.class, user.getId());
		
		TeamMemberUserPrivilege privi = (TeamMemberUserPrivilege)u.getPrivileges().stream().filter(x->x.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER) && x.isActive()).findFirst().get();
		
		TreeSet<SurveySet> tree = new TreeSet<>(privi.getSurveySetTreeSet());
		
		return tree.first();
		
		}
		catch(NoSuchElementException e) {
			throw new NoSurveySetException();
		}
		
		
	}



}
