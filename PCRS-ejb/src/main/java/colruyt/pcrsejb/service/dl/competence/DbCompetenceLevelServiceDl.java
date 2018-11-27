package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.CompetenceLevel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;
@Stateless
public class DbCompetenceLevelServiceDl implements ICompetenceLevelServiceDl, Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "PCRSEJB")
    private EntityManager em;

    @Override
    public CompetenceLevel save(CompetenceLevel element) {
        em.persist(element);
        em.flush();
        return element;
    }

    @Override
    public CompetenceLevel get(CompetenceLevel element) {
        CompetenceLevel competence = em.find(CompetenceLevel.class, element);
        if (competence == null) {
            throw new EmptyStackException();
        }
        return competence;
    }

    @Override
    public List<CompetenceLevel> getAll() {
        TypedQuery<CompetenceLevel> q = em.createQuery("SELECT c from CompetenceLevel c", CompetenceLevel.class);
        return q.getResultList();
    }

    @Override
    public void delete(CompetenceLevel element) {
        em.remove(element);
    }
}
