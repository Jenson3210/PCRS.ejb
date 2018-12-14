package colruyt.pcrsejb.facade.surveys.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;
import colruyt.pcrsejb.converter.surveys.survey.SurveyConverter;
import colruyt.pcrsejb.service.bl.surveys.survey.ISurveyServiceBl;
import colruyt.pcrsejb.service.bl.surveys.survey.SurveyServiceBl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveyFacade implements Serializable, ISurveyFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveyServiceBl surveyService; 
	
	private SurveyConverter surveyConverter = new SurveyConverter();

	@Override
	public SurveyBo save(SurveyBo entityBo) throws ValidationException {
		return surveyConverter.convertToBo(surveyService.save(surveyConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveyBo get(SurveyBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveyBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveyBo entityBo) throws ValidationException {
		// TODO Auto-generated method stub
		
	}
	
}
