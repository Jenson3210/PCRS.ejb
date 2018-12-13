package colruyt.pcrsejb.facade.competence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.converter.surveyDefinition.survey.SurveySectionDefinitionImplConverter;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.service.bl.competence.ICompetenceServiceBl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class CompetenceFacade implements Serializable, ICompetenceFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceServiceBl competenceServiceBl;
	private CompetenceConverter competenceConverter = new CompetenceConverter();
	private SurveySectionDefinitionImplConverter implConv = new SurveySectionDefinitionImplConverter();

	@Override
	public CompetenceBo save(CompetenceBo entityBo) {

		return competenceConverter.convertToBo(competenceServiceBl.save(competenceConverter.convertToEntity(entityBo)));
	}

	@Override
	public CompetenceBo get(CompetenceBo entityBo) {
		return competenceConverter.convertToBo(competenceServiceBl.get(competenceConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<CompetenceBo> getAll() {
		return competenceConverter.convertToBos(competenceServiceBl.getAll());
	}

	@Override
	public void delete(CompetenceBo entityBo) throws ValidationException {
		competenceServiceBl.delete(competenceConverter.convertToEntity(entityBo));
		
	}

	@Override
	public List<CompetenceBo> getCompetencesBySection(SurveySectionDefinitionImplBo sectionImpl) {
		return competenceConverter.convertToBos(
				competenceServiceBl.getCompetencesBySection(
						implConv.convertToEntity(sectionImpl)));
	}
}
