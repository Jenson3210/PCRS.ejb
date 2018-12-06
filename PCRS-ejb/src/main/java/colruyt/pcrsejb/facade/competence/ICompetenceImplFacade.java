package colruyt.pcrsejb.facade.competence;

import javax.ejb.Local;

import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.facade.IFacade;

@Local
public interface ICompetenceImplFacade extends IFacade<CompetenceImplBo> {
}
