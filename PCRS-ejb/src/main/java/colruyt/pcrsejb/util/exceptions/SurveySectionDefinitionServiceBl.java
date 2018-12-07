package colruyt.pcrsejb.util.exceptions;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionTitle;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionServiceBl;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionDefinitionServiceDl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class SurveySectionDefinitionServiceBl implements Serializable,ISurveySectionDefinitionServiceBl {

	private static final long serialVersionUID = 1L;
	@EJB
	private ISurveySectionDefinitionServiceDl surveySectionDefinitionDb;

	@Override
	public SurveySectionDefinition save(SurveySectionDefinition element) {
		return surveySectionDefinitionDb.save(element);
	}

	@Override
	public SurveySectionDefinition get(SurveySectionDefinition element) {
		return surveySectionDefinitionDb.get(element);
	}

	@Override
	public List<SurveySectionDefinition> getAll() {
		return surveySectionDefinitionDb.getAll();
	}

	@Override
	public void delete(SurveySectionDefinition element) throws ValidationException {
		surveySectionDefinitionDb.delete(element);
	}

	@Override
	public List<SurveySectionDefinition> getSurveySectionDefinitionsForTitle(SurveySectionTitle t) {
		return surveySectionDefinitionDb.getSurveySectionDefinitionsForTitle(t);
	}
}