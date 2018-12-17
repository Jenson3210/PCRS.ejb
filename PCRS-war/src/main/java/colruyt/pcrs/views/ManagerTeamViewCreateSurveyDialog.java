package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionImplFacade;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Named
@ViewScoped
public class ManagerTeamViewCreateSurveyDialog implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private UserBo manager;
	private UserBo teamMember;
	private SurveySectionDefinitionImplBo chosen = new SurveySectionDefinitionImplBo();
	private List<SurveySectionDefinitionImplBo>  chosenList = new ArrayList<>();
	private List<SurveySectionDefinitionImplBo>  allList = new ArrayList<>();
	private DualListModel<SurveySectionDefinitionImplBo>  availableList = new DualListModel<>(allList, chosenList);
	
	@EJB
	private ISurveySetFacade surveyFacade;
	@EJB 
	private ISurveySectionDefinitionImplFacade surveySectionDefinitionImplFacade;
	 
	@Inject
	private WebUser currentUser;
	
	@EJB
	private IUserFacade userFacade;
	 
	@PostConstruct
	public void emptyPickList() {
		availableList = new DualListModel<>(allList, chosenList);
	}
	
	public SurveySectionDefinitionImplBo getChosen() {
		return chosen;
	}

	public void setChosen(SurveySectionDefinitionImplBo chosen) {
		this.chosen = chosen;
	}
	
	
	
	


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


	public ManagerTeamViewCreateSurveyDialog() {
		super();
		System.out.println("hallo");
	}

	private void loadCompetences() {
		this.allList = this.surveyFacade.getPossibleSections(this.teamMember);
		List<SurveySectionDefinitionImplBo> lijst = this.allList.stream().filter(x->x.getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED)).collect(Collectors.toList());
		this.chosenList.addAll(lijst);
		this.allList.removeAll(this.chosenList);
		availableList.setSource(getAllList());
		availableList.setTarget(getChosenList());
	}
	
	
	
	
	public List<SurveySectionDefinitionImplBo> getChosenList() {
		return chosenList;
	}

	public void setChosenList(List<SurveySectionDefinitionImplBo> chosenList) {
		this.chosenList = chosenList;
	}

	

	public void submit() {
	List<SurveySectionDefinitionImplBo> sections = new ArrayList<>();
	for (SurveySectionDefinitionImplBo section : this.availableList.getTarget()) {
		try {
			sections.add(surveySectionDefinitionImplFacade.get(section));
		} catch (ValidationException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			String message= context.getApplication().evaluateExpressionGet(context, "#{msgs['error.general']}",
					String.class);
			
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, null, message);
			context.addMessage(null, myFacesMessage);
		}
	}	
	
	
	TeamMemberUserPrivilegeBo privi = (TeamMemberUserPrivilegeBo )this.teamMember.getPrivileges().stream().filter(x->x.getPrivilegeType().equals(PrivilegeTypeBo.TEAMMEMBER) && x.isActive()).findFirst().get();
	privi.getSurveySetTreeSet().add(this.surveyFacade.generateSurveySetFor(sections));
	
	try {
		this.userFacade.save(this.teamMember);
	} catch (ValidationException e) {
		FacesContext context = FacesContext.getCurrentInstance();
		String message= context.getApplication().evaluateExpressionGet(context, "#{msgs['error.general']}",
				String.class);
		
		FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, null, message);
		context.addMessage(null, myFacesMessage);
	}
	}

	public List<SurveySectionDefinitionImplBo> getAllList() {
		return allList;
	}

	public void setAllList(List<SurveySectionDefinitionImplBo> allList) {
		this.allList = allList;
	}
}
