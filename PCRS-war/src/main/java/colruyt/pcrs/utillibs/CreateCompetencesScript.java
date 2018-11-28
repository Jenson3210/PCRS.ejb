package colruyt.pcrs.utillibs;

import java.io.Serializable;
import java.util.HashSet;

import javax.ejb.EJB;
import javax.inject.Named;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceLevelBo;
import colruyt.pcrsejb.facade.competence.ICompetenceFacade;

@Named
public class CreateCompetencesScript implements Serializable{
	@EJB
	private ICompetenceFacade compFacade;
	private static final long serialVersionUID = 1L;
	
	public void fillCompetencesDb(Boolean createCompetences) {
		if (createCompetences) { 
			HashSet<CompetenceLevelBo> competenceLevels = new HashSet<CompetenceLevelBo>();
			competenceLevels.add (new CompetenceLevelBo("Ik geraak nog steeds niet goed wijs uit het verschil tussen functies en rollen", 1));
			competenceLevels.add (new CompetenceLevelBo("Ik weet in grove lijnen wat de verantwoordelijkheid is van een aantal rollen in de PCLC", 2));
			competenceLevels.add (new CompetenceLevelBo("Ik ken de meest gebruikte rollen in de PCLC, en van de rol(len) die ik opneem weet ik wat te doen, of vind ik mijn weg om het te weten te komen", 3));
			competenceLevels.add (new CompetenceLevelBo("Ik weet zowel van de rollen die ik opneem als van de meeste andere wat hen te doen staat", 4));
	
			CompetenceBo competenceBo = new CompetenceBo ("Roles in the PCLC", "Uitleg: Rollen in de PCLC zijn o.a: project manager, business advisor, project business architect, solution IT architect, process designer, system requirements analyst, lead developer, developer, test manager, asset owner, ...", competenceLevels); 
			compFacade.save(competenceBo);
		}
	}
}
