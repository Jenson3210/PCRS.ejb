package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.service.dl.IDbService;

import java.util.List;

import javax.ejb.Local;

@Local
public interface ICompetenceServiceDl extends IDbService<Competence>{

	List<Competence> getCompetencesBySection(SurveySectionDefinitionImpl sectionImpl);
}
