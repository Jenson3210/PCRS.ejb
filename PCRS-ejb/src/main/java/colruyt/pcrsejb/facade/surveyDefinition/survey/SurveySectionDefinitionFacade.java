package colruyt.pcrsejb.facade.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.converter.competence.CompetenceImplConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionConverter;
import colruyt.pcrsejb.service.bl.competence.ICompetenceImplServiceBl;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionServiceBl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionTitleBo;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionTitleConverter;
import colruyt.pcrsejb.facade.competence.ICompetenceImplFacade;
import colruyt.pcrsejb.service.bl.surveyDefinition.survey.ISurveySectionDefinitionServiceBl;

@Stateless
public class SurveySectionDefinitionFacade implements Serializable,ISurveySectionDefinitionFacade {
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ISurveySectionDefinitionServiceBl sdserv; 
	@EJB
	private ICompetenceImplFacade competenceImplFacade;
	@EJB
	private ICompetenceImplServiceBl competenceImplBl;
	
	private SurveySectionDefinitionConverter sdconv = new SurveySectionDefinitionConverter();
	private SurveySectionTitleConverter sstconv = new SurveySectionTitleConverter();
	private CompetenceImplConverter competenceConv = new CompetenceImplConverter();
	

	@Override
	public SurveySectionDefinitionBo save(SurveySectionDefinitionBo entityBo) throws ValidationException {
		return sdconv.convertToBo(sdserv.save(sdconv.convertToEntity(entityBo)));
	}

	@Override
	public SurveySectionDefinitionBo get(SurveySectionDefinitionBo entityBo) throws ValidationException {
		return sdconv.convertToBo(this.sdserv.get(sdconv.convertToEntity(entityBo)));  
	}

	@Override
	public List<SurveySectionDefinitionBo> getAll() {
	return sdconv.convertToBos(this.sdserv.getAll()); 
	}

	@Override
	public void delete(SurveySectionDefinitionBo entityBo) throws ValidationException {
		this.sdserv.delete(this.sdconv.convertToEntity(entityBo)); 
		
	}

	@Override
	public List<SurveySectionDefinitionBo> getSurveySectionDefinitionsForTitle(SurveySectionTitleBo t) {
		return sdconv.convertToBos(sdserv.getSurveySectionDefinitionsForTitle(sstconv.convertToEntity(t)));
	}

	@Override
	public SurveySectionDefinitionBo addCompetenceImpl(SurveySectionDefinitionBo section, CompetenceImplBo competence) throws ValidationException {
		competenceImplBl.validateCompetenceImpl(competenceConv.convertToEntity(competence));
		if (competence.getId() == null) {
			section.getSurveySectionCompetences().add(competence);
		}
		return this.save(section);
	}

	@Override
	public SurveySectionDefinitionBo removeCompetenceImpl(SurveySectionDefinitionBo section,
			CompetenceImplBo competence) throws ValidationException {
		competenceImplFacade.delete(competence);
		section.getSurveySectionCompetences().remove(competence);
		return this.save(section);
	}



	
	
}