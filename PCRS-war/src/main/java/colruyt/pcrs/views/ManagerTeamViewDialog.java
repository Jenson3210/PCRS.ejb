package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionRequirementLevelBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;

@Named
@ViewScoped
public class ManagerTeamViewDialog implements Serializable {
			
	

	private static final long serialVersionUID = 1L;
	private UserBo manager;
	private UserBo teamMember;
		
	private List<SurveySectionDefinitionImplBo>  chosenList = new ArrayList<>();
	private List<SurveySectionDefinitionImplBo>  availableList = new ArrayList<>();
	
	@EJB
	private ISurveySetFacade surveyFacade;
	
	@Inject
	private WebUser currentUser;
	
	@EJB
	private IUserFacade userFacade;
	
	

	public UserBo getManager() {
		return manager;
	}

	public void setManager(UserBo manager) {
		this.manager = manager;
	}

	public UserBo getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(UserBo teamMember) {
		this.teamMember = teamMember;
	}

	


	public void init(UserBo user) {
		
		this.setTeamMember(user);
		this.setManager(this.currentUser.getUser());
		this.loadCompetences();
		
		
	}
	private void loadCompetences() {
		this.setAvailableList(this.surveyFacade.getPossibleSections(this.manager));
		Iterator<SurveySectionDefinitionImplBo> it  = this.getAvailableList().stream().filter(x->x.getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED)).collect(Collectors.toList()).iterator();

		for(;it.hasNext();) {
			this.select(it.next());
		}
	}
	public void select(SurveySectionDefinitionImplBo surveysec) {
		this.getChosenList().add(surveysec);
		this.getAvailableList().remove(surveysec);
	}
	
	public void removeFromChosen(SurveySectionDefinitionImplBo surveysec) {
		if(surveysec.getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED)) {
		this.getAvailableList().add(surveysec);
		this.getChosenList().remove(surveysec);
		}
		
	}
	
	
	public List<SurveySectionDefinitionImplBo> getChosenList() {
		return chosenList;
	}

	public void setChosenList(List<SurveySectionDefinitionImplBo> chosenList) {
		this.chosenList = chosenList;
	}

	public List<SurveySectionDefinitionImplBo> getAvailableList() {
		return availableList;
	}

	public void setAvailableList(List<SurveySectionDefinitionImplBo> availableList) {
		this.availableList = availableList;
	}

	
	
	public void submit() {
		
	TeamMemberUserPrivilegeBo privi = (TeamMemberUserPrivilegeBo )this.currentUser.getUser().getPrivileges().stream().filter(x->x.getPrivilegeType().equals(PrivilegeTypeBo.TEAMMEMBER) && x.isActive()).findFirst().get();
	privi.getSurveySetTreeSet().add(this.surveyFacade.generateSurveySetFor(this.chosenList));
	this.userFacade.save(this.currentUser.getUser());
	
	}
	
	
	
	
			
}
