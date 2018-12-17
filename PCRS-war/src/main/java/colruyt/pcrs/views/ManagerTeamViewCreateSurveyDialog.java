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

/**
 * MANAGER TEAM VIEW CREATE SURVEY DIALOG
 * @author jda1mbw
 */
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
	
	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	public void emptyPickList() {
		availableList = new DualListModel<>(allList, chosenList);
	}
	
	/**
	 * Get the chosen survey section definition
	 * @return chosen
	 */
	public SurveySectionDefinitionImplBo getChosen() {
		return chosen;
	}

	/**
	 * Set the chosen survey section definition
	 * @param chosen
	 */
	public void setChosen(SurveySectionDefinitionImplBo chosen) {
		this.chosen = chosen;
	}
	
	/**
	 * Get list of available survey section definitions
	 * @return availableList
	 */
	public DualListModel<SurveySectionDefinitionImplBo> getAvailableList() {
		return availableList;
	}
	
	/**
	 * Set list of available survey section definitions
	 * @param availableList
	 */
	public void setAvailableList(DualListModel<SurveySectionDefinitionImplBo> availableList) {
		this.availableList = availableList; 
	}
	
	/**
	 * Get Manager
	 * @return
	 */
	public UserBo getManager() {
		return manager;
	}

	/**
	 * Set Manager
	 * @param manager
	 */
	public void setManager(UserBo manager) {
		this.manager = manager;
	}

	/**
	 * Get TeamMember
	 * @return
	 */
	public UserBo getTeamMember() {
		return teamMember;
	}

	/**
	 * Set TeamMember
	 * @param teamMember
	 */
	public void setTeamMember(UserBo teamMember) {
		this.teamMember = teamMember;
	}

	/**
	 * Get list of chosen survey section definitions
	 * @return chosenList
	 */
	public List<SurveySectionDefinitionImplBo> getChosenList() {
		return chosenList;
	}

	/**
	 * Set list of chosen survey section definitions
	 * @param chosenList
	 */
	public void setChosenList(List<SurveySectionDefinitionImplBo> chosenList) {
		this.chosenList = chosenList;
	}
	
	/**
	 * Get list of survey section definitions
	 * @return allList
	 */
	public List<SurveySectionDefinitionImplBo> getAllList() {
		return allList;
	}

	/**
	 * Set list of survey section definitions
	 * @param allList
	 */
	public void setAllList(List<SurveySectionDefinitionImplBo> allList) {
		this.allList = allList;
	}
	
	/**
	 * Method to load all competences
	 */
	private void loadCompetences() {
		this.allList = this.surveyFacade.getPossibleSections(this.teamMember);
		List<SurveySectionDefinitionImplBo> lijst = this.allList.stream().filter(x->x.getSurveySectionRequirementLevelBo().equals(SurveySectionRequirementLevelBo.OBLIGATED)).collect(Collectors.toList());
		this.chosenList.addAll(lijst);
		this.allList.removeAll(this.chosenList);
		availableList.setSource(getAllList());
		availableList.setTarget(getChosenList());
	}

	/**
	 * In it dialog
	 * @param user
	 */
	public void initDialog(UserBo user) { 
		this.setTeamMember(user);
		this.setManager(this.currentUser.getUser());
		this.loadCompetences();
	}
	
	/**
	 * Method to create survey dialog
	 */
	public ManagerTeamViewCreateSurveyDialog() {
		super();
		System.out.println("hallo");
	}
	
	/**
	 * Submit method
	 */
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

}
