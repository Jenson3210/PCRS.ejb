package colruyt.pcrs.views;

import java.util.List;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.user.team.IEnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.ITeamFacade;

@Named
@ViewScoped
public class AdminTeamView implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB 
	ITeamFacade teamFacade;
	
	@EJB
	IEnrolmentFacade enrolmentFacade;
	
	private List<TeamBo> teams; 
	
    private TeamBo manipulatedTeamBo;
    private EnrolmentBo manipulatedEnrolmentBo;

    @PostConstruct
    private void fillList() {
        teams = teamFacade.getAll();
    }


    public void editEnrolment() {
        enrolmentFacade.save(manipulatedEnrolmentBo);
    }


    public List<TeamBo> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamBo> teams) {
        this.teams = teams;
    }

    public EnrolmentBo getManipulatedEnrolmentBo() {
        return manipulatedEnrolmentBo;
    }

    public void setManipulatedEnrolmentBo(EnrolmentBo manipulatedEnrolmentBo) {
        this.manipulatedEnrolmentBo = manipulatedEnrolmentBo;
    }

    public TeamBo getManipulatedTeamBo() {
        return manipulatedTeamBo;
    }

    public void setManipulatedTeamBo(TeamBo manipulatedTeamBo) {
        this.manipulatedTeamBo = manipulatedTeamBo;
    }

    public void newTeam() {
        manipulatedTeamBo = new TeamBo();
    }
	
}
