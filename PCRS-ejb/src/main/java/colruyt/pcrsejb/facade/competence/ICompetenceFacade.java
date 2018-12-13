package colruyt.pcrsejb.facade.competence;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.facade.IFacade;

@Local
public interface ICompetenceFacade extends IFacade<CompetenceBo>{

	List<CompetenceBo> getCompetencesBySection(SurveySectionDefinitionImplBo sectionImpl);
}
