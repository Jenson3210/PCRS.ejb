package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionImplConverter;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionImplServiceBl;

@Stateless
public class SurveySectionDefinitionImplFacade implements ISurveySectionDefinitionImplFacade {

	@EJB
	private ISurveySectionDefinitionImplServiceBl surveySectionDefinitionImplBl;
	
	private SurveySectionDefinitionImplConverter surveySectionDefinitionImplConverter = new SurveySectionDefinitionImplConverter();
	
	@Override
	public SurveySectionDefinitionImplBo save(SurveySectionDefinitionImplBo entityBo) {
		System.out.println("In the save");
		return surveySectionDefinitionImplConverter.convertToBo(
				surveySectionDefinitionImplBl.save(surveySectionDefinitionImplConverter.convertToEntity(entityBo)));
	}

	@Override
	public SurveySectionDefinitionImplBo get(SurveySectionDefinitionImplBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SurveySectionDefinitionImplBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SurveySectionDefinitionImplBo entityBo) {
		// TODO Auto-generated method stub
		
	}

	

}
