package colruyt.pcrsejb.service.bl.competence;

import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.service.dl.competence.ICompetenceImplServiceDl;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceImplDoesNotExistExepion;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceNotEnterdValidation;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceStillUsedExeption;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleCantBeDeletedException;
import colruyt.pcrsejb.util.exceptions.validation.surveyDefinition.survey.SurveySectionTitleNotFoundException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityNotFoundException;

import java.io.Serializable;
import java.util.List;

@Stateless
public class CompetenceImplServiceBl implements ICompetenceImplServiceBl, Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ICompetenceImplServiceDl competenceimplDb;
    @Override
    public CompetenceImpl save(CompetenceImpl element) {
        competenceimplDb.save(element);
        return element;
    }

    @Override
    public CompetenceImpl get(CompetenceImpl element) throws ValidationException {
        CompetenceImpl compimp = null;
        compimp = competenceimplDb.get(element);
        if(compimp == null){
            throw new CompetenceImplDoesNotExistExepion("This is not a Competence Implementation !");
        }
        return compimp;
    }

    @Override
    public List<CompetenceImpl> getAll() {
        return competenceimplDb.getAll();
    }

    @Override
    public void delete(CompetenceImpl element) throws ValidationException {
        try {
        	competenceimplDb.delete(element);
        } catch(EntityNotFoundException e) {
			throw new CompetenceImplDoesNotExistExepion("Competence does not exist!");
		} catch(Exception e) {
			throw new CompetenceStillUsedExeption("Competence implementation is still used.");
		}
    }	

	@Override
	public boolean validateCompetenceImpl(CompetenceImpl competence) throws CompetenceNotEnterdValidation {
		if (competence.getCompetence() == null 
				|| competence.getCompetenceDescription() == null 
				|| competence.getCompetenceDescription().isEmpty()) {
			throw new CompetenceNotEnterdValidation("Competence entered is not valid !");
		}
		return false;
	}
}
