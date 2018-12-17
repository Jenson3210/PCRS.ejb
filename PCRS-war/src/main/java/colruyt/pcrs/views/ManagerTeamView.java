package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;

import colruyt.pcrs.DTO.TeamEnrolmentBo;
import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionDefinitionImplBo;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveySectionRequirementLevelBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveySectionDefinitionImplFacade;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Named
@ViewScoped
public class ManagerTeamView implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ITeamFacade teamFacade;

	@EJB
	private IUserFacade userFacade;

	@EJB
	private IEnrolmentFacade enrolmentFacade;

	@EJB
	private ISurveySetFacade surveyFacade;
	
	
	@EJB 
	private ISurveySectionDefinitionImplFacade surveySectionDefinitionImplFacade;


	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	@Inject
	private WebUser currentUser;

	private List<TeamBo> teams;
	
	private SurveySectionDefinitionImplBo chosen = new SurveySectionDefinitionImplBo();
	private List<SurveySectionDefinitionImplBo>  chosenList = new ArrayList<>();
	private List<SurveySectionDefinitionImplBo>  allList = new ArrayList<>();
	private DualListModel<SurveySectionDefinitionImplBo>  availableList = new DualListModel<>(allList, chosenList);

	public ITeamFacade getTeamFacade() {

		return teamFacade;
	}

	public void setTeamFacade(ITeamFacade teamFacade) {
		this.teamFacade = teamFacade;
	}

	public IEnrolmentFacade getEnrolmentFacade() { 
		return enrolmentFacade;
	}

	public void setEnrolmentFacade(IEnrolmentFacade enrolmentFacade) {
		this.enrolmentFacade = enrolmentFacade;
	}

	public ISurveySetFacade getSurveyFacade() {
		return surveyFacade;
	}

	public void setSurveyFacade(ISurveySetFacade surveyFacade) {
		this.surveyFacade = surveyFacade;
	}

	private List<TeamEnrolmentBo> teamEnrolments = new ArrayList<>();

	public List<TeamEnrolmentBo> getTeamEnrolments() {
		return teamEnrolments;
	}

	public void setTeamEnrolments(List<TeamEnrolmentBo> teamEnrolments) {
		this.teamEnrolments = teamEnrolments;
	}

	@PostConstruct
	private void fillList() {
		teams = teamFacade.getTeamsOfManager(currentUser.getUser());
		for (TeamBo t : teams) {
			TeamEnrolmentBo teamEnrolment = new TeamEnrolmentBo(t);
			for (EnrolmentBo e : t.getEnrolments()) {
				teamEnrolment.addEnrolmentToMap(e, getUserFromEnrolment(e));
			}
			teamEnrolments.add(teamEnrolment);
		}

	}

	public List<TeamBo> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamBo> teams) {
		this.teams = teams;
	}

	public boolean isMe(UserBo bo) {

		return !this.currentUser.getUser().equals(bo);

	}

	public UserBo getUserFromEnrolment(EnrolmentBo enrolment) {
		UserBo user = null;

		try {
			user = userFacade.getUserByEnrolment(enrolment);
		} catch (NoExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public Integer getManagerSurveyPercentage(UserBo user) {

		try {
			return this.getSurveyFacade().getPercentageCompleteForManagerSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}

	}

	public Integer getMemberSurveyPercentage(UserBo user) {

		try {
			return this.getSurveyFacade().getPercentageCompleteForMemberSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}

	}

	public Integer getConsensusSurveyPercentage(UserBo user) {
		try {
		    return this.getSurveyFacade().getPercentageCompleteForConsensusSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}
	}

	public Boolean consensusReady(UserBo user) { 

		return this.getManagerSurveyPercentage(this.currentUser.getUser()) == 100 && this.getMemberSurveyPercentage(user) == 100;

	}

	public String getFunctionOf(EnrolmentBo bo) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		String function = null;
		try {
			if (bo.getUserPrivilege() instanceof SurveyUserPrivilegeBo) {

				function  = ((SurveyUserPrivilegeBo) bo.getUserPrivilege()).getSurveyDefinition().getFunction();

			} else {
				function =  context.getApplication().evaluateExpressionGet(context, "#{msgs['error.required']}", String.class);
						
			}
		} catch (Exception e) {
			function = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.required']}", String.class);
					
		}
			return function;
		
	}

	public boolean hasFunction(EnrolmentBo bo) {

		if (bo.getUserPrivilege() instanceof SurveyUserPrivilegeBo) {			
			return ((SurveyUserPrivilegeBo) bo.getUserPrivilege()).getSurveyDefinition() != null;
		}
		return false;
	}
	
	
	// Dialog Create Survye

	private UserBo teamMember;
	
	
	
	

	public UserBo getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(UserBo teamMember) {
		this.teamMember = teamMember;
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
		this.loadCompetences();
	}
	
	private void loadCompetences() {
		this.allList = this.surveyFacade.getPossibleSections(this.getTeamMember());
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
	
	
	FacesContext context = FacesContext.getCurrentInstance();
	String message= context.getApplication().evaluateExpressionGet(context, "Succes!!",
			String.class);
	FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, null, message);
	context.addMessage("messagegrowl", myFacesMessage);
	
	
	}
	
	

	public List<SurveySectionDefinitionImplBo> getAllList() {
		return allList;
	}

	public void setAllList(List<SurveySectionDefinitionImplBo> allList) {
		this.allList = allList;
	}

}
