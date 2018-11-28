package colruyt.pcrsejb.facade.competence;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.converter.competence.CompetenceLevelConverter;
import colruyt.pcrsejb.service.bl.competence.ICompetenceLevelServiceBl;

@Stateless
public class CompetenceLevelFacade implements Serializable, ICompetenceLevelFacade{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceLevelServiceBl competenceLevelServiceBl;
	private CompetenceLevelConverter competenceLevelConverter = new CompetenceLevelConverter();

	@Override
	public CompetenceLevelBo save(CompetenceLevelBo entityBo) {
		return competenceLevelConverter.convertToBo(competenceLevelServiceBl.save(competenceLevelConverter.convertToEntity(entityBo)));
	}

	@Override
	public CompetenceLevelBo get(CompetenceLevelBo entityBo) {
		return competenceLevelConverter.convertToBo(competenceLevelServiceBl.get(competenceLevelConverter.convertToEntity(entityBo)));
	}

	@Override
	public List<CompetenceLevelBo> getAll() {
		return competenceLevelConverter.convertToBos(competenceLevelServiceBl.getAll());
	}

	@Override
	public void delete(CompetenceLevelBo entityBo) {
		competenceLevelServiceBl.delete(competenceLevelConverter.convertToEntity(entityBo));
		
	}
}
