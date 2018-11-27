package colruyt.pcrsejb.facade.competence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.service.bl.competence.ICompetenceServiceBl;

@Stateless
public class CompetenceFacade implements Serializable, ICompetenceFacade {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceServiceBl competenceServiceBl;
	private CompetenceConverter competenceConverter = new CompetenceConverter();

	@Override
	public CompetenceBo save(CompetenceBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompetenceBo get(CompetenceBo entityBo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CompetenceBo> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(CompetenceBo entityBo) {
		// TODO Auto-generated method stub
		
	}
}
