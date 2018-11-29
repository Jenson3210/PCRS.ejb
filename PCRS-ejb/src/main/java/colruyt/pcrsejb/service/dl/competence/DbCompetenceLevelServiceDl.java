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
    	CompetenceLevel competenceLevel;
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
    	
        /*CompetenceLevel competencelevel = em.find(CompetenceLevel.class, element.getId());
        if (competencelevel == null) {
            em.persist(element);
            competencelevel = element;
        }else {
            competencelevel = em.merge(element);
        }
        return competencelevel;*/
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
        TypedQuery<CompetenceLevel> q = em.createNamedQuery("COMPETENCELEVEL.GETALL", CompetenceLevel.class);
        List<CompetenceLevel> listOfCompetenceLevels = q.getResultList();
        return listOfCompetenceLevels;
    }

    @Override
    public void delete(CompetenceLevel element) {
        CompetenceLevel competenclevel = em.find(CompetenceLevel.class, element);
        if(competenclevel != null) {
            em.remove(competenclevel);
        }
    }
}
