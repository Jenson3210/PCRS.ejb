package colruyt.pcrsejb.service.bl.competence;

import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.service.dl.competence.ICompetenceImplServiceDl;

import javax.ejb.EJB;
import java.io.Serializable;
import java.util.List;

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
    public CompetenceImpl get(CompetenceImpl element) {

        return competenceimplDb.get(element);
    }

    @Override
    public List<CompetenceImpl> getAll() {
        return competenceimplDb.getAll();
    }

    @Override
    public void delete(CompetenceImpl element) {
        competenceimplDb.delete(element);
    }
}
