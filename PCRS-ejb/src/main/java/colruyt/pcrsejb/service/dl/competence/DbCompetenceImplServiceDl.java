package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.CompetenceImpl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;
@Stateless
public class DbCompetenceImplServiceDl implements ICompetenceImplServiceDl, Serializable {

    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "PCRSEJB")
    private EntityManager em;
    @Override
    public CompetenceImpl save(CompetenceImpl element) {
        CompetenceImpl competenceLevel;
        if(element.getId()==null)
        {
            em.persist(element);
            competenceLevel=element;
        }
        else
        {
            competenceLevel = em.merge(element);
        }
        return competenceLevel;
    }

    @Override
    public CompetenceImpl get(CompetenceImpl element) {
        CompetenceImpl competence = em.find(CompetenceImpl.class, element);
        if (competence == null) {
            throw new EmptyStackException();
        }
        return competence;
    }

    @Override
    public List<CompetenceImpl> getAll() {
        TypedQuery<CompetenceImpl> q = em.createNamedQuery("COMPETENCEIMPL.GETALL", CompetenceImpl.class);
        List<CompetenceImpl> listOfCompetenceLevels = q.getResultList();
        return listOfCompetenceLevels;
    }

    @Override
    public void delete(CompetenceImpl element) {
        CompetenceImpl competenclevel = em.find(CompetenceImpl.class, element.getId());
        if(competenclevel != null) {
            em.remove(competenclevel);
        }
    }
}
