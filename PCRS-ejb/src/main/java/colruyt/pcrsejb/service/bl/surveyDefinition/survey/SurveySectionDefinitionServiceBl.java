package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinition;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionDefinitionServiceDl;

@Stateless
public class SurveySectionDefinitionServiceBl implements ISurveySectionDefinitionServiceBl, Serializable {
	
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
	public void delete(SurveySectionDefinition element) {
		surveySectionDefinitionDb.delete(element);
	}
}
