package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.facade.competence.CompetenceLevelFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceLevelFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Named
@ViewScoped
public class AdminCompetenceView implements Serializable {
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceFacade competenceFacade;
	@EJB
	private ICompetenceLevelFacade competenceLevelFacade;
	private CompetenceBo competenceBo;
	private CompetenceLevelBo level;
	private List<CompetenceBo> competences;
	private Set<CompetenceLevelBo> levels = new HashSet<>();
	FacesContext context = FacesContext.getCurrentInstance();

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
		try {
			competences.add(competenceFacade.save(competenceBo));
		} catch (ValidationException e) {
			e.printStackTrace();
		}
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
		try {
			competenceFacade.save(c);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
	}

	public void deleteCompetence() {
		competences.remove(competenceBo);
		try {
			competenceFacade.delete(competenceBo);
		} catch (ValidationException e) {
			e.printStackTrace();
		}
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

	public void removeLevel() {
		// System.out.println(levels.size());
		if (levels.size() > 2) {
			for (Iterator<CompetenceLevelBo> iterator = levels.iterator(); iterator.hasNext();) {
				CompetenceLevelBo bo = iterator.next();
				if (bo.getOrderLevel() == level.getOrderLevel()) {
					iterator.remove();
					levels.remove(bo);
					if (level.getId() != null) {
						try {
							competenceLevelFacade.delete(level);
						} catch (ValidationException e) {
							FacesContext.getCurrentInstance().addMessage(null,
									new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
						}
					}
				}
			}
			int j = 1;
			for (CompetenceLevelBo clevel : levels) {
				if (j != clevel.getOrderLevel()) {
					clevel.setOrderLevel(j);
				}
				j = j + 1;
			}
		}

	}

	public CompetenceBo getCompetenceBo() {
		return competenceBo;
	}

	public void setCompetenceBo(CompetenceBo competenceBo) {
		this.competenceBo = competenceBo;
		levels = competenceBo.getCompetenceLevels();
	}

	public List<CompetenceBo> getCompetences() {
		// competences = competenceFacade.getAll();
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

	public CompetenceLevelBo getLevel() {
		return level;
	}

	public void setLevel(CompetenceLevelBo level) {
		this.level = level;
	}
}
