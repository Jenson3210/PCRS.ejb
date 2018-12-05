package colruyt.pcrs.DTO;

import java.util.HashMap;
import java.util.Map;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;

public class TeamEnrolmentBo {
	private TeamBo team;
	private Map<EnrolmentBo, UserBo> enrolmentMap = new HashMap<>();
	
	public TeamEnrolmentBo(TeamBo team) {
		super();
		this.team = team;
		
	} 
	
	public TeamBo getTeam() {
		return team;
	}
	
	public void setTeam(TeamBo team) {
		this.team = team;
	}

	public Map<EnrolmentBo, UserBo> getEnrolmentMap() {
		return enrolmentMap;
	}

	public void setEnrolmentMap(Map<EnrolmentBo, UserBo> enrolmentMap) {
		this.enrolmentMap = enrolmentMap;
	}
	
	public void addEnrolmentToMap(EnrolmentBo enrolment, UserBo user) {
		enrolmentMap.put(enrolment, user);
	}
	
}
