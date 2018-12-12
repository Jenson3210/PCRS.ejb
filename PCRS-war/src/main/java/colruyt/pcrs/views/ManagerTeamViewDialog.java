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

import org.primefaces.model.DualListModel;

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
	
	private SurveySectionDefinitionImplBo chosen = new SurveySectionDefinitionImplBo();
	
	@EJB
	private ISurveySetFacade surveyFacade;
	 
	@Inject
	private WebUser currentUser;
	
	@EJB
	private IUserFacade userFacade;
	 
		
	public SurveySectionDefinitionImplBo getChosen() {
		return chosen;
	}

	public void setChosen(SurveySectionDefinitionImplBo chosen) {
		this.chosen = chosen;
	}

	private List<SurveySectionDefinitionImplBo>  chosenList = new ArrayList<>();
	private List<SurveySectionDefinitionImplBo>  allList = new ArrayList<>();
	
	private DualListModel<SurveySectionDefinitionImplBo>  availableList;
	
	
	
	public DualListModel<SurveySectionDefinitionImplBo> getAvailableList() {
		return availableList;
	}
	
	

	public void setAvailableList(DualListModel<SurveySectionDefinitionImplBo> availableList) {
		this.availableList = availableList; 
	}

	public void initDialog(UserBo user) {  
		
		this.setTeamMember(user);
		this.setManager(this.currentUser.getUser());
		this.loadCompetences();
		
		availableList = new DualListModel<SurveySectionDefinitionImplBo>(allList, chosenList);

	}
	
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

	
	
	
	  
	public ManagerTeamViewDialog() {
		super();
	}

	private void loadCompetences() {
		this.allList = this.surveyFacade.getPossibleSections(this.teamMember);
		List<SurveySectionDefinitionImplBo> lijst = this.allList.stream().filter(x->x.getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED)).collect(Collectors.toList());
		this.chosenList.addAll(lijst);
		this.allList.removeAll(this.chosenList);
		
	}
	
	
	
	
	public List<SurveySectionDefinitionImplBo> getChosenList() {
		return chosenList;
	}

	public void setChosenList(List<SurveySectionDefinitionImplBo> chosenList) {
		this.chosenList = chosenList;
	}

	

	public void submit() {
		
	TeamMemberUserPrivilegeBo privi = (TeamMemberUserPrivilegeBo )this.currentUser.getUser().getPrivileges().stream().filter(x->x.getPrivilegeType().equals(PrivilegeTypeBo.TEAMMEMBER) && x.isActive()).findFirst().get();
	privi.getSurveySetTreeSet().add(this.surveyFacade.generateSurveySetFor(this.availableList.getTarget()));
	
	this.userFacade.save(this.currentUser.getUser());
	
	}
	

	
	
	
			
}
