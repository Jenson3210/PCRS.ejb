package colruyt.pcrs.views;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import colruyt.pcrs.utillibs.WebUser;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.facade.user.team.EnrolmentFacade;
import colruyt.pcrsejb.facade.user.team.TeamFacade;

@Named
@ViewScoped
public class TeamsView implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
    private TeamFacade teamFacade;
    @EJB
    private EnrolmentFacade enrolmentFacade;

    private List<TeamBo> teams;

    @Inject
    WebUser webUser;

    private TeamBo manipulatedTeamBo;
    private EnrolmentBo manipulatedEnrolmentBo;
    private List<RoleBo> possibleRolesBo;

    @PostConstruct
    private void fillList() {

        System.out.println(webUser.getUser().getFullName());
        teams = teamFacade.getAllTeams();
    }

    public void editEnrolment() {
        enrolmentFacade.saveEnrolment(manipulatedEnrolmentBo);
    }


    public List<TeamBo> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamBo> teams) {
        this.teams = teams;
    }

    public TeamBo getManipulatedTeamBo() {
        return manipulatedTeamBo;
    }

    public void setManipulatedTeamBo(TeamBo manipulatedTeamBo) {
        this.manipulatedTeamBo = manipulatedTeamBo;
    }

    public EnrolmentBo getManipulatedEnrolmentBo() {
        return manipulatedEnrolmentBo;
    }

    public void setManipulatedEnrolmentBo(EnrolmentBo manipulatedEnrolmentBo) {
        this.manipulatedEnrolmentBo = manipulatedEnrolmentBo;
    }

    public List<RoleBo> getPossibleRolesBo() {
        return possibleRolesBo;
    }

    public void setPossibleRolesBo(List<RoleBo> possibleRolesBo) {
        this.possibleRolesBo = possibleRolesBo;
    }


    public void newTeam() {
        manipulatedTeamBo = new TeamBo();
    }

    public void selectedEnrolment() {
        //TODO CHECK IF FIRST OR SECOND
        possibleRolesBo = new ArrayList<>();
        for (RoleBo r : ((FunctionUserPrivilegeBo) manipulatedEnrolmentBo.getPrivilegeBo()).getFunction().getRoleBoSet()) {
            possibleRolesBo.add(r);
        }
    }

    public void addTeam() {

    }
}

