package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.facade.competence.CompetenceLevelFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceLevelFacade;

@Named
@ViewScoped
public class AdminCompetenceView implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceFacade competenceFacade;
	private ICompetenceLevelFacade competenceLevelFacade;
	private CompetenceBo competenceBo;
	private CompetenceLevelBo bo;
	private List<CompetenceBo> competences;
	private Set<CompetenceLevelBo> levels = new HashSet<>();
	
	@PostConstruct
	private void fillCompetences() {
		competences = competenceFacade.getAll();
		newLevels();
	}
	
	public void newCompetence() {
		competenceBo = new CompetenceBo();
		newLevels();
	}
	
	public void addCompetence() {
		competenceBo.setCompetenceLevels(levels);
		competences.add(competenceFacade.save(competenceBo));
    }
	
	public void editCompetence() {
		CompetenceBo c = null;
		for (CompetenceBo competence : competences) {
			if (competence.getId() == competenceBo.getId()) {
				competence.setName(competenceBo.getName());
				competence.setCompetenceDescription(competenceBo.getCompetenceDescription());
				competence.setCompetenceLevels(levels);
			}
			c = competence;
		}
		competenceFacade.save(c); 
	}
	
	public void deleteCompetence() {
		CompetenceBo c = null;
		for (CompetenceBo competence : competences) {
			if (competence.getId() == competenceBo.getId()) {
				c = competence;
			}
		}
		competences.remove(c);
		competenceFacade.delete(c);
	}

	private void newLevels() {
		levels = new HashSet<>();
		for (int i = 1; i <= 2; i++) {
			levels.add(new CompetenceLevelBo("", i));
		}
	}
	
	public void newLevel() { 
		levels.add(new CompetenceLevelBo("", levels.size() + 1));
	}
	public void  removeLevel(){
		CompetenceLevelBo c = new CompetenceLevelBo();
		for (CompetenceLevelBo competence : levels) {
			if (competence.getId() == bo.getId()) {
				c = competence;
			}
		}
		
		levels.remove(c);
		competenceLevelFacade.delete(c);
	}
	
	public CompetenceBo getCompetenceBo() {
		return competenceBo;
	}

	public void setCompetenceBo(CompetenceBo competenceBo) {
		this.competenceBo = competenceBo;
		levels = competenceBo.getCompetenceLevels();
	}

	public List<CompetenceBo> getCompetences() {
		return competences;
	}

	public void setCompetences(List<CompetenceBo> competences) {
		this.competences = competences;
	}

	public Set<CompetenceLevelBo> getLevels() {
		return levels;
	}

	public void setLevels(Set<CompetenceLevelBo> levels) {
		this.levels = levels;
	}
}
