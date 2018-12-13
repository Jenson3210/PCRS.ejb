package colruyt.pcrsejb.service.bl.competence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.service.dl.competence.ICompetenceServiceDl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class CompetenceServiceBl implements Serializable, ICompetenceServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceServiceDl competencedb;

	@Override
	public Competence save(Competence element) {
		competencedb.save(element);
		return element;
	}

	@Override
	public Competence get(Competence element) {
		return competencedb.get(element);
	}

	@Override
	public List<Competence> getAll() {
		return competencedb.getAll();
	}

	@Override
	public void delete(Competence element) throws ValidationException {
		competencedb.delete(element);
		
	}

	@Override
	public List<Competence> getCompetencesBySection(SurveySectionDefinitionImpl sectionImpl) {
		return competencedb.getCompetencesBySection(sectionImpl);
	}
}
