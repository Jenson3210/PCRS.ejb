package colruyt.pcrsejb.service.bl.competence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.competence.CompetenceLevel;
import colruyt.pcrsejb.service.dl.competence.ICompetenceLevelServiceDl;
@Stateless
public class CompetenceLevelServiceBl implements Serializable, ICompetenceLevelServiceDl{
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompetenceLevel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CompetenceLevel element) {
		// TODO Auto-generated method stub
		
	}
}
