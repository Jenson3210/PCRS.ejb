package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionTitleConverter;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionServiceBl;

@Stateless
public class SurveySectionDefinitionFacade implements Serializable,ISurveySectionDefinition {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionDefinitionServiceBl sdserv; 
	
	private SurveySectionDefinitionConverter sdconv = new SurveySectionDefinitionConverter();
	private SurveySectionTitleConverter sstconv = new SurveySectionTitleConverter();

	@Override
	public SurveySectionDefinitionBo save(SurveySectionDefinitionBo entityBo) {

		return sdconv.convertToBo(sdserv.save(sdconv.convertToEntity(entityBo)));
	}

	@Override
	public SurveySectionDefinitionBo get(SurveySectionDefinitionBo entityBo) {
		return sdconv.convertToBo(this.sdserv.get(sdconv.convertToEntity(entityBo)));  
	}

	@Override
	public List<SurveySectionDefinitionBo> getAll() {
	return sdconv.convertToBos(this.sdserv.getAll()); 
	}

	@Override
	public void delete(SurveySectionDefinitionBo entityBo) {
		this.sdserv.delete(this.sdconv.convertToEntity(entityBo)); 
		
	}

	@Override
	public List<SurveySectionDefinitionBo> getSurveySectionDefinitionsForTitle(SurveySectionTitleBo t) {
		return sdconv.convertToBos(sdserv.getSurveySectionDefinitionsForTitle(sstconv.convertToEntity(t)));
	}



	
	
}
