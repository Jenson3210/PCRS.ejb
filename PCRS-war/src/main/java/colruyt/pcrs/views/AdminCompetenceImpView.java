package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.facade.competence.CompetenceLevelFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceImplFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceLevelFacade;

@Named
@ViewScoped
public class AdminCompetenceImpView implements Serializable{
    private static final long serialVersionUID = 1L;
    @EJB
    private ICompetenceImplFacade competenceImplFacade;
    @EJB
    private ICompetenceFacade competenceFacade;
    @EJB
    private ICompetenceLevelFacade competenceLevelFacade;
    private CompetenceImplBo competenceIBo;
    private CompetenceBo competenceBo;
    private CompetenceLevelBo level;
    private List<CompetenceImplBo> competenceIs;
    private List<CompetenceBo> competences;
    private Set<CompetenceLevelBo> levels = new HashSet<>();

    @PostConstruct
    private void fillCompetenceImpls() {
        competenceIs = competenceImplFacade.getAll();
        competences = competenceFacade.getAll();
        newLevels();
    }

    private void newLevels() {
		levels = new HashSet<>();
		for (int i = 1; i <= 2; i++) {
			levels.add(new CompetenceLevelBo("", i));
		}
	}
    
    public CompetenceImplBo getCompetenceImplBo() {
        return competenceIBo;
    }

	public List<CompetenceBo> completeCompetence(String query) {
		List<CompetenceBo> filteredResults = new ArrayList<>();
		query = query.toLowerCase();
		for (CompetenceBo bo : competences) {
			if (bo.getName().toLowerCase().contains(query) || 
					bo.getCompetenceDescription().toLowerCase().contains(query)) {
				filteredResults.add(bo);
			}
		}
		return filteredResults;
	}
    
    public void setCompetenceImplBo(CompetenceImplBo competenceBo) {
        this.competenceIBo = competenceBo;
        //levels = competenceBo.getCompetenceLevels();
    }
    
    public void setCompetenceBo(CompetenceBo competenceBo) {
        this.competenceBo = competenceBo;
        //levels = competenceBo.getCompetenceLevels();
    }
    
    

    public CompetenceImplBo getCompetenceIBo() {
		return competenceIBo;
	}

	public void setCompetenceIBo(CompetenceImplBo competenceIBo) {
		this.competenceIBo = competenceIBo;
	}

	public CompetenceLevelBo getLevel() {
		return level;
	}

	public void setLevel(CompetenceLevelBo level) {
		this.level = level;
	}

	public CompetenceBo getCompetenceBo() {
		return competenceBo;
	}

	public List<CompetenceImplBo> getCompetenceImpls() {
        //competences = competenceFacade.getAll();
        return competenceIs;
    }

    public void setCompetenceImpls(List<CompetenceImplBo> competences) {
        this.competenceIs = competences;
    }
    
    public Set<CompetenceLevelBo> getLevels() {
		return levels;
	}

	public void setLevels(Set<CompetenceLevelBo> levels) {
		this.levels = levels;
	}
}
