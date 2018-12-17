package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.PersistenceException;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionTitleConverter;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionTitleServiceBl;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveySectionTitleFacade implements Serializable, ISurveySectionTitleFacade {

	@EJB
	private ISurveySectionTitleServiceBl surveySectionTitleServiceBl;
	private SurveySectionTitleConverter surveySectionTitleConverter = new SurveySectionTitleConverter();
	
	private static final long serialVersionUID = 1L;

	@Override
	public SurveySectionTitleBo save(SurveySectionTitleBo entityBo) throws ValidationException{
		return surveySectionTitleConverter.convertToBo(surveySectionTitleServiceBl.save(surveySectionTitleConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveySectionTitleBo get(SurveySectionTitleBo entityBo) throws ValidationException {
		return surveySectionTitleConverter.convertToBo(surveySectionTitleServiceBl.get(surveySectionTitleConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<SurveySectionTitleBo> getAll() {
		return surveySectionTitleConverter.convertToBos(surveySectionTitleServiceBl.getAll());
	}

	@Override
	public void delete(SurveySectionTitleBo entityBo) throws ValidationException {
		surveySectionTitleServiceBl.delete(surveySectionTitleConverter.convertToEntity(entityBo));
	}
}
