package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionDefinitionServiceDl;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionDefinitionCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionDefinitionNotFoundException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
import colruyt.pcrsejb.util.validators.surveyDefinition.survey.SurveySectionDefinitionValidator;

@Stateless
public class SurveySectionDefinitionServiceBl implements Serializable, ISurveySectionDefinitionServiceBl {

	private static final long serialVersionUID = 1L;

	@EJB
	private ISurveySectionDefinitionServiceDl surveySectionDefinitionDb;

	private SurveySectionDefinitionValidator surveySectionDefinitionValidator = new SurveySectionDefinitionValidator();

	@Override
	public SurveySectionDefinition save(SurveySectionDefinition element) throws ValidationException {
		surveySectionDefinitionValidator.validate(element);
		return surveySectionDefinitionDb.save(element);
	}

	@Override
	public SurveySectionDefinition get(SurveySectionDefinition element) throws ValidationException {
		try {
			return surveySectionDefinitionDb.get(element);
		} catch (EntityNotFoundException e) {
			throw new SurveySectionDefinitionNotFoundException();
		}
	}

	@Override
	public List<SurveySectionDefinition> getAll() {
		return surveySectionDefinitionDb.getAll();
	}

	@Override
	public void delete(SurveySectionDefinition element) throws ValidationException {
		try {
			surveySectionDefinitionDb.delete(element);
		} catch (EntityNotFoundException e) {
			throw new SurveySectionDefinitionNotFoundException();
		} catch (Exception e) {
			throw new SurveySectionDefinitionCantBeDeletedException();
		}
	}

	@Override
	public List<SurveySectionDefinition> getSurveySectionDefinitionsForTitle(SurveySectionTitle t) {
		return surveySectionDefinitionDb.getSurveySectionDefinitionsForTitle(t);
	}
}
