package colruyt.pcrsejb.service.bl.competence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.service.dl.competence.ICompetenceServiceDl;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceAlreadyExistExeption;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceDoesNotExistExeption;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceNotEnterdValidation;
import colruyt.pcrsejb.util.exceptions.validation.competence.CompetenceStillUsedExeption;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class CompetenceServiceBl implements Serializable, ICompetenceServiceBl {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceServiceDl competencedb;
	@EJB
	private ICompetenceImplServiceBl competenceImpdb;

	@Override
	public Competence save(Competence element) throws ValidationException {
        List<Competence> allCompeteces = this.getAll();
        if(!allCompeteces.isEmpty()){
            for(Competence c : allCompeteces){
                if(c.equals(element)){
                    throw new CompetenceAlreadyExistExeption("This is not a Competence already exists !");
                }
            }
        }
        if(element.getName().equals(" ") || element.getCompetenceDescription().equals(" ")) {
        	throw new CompetenceNotEnterdValidation("This is not enterd, please enter");
        }
		competencedb.save(element);
		return element;
	}

	@Override
	public Competence get(Competence element) throws ValidationException{
		Competence c = null;
		c= competencedb.get(element);
		if(c == null){
			throw new CompetenceDoesNotExistExeption("This is not a Competence !");
		}
		return c;
	}

	@Override
	public List<Competence> getAll() {
		return competencedb.getAll();
	}

	@Override
	public void delete(Competence element) throws ValidationException {
		List<CompetenceImpl> competenceImps = new ArrayList<>();
		//CompetenceImplServiceBl cisbl = new CompetenceImplServiceBl();
		competenceImps =  competenceImpdb.getAll();
		for(CompetenceImpl ci : competenceImps) {
			if(ci.getCompetence().getId() == element.getId()) {
				throw new CompetenceStillUsedExeption("Is still used");
			}
		}
		
		competencedb.delete(element);
		
	}

	@Override
	public List<Competence> getCompetencesBySection(SurveySectionDefinitionImpl sectionImpl) {
		return competencedb.getCompetencesBySection(sectionImpl);
	}
}
