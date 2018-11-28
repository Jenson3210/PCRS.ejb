package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.surveys.surveySet.ISurveySetFacade;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;

@Named
@ViewScoped
public class ManagerTeamView implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ITeamFacade teamFacade;
	
	@EJB
	private IEnrolmentFacade enrolmentFacade;
	
	@EJB
	private ISurveySetFacade surveyFacade;
	
	
	private List<TeamBo> teams; 
	
	@Inject
	private WebUser currentUser;
	

    @PostConstruct
    public void fillList() {
        teams = teamFacade.getTeamsOfManager(currentUser.getUser());
        
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
    
    
    

}
