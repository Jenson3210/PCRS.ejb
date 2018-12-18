package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyDefinitionResponsibleUserPrivilegeBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.privilege.IUserPrivilegeFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

/**
 * ADMIN SURVEY DEFINITION VIEW
 * @author jda1mbw
 */
@Named
@ViewScoped
public class AdminSurveyDefinitionView implements Serializable {

	private static final long serialVersionUID = 5L;
	@EJB
	private IUserFacade userFacade;
	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;
	@EJB
	private IUserPrivilegeFacade userPrivilegeFacade;
	private Map<SurveyDefinitionBo, UserBo> surveyDefinitions = new HashMap<>();
	private SurveyDefinitionBo manipulatedSurveyDefinitionBo;
	private UserBo manipulatedUserBo;

	/**
	 * Mandatory empty constructor
	 */
	public AdminSurveyDefinitionView() {
	}

	/**
	 * Setup of the screen, loading the needed data
	 */
	@PostConstruct
	public void setup() {
		
		try {
			List<SurveyDefinitionBo> sd = surveyDefinitionFacade.getAll();
			for (SurveyDefinitionBo bo : sd) {
				surveyDefinitions.put(bo, surveyDefinitionFacade.getResponsible(bo));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	} 

	/**
	 * Generate new SurveyDefinition
	 */
	public void newSurveyDefinition() {
		manipulatedSurveyDefinitionBo = new SurveyDefinitionBo();
		manipulatedUserBo = new UserBo();
	}

	/**
	 * Add SurveyDefinition
	 * @throws ValidationException 
	 */
	public void addSurveyDefinition() throws ValidationException {
		// SAVE THE SURVEYDEFINITION
		manipulatedSurveyDefinitionBo = surveyDefinitionFacade.save(manipulatedSurveyDefinitionBo);
		// MAKE SOMEONE RESPONSIBLE
		manipulatedUserBo = userPrivilegeFacade.grantUserPrivilegeToUser(userFacade.get(manipulatedUserBo),
				new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true,
						manipulatedSurveyDefinitionBo));
		// ADD THE SURVEY TO THE SCREEN
		surveyDefinitions.put(manipulatedSurveyDefinitionBo, manipulatedUserBo);
	}

	/**
	 * method used for completing the autocomplete input field in the dialog when
	 * adding a survey definition
	 * 
	 * @param query: text typed in the input field
	 * @return: List of users for which their short name matches the query parameter
	 */
	public List<UserBo> completeShortName(String query) {
		return userFacade.getUsersByShortName("%" + query + "%");
	}

	/**
	 * deletes the survey definition from the List and from the DB
	 * @throws ValidationException 
	 */
	public void deleteSurveyDefinition() throws ValidationException {

		try {
			// REMOVE THE RESPONSIBLES PRIVILEGE
			userPrivilegeFacade.revokeUserPrivilegeTypeFromUser(userFacade.get(manipulatedUserBo),
					PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, manipulatedSurveyDefinitionBo);
			surveyDefinitionFacade.delete(manipulatedSurveyDefinitionBo);
			// REMOVE FROM LOCAL LIST
			surveyDefinitions.remove(manipulatedSurveyDefinitionBo);

			// DELETE THE SURVEYDEFINITION
		} catch (ValidationException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
		}
	}

	/**
	 * modifies the survey definition and sets a new name and/or new responsible
	 * @throws ValidationException 
	 */
	public void editSurveyDefinition() throws ValidationException {
		// REMOVE THE CURRENT RESPONSIBLES PRIVILEGE
		userPrivilegeFacade.revokeUserPrivilegeTypeFromUser(
				surveyDefinitionFacade.getResponsible(manipulatedSurveyDefinitionBo),
				PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, manipulatedSurveyDefinitionBo);
		// GIVE THE PRIVILEGE TO THE USER
		manipulatedUserBo = userPrivilegeFacade.grantUserPrivilegeToUser(userFacade.get(manipulatedUserBo),
				new SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE, true,
						manipulatedSurveyDefinitionBo));
		// UPDATE THE LIST
		for (SurveyDefinitionBo bo : surveyDefinitions.keySet()) {
			if (bo.getId() == manipulatedSurveyDefinitionBo.getId()) {
				bo.setFunction(manipulatedSurveyDefinitionBo.getFunction());
				bo.setOperatingUnit(manipulatedSurveyDefinitionBo.getOperatingUnit());
				bo.setCountry(manipulatedSurveyDefinitionBo.getCountry());
				surveyDefinitions.put(bo, manipulatedUserBo);
			}
		}
	}

	/**
	 * Get a map of SurveyDefinitions
	 * @return serveyDefinition
	 */
	public Map<SurveyDefinitionBo, UserBo> getSurveyDefinitions() {
		return this.surveyDefinitions;
	}

	/**
	 * Set a map of SurveyDefinitions
	 * @param surveyDefinitions
	 */
	public void setSurveyDefinitions(Map<SurveyDefinitionBo, UserBo> surveyDefinitions) {
		this.surveyDefinitions = surveyDefinitions;
	}

	/**
	 * Get a manipulated SurveyDefinition
	 * @return manipulatedSurveyDefinitionBo
	 */
	public SurveyDefinitionBo getManipulatedSurveyDefinitionBo() {
		return manipulatedSurveyDefinitionBo;
	}

	/**
	 * Set a manipulated SurveyDefinition
	 * @param manipulatedSurveyDefinition
	 */
	public void setManipulatedSurveyDefinitionBo(SurveyDefinitionBo manipulatedSurveyDefinition) {
		this.manipulatedSurveyDefinitionBo = manipulatedSurveyDefinition;
	}

	/**
	 * Get a manipulated User bo
	 * @return manipulatedUserBo
	 */
	public UserBo getManipulatedUserBo() {
		return manipulatedUserBo;
	}

	/**
	 * Set a manipulated User bo
	 * @param manipulatedUser
	 */
	public void setManipulatedUserBo(UserBo manipulatedUser) {
		this.manipulatedUserBo = manipulatedUser;
	}
}