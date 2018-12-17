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

import org.primefaces.PrimeFaces;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;
import colruyt.pcrsejb.facade.competence.ICompetenceLevelFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * The type Admin competence view.
 */
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
	
	/**
	 * The Context.
	 */
	FacesContext context = FacesContext.getCurrentInstance();

	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	private void fillCompetences() {
		competences = competenceFacade.getAll();
		newLevels();
	}

	/**
	 * New competence.
	 */
	public void newCompetence() {
		competenceBo = new CompetenceBo();
		newLevels();
	}

	/**
	 * Add competence.
	 */
	public void addCompetence() {
		PrimeFaces pf = PrimeFaces.current();
		competenceBo.setCompetenceLevels(levels);
		try {
			competences.add(competenceFacade.save(competenceBo));
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("addForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * Edit competence.
	 */
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
		PrimeFaces pf = PrimeFaces.current();
		try {
			competenceFacade.save(c);
			pf.ajax().addCallbackParam("validationSucces", true);
		} catch (ValidationException e) {
			pf.ajax().addCallbackParam("validationSucces", false);
			FacesContext.getCurrentInstance().addMessage("editForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * Delete competence.
	 */
	public void deleteCompetence() {
		competences.remove(competenceBo);
		try {
			competenceFacade.delete(competenceBo);
		} catch (ValidationException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "succesfully deleted", null));
	}

	private void newLevels() {
		levels = new HashSet<>();
		for (int i = 1; i <= 2; i++) {
			levels.add(new CompetenceLevelBo("", i));
		}
	}

	/**
	 * New level.
	 */
	public void newLevel() {
		levels.add(new CompetenceLevelBo("", levels.size() + 1));
	}

	/**
	 * Remove level.
	 */
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
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "not succesfully deleted", null));

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

	/**
	 * Gets competence bo.
	 *
	 * @return the competence bo
	 */
	public CompetenceBo getCompetenceBo() {
		return competenceBo;
	}

	/**
	 * Sets competence bo.
	 *
	 * @param competenceBo the competence bo
	 */
	public void setCompetenceBo(CompetenceBo competenceBo) {
		this.competenceBo = competenceBo;
		levels = competenceBo.getCompetenceLevels();
	}

	/**
	 * Gets competences.
	 *
	 * @return the competences
	 */
	public List<CompetenceBo> getCompetences() {
		// competences = competenceFacade.getAll();
		return competences;
	}

	/**
	 * Sets competences.
	 *
	 * @param competences the competences
	 */
	public void setCompetences(List<CompetenceBo> competences) {
		this.competences = competences;
	}

	/**
	 * Gets levels.
	 *
	 * @return the levels
	 */
	public Set<CompetenceLevelBo> getLevels() {
		return levels;
	}

	/**
	 * Sets levels.
	 *
	 * @param levels the levels
	 */
	public void setLevels(Set<CompetenceLevelBo> levels) {
		this.levels = levels;
	}

	/**
	 * Gets level.
	 *
	 * @return the level
	 */
	public CompetenceLevelBo getLevel() {
		return level;
	}

	/**
	 * Sets level.
	 *
	 * @param level the level
	 */
	public void setLevel(CompetenceLevelBo level) {
		this.level = level;
	}
}
