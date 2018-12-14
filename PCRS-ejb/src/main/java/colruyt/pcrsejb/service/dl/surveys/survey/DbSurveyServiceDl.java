package colruyt.pcrsejb.service.dl.surveys.survey;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class DbSurveyServiceDl implements ISurveyServiceDl {

	
	@PersistenceContext(unitName = "PCRSEJB")
	private EntityManager em;
	
	@Override
	public Survey save(Survey element) {
		Survey survey;
		if (element.getId() == null) {
			em.persist(element);
			survey = element;
		} else {
			survey = em.merge(element);
		}
		return survey;
	}

	@Override
	public Survey get(Survey element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Survey> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Survey element)   {
		// TODO Auto-generated method stub
		
		
	}

}
