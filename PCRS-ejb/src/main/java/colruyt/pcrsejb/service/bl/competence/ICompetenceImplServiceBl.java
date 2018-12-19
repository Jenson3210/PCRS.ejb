package colruyt.pcrsejb.service.bl.competence;

import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.service.bl.IServiceBl;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceNotEnterdValidation;

import javax.ejb.Local;

@Local
public interface ICompetenceImplServiceBl extends IServiceBl<CompetenceImpl> {
	
	boolean validateCompetenceImpl(CompetenceImpl competence) throws CompetenceNotEnterdValidation;
}
