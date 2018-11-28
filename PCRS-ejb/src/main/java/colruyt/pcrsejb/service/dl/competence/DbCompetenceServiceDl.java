package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.List;
@Stateless
public class DbCompetenceServiceDl implements ICompetenceServiceDl, Serializable {
    private static final long serialVersionUID = 1L;

    @PersistenceContext(unitName = "PCRSEJB")
    private EntityManager em;

    @Override
    public Competence save(Competence element) {

        Competence competence = em.find(Competence.class, element.getId());
        if (competence == null) {
            em.persist(element);
            competence = element;
        }else {
            competence = em.merge(element);
        }
        return competence;
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
        TypedQuery<Competence> q = em.createNamedQuery("COMPETENCE.GETALL", Competence.class);
        List<Competence> listOfCompetences = q.getResultList();
        return listOfCompetences;
    }

    @Override
    public void delete(Competence element) {
        Competence competence = em.find(Competence.class, element.getId());
        if(competence != null) {
            em.remove(competence);
        }

    }
}
