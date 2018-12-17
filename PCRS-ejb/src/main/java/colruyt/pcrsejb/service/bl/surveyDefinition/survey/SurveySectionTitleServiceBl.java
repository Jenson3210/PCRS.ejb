package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionTitleServiceDl;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleNotFoundException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.util.validators.surveyDefinition.survey.SurveySectionTitleValidator;

@Stateless
public class SurveySectionTitleServiceBl implements ISurveySectionTitleServiceBl, Serializable {

	
	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySectionTitleServiceDl surveySectionTitleDb;

	private SurveySectionTitleValidator surveySectionTitleValidator = new SurveySectionTitleValidator();
	
	@Override
	public SurveySectionTitle save(SurveySectionTitle element) throws ValidationException {
		surveySectionTitleValidator.validate(element);
		return surveySectionTitleDb.save(element);
	}

	@Override
	public SurveySectionTitle get(SurveySectionTitle element) throws ValidationException {
		try
		{
			return surveySectionTitleDb.get(element);
		}catch(EntityNotFoundException e)
		{
			throw new SurveySectionTitleNotFoundException();
		}
	}

	@Override
	public List<SurveySectionTitle> getAll() {
		return surveySectionTitleDb.getAll();
	}

	@Override
	public void delete(SurveySectionTitle element) throws ValidationException {
		try {
			surveySectionTitleDb.delete(element);
		} catch(EntityNotFoundException e)
		{
			throw new SurveySectionTitleNotFoundException();
		} catch(Exception e) {
			throw new SurveySectionTitleCantBeDeletedException();
		}
	}
}
