package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;

@Named
@ViewScoped
public class AdminCompetenceView implements Serializable{
	private static final long serialVersionUID = 1L;
	@EJB
	private ICompetenceFacade competenceFasade;
	private CompetenceBo competenceBo;
	private List<CompetenceBo> competences; 
	
	
	public List<CompetenceBo> getCompetences() {
		return competences;
	}
	
	public void addCompetence() {
		
		competences.add(competenceFasade.save(competenceBo));
    }
	
	public void editCompetence() {
		CompetenceBo c = null;
		for (CompetenceBo competence : competences) {
			if (competence.getId() == competenceBo.getId()) {
				competence.setName(competenceBo.getName());
			}
			c = competence;
		}
		competenceFasade.save(c); 
	}
	
	public void deleteCompetence() {
		CompetenceBo c = null;
		for (CompetenceBo competence : competences) {
			if (competence.getId() == competenceBo.getId()) {
				c = competence;
			}
		}
		competences.remove(c);
		competenceFasade.delete(c);
	}
}
