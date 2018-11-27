package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;

public class DbCompenetceServiceDl implements ICompetenceServiceDl, Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "PCRSEJB")
    private EntityManager em;

    @Override
    public Competence save(Competence element) {
        em.persist(element);

        em.flush();
        return element;
    }

    @Override
    public Competence get(Competence element) {
        Competence competence = em.find(Competence.class, element);
        if (competence == null) {
            throw new EmptyStackException();
        }
        return competence;
    }

    @Override
    public List<Competence> getAll() {
        TypedQuery<Competence> q = em.createQuery("SELECT c from Competence c", Competence.class);
        return q.getResultList();
    }

    @Override
    public void delete(Competence element) {
        em.remove(element);

    }
}
