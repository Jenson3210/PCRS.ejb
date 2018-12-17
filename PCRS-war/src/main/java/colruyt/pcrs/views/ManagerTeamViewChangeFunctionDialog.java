
package colruyt.pcrs.views;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.privilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.privilege.IUserPrivilegeFacade;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@ViewScoped
@Named
public class ManagerTeamViewChangeFunctionDialog implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private SurveyDefinitionBo function;

	public SurveyDefinitionBo getFunction() {
		return function;
	}

	public void setFunction(SurveyDefinitionBo function) {
		this.function = function;
	}

	@EJB
	private IUserFacade userFacade;

	@EJB
	private ISurveyDefinitionFacade surveyDefinitionFacade;

	@EJB
	private IUserPrivilegeFacade privilegeFacade;

	@Inject
	private WebUser currentUser;

	private EnrolmentBo enrol;

	private UserBo userBo;

	private List<SurveyDefinitionBo> availableFunctionDefinitions;

	public List<SurveyDefinitionBo> getAvailableFunctionDefinitions() {
		return this.surveyDefinitionFacade.getAll();
	}

	public void setAvailableFunctionDefinitions(List<SurveyDefinitionBo> availableFunctionDefinitions) {
		this.availableFunctionDefinitions = availableFunctionDefinitions;
	}

	public void init(UserBo userbo, EnrolmentBo en) {

		this.enrol = en;
		this.userBo = userbo;

		if (en.getUserPrivilege() instanceof SurveyUserPrivilegeBo) {
			this.function = ((SurveyUserPrivilegeBo) en.getUserPrivilege()).getSurveyDefinition();
		}
	} 

	public void submit() {
		
		((TeamMemberUserPrivilegeBo) enrol.getUserPrivilege()).setSurveyDefinition(function);
		((TeamMemberUserPrivilegeBo) enrol.getUserPrivilege()).setStartDateCurrentSurveyDefinition(LocalDate.now());
			
		userBo.getPrivileges().add(enrol.getUserPrivilege());
		
			try {
				this.userFacade.save(userBo);
			} catch (ValidationException e) {
				FacesContext context = FacesContext.getCurrentInstance();
				String message= context.getApplication().evaluateExpressionGet(context, "#{msgs['error.general']}",
						String.class);
				
				FacesMessage myFacesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, null, message);
				context.addMessage(null, myFacesMessage);
			}
		
	}
}