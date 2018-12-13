package colruyt.pcrsejb.service.bl.competence;

import java.util.List;

import javax.ejb.Local;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.service.bl.IServiceBl;

@Local
public interface ICompetenceServiceBl extends IServiceBl<Competence>{

	List<Competence> getCompetencesBySection(SurveySectionDefinitionImpl sectionImpl);
}
