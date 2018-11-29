package colruyt.pcrsejb.service.bl.surveyDefinition.survey;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionImplFacade;
import colruyt.pcrsejb.service.dl.surveyDefinition.survey.ISurveySectionDefinitionImplServiceDl;

@Stateless
public class SurveySectionDefinitionImplServiceBl implements ISurveySectionDefinitionImplServiceBl {

	
	@EJB
	private ISurveySectionDefinitionImplServiceDl surveySectionDefinitionImplServiceDl;

	@Override
	public SurveySectionDefinitionImpl save(SurveySectionDefinitionImpl element) {
		return surveySectionDefinitionImplServiceDl.save(element);
	}

	@Override
	public SurveySectionDefinitionImpl get(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySectionDefinitionImpl> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySectionDefinitionImpl element) {
		// TODO Auto-generated method stub
		
	}
	
	



}
