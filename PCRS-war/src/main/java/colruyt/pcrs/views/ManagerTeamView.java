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

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import colruyt.pcrs.DTO.TeamEnrolmentBo;
import colruyt.pcrs.utillibs.WebUser;
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

/**
 * MANAGER TEAM VIEW
 * @author jda1mbw
 */
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
	private List<TeamEnrolmentBo> teamEnrolments = new ArrayList<>();
	private UserBo teamMember;
	
	/**
	 * Setup of the screen, loading the needed data
	 */
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
	
	/***************************************************************************************************************************************************************
	 ****																Getters and Setters																		****
	 ***************************************************************************************************************************************************************/
	
	/**
	 * Get team facade
	 * @return teamFacade
	 */
	public ITeamFacade getTeamFacade() {
		return teamFacade;
	}

	/**
	 * Set team facade
	 * @param teamFacade
	 */
	public void setTeamFacade(ITeamFacade teamFacade) {
		this.teamFacade = teamFacade;
	}
	
	/**
	 * Get list of surveySectionDefinitionImplBo
	 * @return allList
	 */
	public List<SurveySectionDefinitionImplBo> getAllList() {
		return allList;
	}

	/**
	 * Set list of surveySectionDefinitionImplBo
	 * @param allList
	 */
	public void setAllList(List<SurveySectionDefinitionImplBo> allList) {
		this.allList = allList;
	}

	/**
	 * Get enrolment facade
	 * @return enrolmentFacade
	 */
	public IEnrolmentFacade getEnrolmentFacade() { 
		return enrolmentFacade;
	}

	/**
	 * Set enrolment facade
	 * @param enrolmentFacade
	 */
	public void setEnrolmentFacade(IEnrolmentFacade enrolmentFacade) {
		this.enrolmentFacade = enrolmentFacade;
	}

	/**
	 * Get survey facade
	 * @return
	 */
	public ISurveySetFacade getSurveyFacade() {
		return surveyFacade;
	}

	/**
	 * Set survey facade
	 * @param surveyFacade
	 */
	public void setSurveyFacade(ISurveySetFacade surveyFacade) {
		this.surveyFacade = surveyFacade;
	}

	/**
	 * Set list of team enrolments
	 * @return
	 */
	public List<TeamEnrolmentBo> getTeamEnrolments() {
		return teamEnrolments;
	}

	/**
	 * Set list of team enrolments
	 * @param teamEnrolments
	 */
	public void setTeamEnrolments(List<TeamEnrolmentBo> teamEnrolments) {
		this.teamEnrolments = teamEnrolments;
	}
	
	/**
	 * Get list of surveySectionDefinitionImplBo
	 * @return chosenList
	 */
	public List<SurveySectionDefinitionImplBo> getChosenList() {
		return chosenList;
	}

	/**
	 * Set list of surveySectionDefinitionImplBo
	 * @param chosenList
	 */
	public void setChosenList(List<SurveySectionDefinitionImplBo> chosenList) {
		this.chosenList = chosenList;
	}

	/**
	 * Get list of teams
	 * @return teams
	 */
	public List<TeamBo> getTeams() {
		return teams;
	}

	/**
	 * Set list of teams
	 * @param teams
	 */
	public void setTeams(List<TeamBo> teams) {
		this.teams = teams;
	}
	
	/**
	 * Get chosen survey section definition
	 * @return chosen
	 */
	public SurveySectionDefinitionImplBo getChosen() {
		return chosen;
	}

	/**
	 * Set chosen survey section definition
	 * @param chosen
	 */
	public void setChosen(SurveySectionDefinitionImplBo chosen) {
		this.chosen = chosen;
	}
	
	/**
	 * Get list of the available survey section definitions
	 * @return
	 */
	public DualListModel<SurveySectionDefinitionImplBo> getAvailableList() {
		return availableList;
	}
	
	/**
	 * Set list of the available survey section definitions
	 * @param availableList
	 */
	public void setAvailableList(DualListModel<SurveySectionDefinitionImplBo> availableList) {
		this.availableList = availableList; 
	}

	/**
	 * Get user from enrolment
	 * @param enrolment
	 * @return user
	 */
	public UserBo getUserFromEnrolment(EnrolmentBo enrolment) {
		UserBo user = null;
		try {
			user = userFacade.getUserByEnrolment(enrolment);
		} catch (NoExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	/**
	 * Get Manager Survey percentage
	 * @param user
	 * @return
	 */
	public Integer getManagerSurveyPercentage(UserBo user) {
		try {
			return this.getSurveyFacade().getPercentageCompleteForManagerSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}
	}

	/**
	 * Get the percentage of the memberSurvey
	 * @param user
	 * @return percentage
	 */
	public Integer getMemberSurveyPercentage(UserBo user) {
		try {
			return this.getSurveyFacade().getPercentageCompleteForMemberSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}
	}

	/**
	 * Get the percentage of the consensusSurvey
	 * @param user
	 * @return percentage
	 */
	public Integer getConsensusSurveyPercentage(UserBo user) {
		try {
		    return this.getSurveyFacade().getPercentageCompleteForConsensusSurvey(user);
		} catch (NoSurveySetException e) {
			return 0;
		}
	}
	
	/**
	 * Get function of enrolment
	 * @param bo
	 * @return function
	 */
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
	
	/**
	 * Get teamMember
	 * @return
	 */
	public UserBo getTeamMember() {
		return teamMember;
	}

	/**
	 * Set teamMember
	 * @param teamMember
	 */
	public void setTeamMember(UserBo teamMember) {
		this.teamMember = teamMember;
	}
	
	/***************************************************************************************************************************************************************
	 ****																	Other																				****
	 ***************************************************************************************************************************************************************/
	
	/**
	 * Method to check if it's you
	 * @param bo
	 * @return
	 */
	public boolean isMe(UserBo bo) {
		return !this.currentUser.getUser().equals(bo);
	}
	
	/**
	 * Method that shows if the consensus can be filled in
	 * @param user
	 * @return boolean
	 */
	public Boolean consensusReady(UserBo user) { 
		return this.getManagerSurveyPercentage(user) == 100 && this.getMemberSurveyPercentage(user) == 100;
	}

	/**
	 * Method to check if there is a userpivilige function
	 * @param bo
	 * @return boolean
	 */
	public boolean hasFunction(EnrolmentBo bo) {
		if (bo.getUserPrivilege() instanceof SurveyUserPrivilegeBo) {			
			return ((SurveyUserPrivilegeBo) bo.getUserPrivilege()).getSurveyDefinition() != null;
		}
		return false;
	}
	
	// Dialog Create Survey

	/**
	 * Set teamMember and load the competences
	 * @param user
	 */
	public void initDialog(UserBo user) { 
		
		this.availableList.getTarget().clear();
		this.setTeamMember(user);
		this.loadCompetences();
	}

	/**
	 * Load competences
	 */

	private void loadCompetences() {
		
		
		
		
		this.allList.clear();
		this.chosenList.clear();
		
		
		this.allList = this.surveyFacade.getPossibleSections(this.getTeamMember());
		List<SurveySectionDefinitionImplBo> lijst = this.allList.stream().filter(x->x.getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED)).collect(Collectors.toList());
		this.chosenList.addAll(lijst);
		
		this.allList.removeAll(this.chosenList);
		availableList.setSource(getAllList());
		this.availableList.setTarget(this.getChosenList());
		
		
	}
	
	

			
			
	public Boolean isDisabled(SurveySectionDefinitionImplBo bo) {
		
		try {
			return this.surveySectionDefinitionImplFacade.get(bo).getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	
	
		
    
	
	
	
	
	


	/**
	 * Submit method
	 */
	public void submit() {
		//Try to add surveySectionDefinition
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
		
		//Try to save the teamMember
		try {
			this.userFacade.save(this.teamMember);
						
			FacesContext context = FacesContext.getCurrentInstance();
			String message= context.getApplication().evaluateExpressionGet(context, "#{msgs['success.create.survey.titel']}",
					String.class);			
			
			String titel = context.getApplication().evaluateExpressionGet(context, "#{msgs['success.create.survey.body']}",
					String.class);			
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, titel, message);

			context.addMessage(null, myFacesMessage); 
			
		} catch (ValidationException e) {
			
			FacesContext context = FacesContext.getCurrentInstance();
			String message= context.getApplication().evaluateExpressionGet(context, "#{msgs['error.general']}",
					String.class);			
			
			String titel = context.getApplication().evaluateExpressionGet(context, "#{msgs['error.create.survey.titel']}",
					String.class);	
			
			FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, titel, message);
			context.addMessage(null, myFacesMessage); 
		}
		
		
	}	
	
	
	
	
	

	

}
