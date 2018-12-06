<<<<<<< HEAD
package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.privilege.IUserPrivilegeFacade;

@ViewScoped
@Named
public class ManagerTeamViewChangeFunction implements Serializable {

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
			((SurveyUserPrivilegeBo) enrol.getUserPrivilege()).setSurveyDefinition(function);
			
			userBo.getPrivileges().add(enrol.getUserPrivilege());
			this.userFacade.save(userBo);
	}

}
=======
package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.privilege.IUserPrivilegeFacade;

@ViewScoped
@Named
public class ManagerTeamViewChangeFunction implements Serializable {

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

	private EnrolmentBo bo;

	private UserBo userBo;

	private List<SurveyDefinitionBo> availableFunctionDefinitions;
	public List<SurveyDefinitionBo> getAvailableFunctionDefinitions() {
		return this.surveyDefinitionFacade.getAll();
	}

	public void setAvailableFunctionDefinitions(List<SurveyDefinitionBo> availableFunctionDefinitions) {
		this.availableFunctionDefinitions = availableFunctionDefinitions;
	}

	public void init(UserBo bo, EnrolmentBo en) {

		this.bo = en;
		this.userBo = bo;
		

		if (en.getUserPrivilege() instanceof SurveyUserPrivilegeBo)

			this.function = ((SurveyUserPrivilegeBo) en.getUserPrivilege()).getSurveyDefinition();

	}

	public void submit() {

		

			((SurveyUserPrivilegeBo) bo.getUserPrivilege()).setSurveyDefinition(function);
			
			this.privilegeFacade.save(bo.getUserPrivilege());
		    this.userFacade.save(userBo);
		

	}

}
>>>>>>> branch 'master' of https://github.com/Jenson3210/PCRS.ejb.git
