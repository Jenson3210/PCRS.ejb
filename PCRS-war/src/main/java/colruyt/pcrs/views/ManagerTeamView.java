package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.DTO.TeamEnrolmentBo;
import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.SurveyUserPrivilegeBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.surveyDefinition.survey.ISurveyDefinitionFacade;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;
import colruyt.pcrsejb.util.exceptions.NoSurveySetException;

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
	private ISurveyDefinitionFacade  surveyDefinitionFacade;
	
	private List<TeamBo> teams;
	
	private List<SurveyDefinitionBo> availableFunctionDefinitions = new ArrayList<>();
	
	
	
	
	

	public List<SurveyDefinitionBo> getAvailableFunctionDefinitions() {
		return availableFunctionDefinitions;
	}

	public void setAvailableFunctionDefinitions(List<SurveyDefinitionBo> availableFunctionDefinitions) {
		this.availableFunctionDefinitions = availableFunctionDefinitions;
	}

	@Inject
	private WebUser currentUser;

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
		
		this.setAvailableFunctionDefinitions(this.surveyDefinitionFacade.getAll());

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

	public boolean consensusReady(UserBo user) {

		return !(this.getManagerSurveyPercentage(user) == 100 && this.getMemberSurveyPercentage(user) == 100);
		

	}
	
	public void onFunctionChange(EnrolmentBo bo,UserBo userBo) {
		
		if(bo.getUserPrivilege()  instanceof SurveyUserPrivilegeBo) {
			
			//((SurveyUserPrivilegeBo) bo.getUserPrivilege()).setSurveyDefinition();
			
			this.userFacade.save(userBo);
		}
		
		
		
	}
	
	public String getFunctionOf(EnrolmentBo bo) {
		
		if(bo.getUserPrivilege()  instanceof SurveyUserPrivilegeBo) {
			
			return ((SurveyUserPrivilegeBo) bo.getUserPrivilege()).getSurveyDefinition().getName();
			
			
		}
		return "geen";
		
	}
	
	public boolean hasFunction(EnrolmentBo bo) {
		
		
		if(bo.getUserPrivilege()  instanceof SurveyUserPrivilegeBo) {
			
			return ((SurveyUserPrivilegeBo) bo.getUserPrivilege()).getSurveyDefinition() != null;
			
		}
		return false;
	}

}
