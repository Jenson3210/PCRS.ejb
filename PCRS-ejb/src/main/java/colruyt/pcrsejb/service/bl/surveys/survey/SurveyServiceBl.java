package colruyt.pcrsejb.service.bl.surveys.survey;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveys.survey.Survey;
import colruyt.pcrsejb.service.dl.surveys.survey.ISurveyServiceDl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveyServiceBl implements Serializable, ISurveyServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveyServiceDl surveyService;

	@Override
	public Survey save(Survey element) throws ValidationException {
		
		try {
		return surveyService.save(element);
		}
		catch(Exception e) {
			throw new ValidationException("e");
		}
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
	public void delete(Survey element) throws ValidationException {
		// TODO Auto-generated method stub
		
	}
	
}
