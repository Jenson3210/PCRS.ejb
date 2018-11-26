package colruyt.pcrsejb.service.bl.competence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.service.dl.competence.ICompetenceServiceDl;

@Stateless
public class CompetenceServiceBl implements Serializable, ICompetenceServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceServiceDl ICompetenceServicDl;

	@Override
	public CompetenceBo save(CompetenceBo element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompetenceBo get(CompetenceBo element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompetenceBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CompetenceBo element) {
		// TODO Auto-generated method stub
		
	}
}
