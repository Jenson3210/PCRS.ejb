package colruyt.pcrsejb.facade.competence;


import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.converter.competence.CompetenceImplConverter;
import colruyt.pcrsejb.service.bl.competence.ICompetenceImplServiceBl;
import colruyt.pcrsejb.service.bl.competence.ICompetenceServiceBl;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;

public class CompetenceImplFacede implements ICompetenceImplFacade, Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private ICompetenceImplServiceBl competenceImplServiceBl;
    private CompetenceImplConverter competenceImplConverter = new CompetenceImplConverter();
    @Override
    public CompetenceImplBo save(CompetenceImplBo entityBo) {
        return competenceImplConverter.convertToBo(competenceImplServiceBl.save(competenceImplConverter.convertToEntity(entityBo)));

    }

    @Override
    public CompetenceImplBo get(CompetenceImplBo entityBo) {

        return competenceImplConverter.convertToBo(competenceImplServiceBl.get(competenceImplConverter.convertToEntity(entityBo)));

    }

    @Override
    public List<CompetenceImplBo> getAll() {
        return competenceImplConverter.convertToBos(competenceImplServiceBl.getAll());
    }

    @Override
    public void delete(CompetenceImplBo entityBo) {
        competenceImplServiceBl.delete(competenceImplConverter.convertToEntity(entityBo));

    }
}
