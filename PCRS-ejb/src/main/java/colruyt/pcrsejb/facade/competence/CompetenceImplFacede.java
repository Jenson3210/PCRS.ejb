package colruyt.pcrsejb.facade.competence;


import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.converter.competence.CompetenceImplConverter;
import colruyt.pcrsejb.service.bl.competence.ICompetenceImplServiceBl;
import colruyt.pcrsejb.service.bl.competence.ICompetenceServiceBl;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import java.io.Serializable;
import java.util.List;

@Stateless
public class CompetenceImplFacede implements ICompetenceImplFacade, Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ICompetenceImplServiceBl competenceImplServiceBl;
    private CompetenceImplConverter competenceImplConverter = new CompetenceImplConverter();
    @Override
    public CompetenceImplBo save(CompetenceImplBo entityBo) throws ValidationException {
        return competenceImplConverter.convertToBo(competenceImplServiceBl.save(competenceImplConverter.convertToEntity(entityBo)));

    }

    @Override
    public CompetenceImplBo get(CompetenceImplBo entityBo) throws ValidationException {

        return competenceImplConverter.convertToBo(competenceImplServiceBl.get(competenceImplConverter.convertToEntity(entityBo)));

    }

    @Override
    public List<CompetenceImplBo> getAll() {
        return competenceImplConverter.convertToBos(competenceImplServiceBl.getAll());
    }

    @Override
    public void delete(CompetenceImplBo entityBo) throws ValidationException {
        competenceImplServiceBl.delete(competenceImplConverter.convertToEntity(entityBo));

    }
}
