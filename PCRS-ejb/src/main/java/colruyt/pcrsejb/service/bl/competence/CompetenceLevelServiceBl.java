package colruyt.pcrsejb.service.bl.competence;

import java.io.Serializable;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.competence.CompetenceLevel;
import colruyt.pcrsejb.service.dl.competence.ICompetenceLevelServiceDl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;
@Stateless
public class CompetenceLevelServiceBl implements Serializable, ICompetenceLevelServiceBl{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceLevelServiceDl competencelevelDb;

	@Override
	public CompetenceLevel save(CompetenceLevel element) {
		competencelevelDb.save(element);
		return element;
	}

	@Override
	public CompetenceLevel get(CompetenceLevel element) {
		return competencelevelDb.get(element);
	}

	@Override
	public List<CompetenceLevel> getAll() {
		return competencelevelDb.getAll();
	}

	@Override
	public void delete(CompetenceLevel element) throws ValidationException {
		competencelevelDb.delete(element);
		
	}
}
