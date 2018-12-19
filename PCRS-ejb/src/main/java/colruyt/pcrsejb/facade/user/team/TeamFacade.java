package colruyt.pcrsejb.facade.user.team;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.user.team.EnrolmentConverter;
import colruyt.pcrsejb.converter.user.team.TeamConverter;
import colruyt.pcrsejb.service.bl.user.team.ITeamServiceBl;
import colruyt.pcrsejb.util.exceptions.MemberAlreadyHasATeamException;
import colruyt.pcrsejb.util.exceptions.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validations.ValidationException;

@Stateless
public class TeamFacade implements Serializable, ITeamFacade {

	@EJB
	private ITeamServiceBl teamBl;
	
	private TeamConverter teamConv = new TeamConverter();
	private UserConverter userConv = new UserConverter();
	private EnrolmentConverter enrolmentConv = new EnrolmentConverter();
	
	private static final long serialVersionUID = 1L;

	@Override
	public TeamBo save(TeamBo entityBo) throws ValidationException {
			return teamConv.convertToBo(this.teamBl.save(teamConv.convertToEntity(entityBo)));
	}

	@Override
	public TeamBo get(TeamBo entityBo) throws ValidationException {
		
			return teamConv.convertToBo(this.teamBl.get(teamConv.convertToEntity(entityBo)));
	}

	@Override
	public List<TeamBo> getAll() {
		return teamConv.convertToBos(this.teamBl.getAll());
	}

	@Override
	public void delete(TeamBo entityBo) throws ValidationException {
		this.teamBl.delete(teamConv.convertToEntity(entityBo));
		
	}

	@Override
	public UserBo getManagerForUser(UserBo user)  throws UserIsNotMemberOfTeamException{
		return this.userConv.convertToBo(this.teamBl.getManagerForUser(this.userConv.convertToEntity(user)));
	}

	@Override
	public TeamBo getTeamForUser(UserBo user) throws UserIsNotMemberOfTeamException{
		return this.teamConv.convertToBo(this.teamBl.getTeamForUser(this.userConv.convertToEntity(user)));
	}

	@Override
	public List<TeamBo> getTeamsOfManager(UserBo manager) {
		return this.teamConv.convertToBos(this.teamBl.getTeamsOfManager(this.userConv.convertToEntity(manager)));
	}

	@Override
	public void deleteUserFromTeam(TeamBo manipulatedTeamBo, EnrolmentBo enrolment, UserBo user) throws ValidationException {
		teamBl.removeUserFromTeam(teamConv.convertToEntity(manipulatedTeamBo),enrolmentConv.convertToEntity(enrolment), userConv.convertToEntity(user));
	}

	@Override
	public EnrolmentBo addUserToTeam(TeamBo manipulatedTeamBo, UserBo user, String userPrivilege) throws ValidationException {
		return enrolmentConv.convertToBo(teamBl.addUserToTeam(teamConv.convertToEntity(manipulatedTeamBo), userConv.convertToEntity(user), userPrivilege));
	}

	@Override
	public List<UserBo> getUsersOfTeam(TeamBo team) {
		return this.userConv.convertToBos(this.teamBl.getUsersOfTeam(this.teamConv.convertToEntity(team)));
	}
	
}
