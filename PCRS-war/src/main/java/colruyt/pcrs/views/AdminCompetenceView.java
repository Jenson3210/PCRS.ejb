package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
	
	public List<CompetenceBo> getUsers() {
		return competences; 
	}
	
	public void addUser() {
		
		competences.add(competenceFasade.save(competenceBo));
    }
	
	public void editUser() {
		CompetenceBo c = null;
		for (CompetenceBo competence : competences) {
			if (competence.getId() == competenceBo.getId()) {
				competence.setName(competenceBo.getName());
			}
			c = competence;
		}
		competenceFasade.save(c); 
	}
	
	public void deleteUser() {
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
