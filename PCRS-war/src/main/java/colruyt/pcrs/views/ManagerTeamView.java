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
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.IUserFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;
import colruyt.pcrsejb.util.exceptions.NoExistingMemberException;

@Named
@ViewScoped
public class ManagerTeamView implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITeamFacade teamFacade;
	
	@EJB
	private IUserFacade userFacade;
	
	@EJB
	private IEnrolmentFacade enrolmentFacade; 
	
	@EJB
	private ISurveySetFacade surveyFacade;
	
	
	private List<TeamBo> teams; 
	
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
  		teams =  teamFacade.getTeamsOfManager(currentUser.getUser());
		for(TeamBo t : teams) {
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
    
    
    
    public UserBo getUserFromEnrolment(EnrolmentBo enrolment){
		UserBo user = null;
		
		try {
			user = userFacade.getUserByEnrolment(enrolment);  
		} catch (NoExistingMemberException e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
   
    
    
    
    

}
