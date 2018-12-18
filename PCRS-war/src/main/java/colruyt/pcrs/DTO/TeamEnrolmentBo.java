package colruyt.pcrs.DTO;

import java.util.HashMap;
import java.util.Map;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.team.EnrolmentBo;
import colruyt.pcrsejb.bo.user.team.TeamBo;
/**
 * TEAM ENROLMENT BO
 * @author jda1mbw
 */
public class TeamEnrolmentBo {
	
	private TeamBo team;
	private Map<EnrolmentBo, UserBo> enrolmentMap = new HashMap<>();
	
	/**
	 * Constructor
	 * @param team
	 */
	public TeamEnrolmentBo(TeamBo team) {
		super();
		this.team = team;
		
	} 
	
	/**
	 * Get team
	 * @return team
	 */
	public TeamBo getTeam() {
		return team;
	}
	
	/**
	 * Set team
	 * @param team
	 */
	public void setTeam(TeamBo team) {
		this.team = team;
	}

	/**
	 * Get map of enrolments
	 * @return enrolmentMap
	 */
	public Map<EnrolmentBo, UserBo> getEnrolmentMap() {
		return enrolmentMap;
	}

	/**
	 * Set map of enrolments
	 * @param enrolmentMap
	 */
	public void setEnrolmentMap(Map<EnrolmentBo, UserBo> enrolmentMap) {
		this.enrolmentMap = enrolmentMap;
	}
	
	/**
	 * Add an enrolment to the map
	 * @param enrolment
	 * @param user
	 */
	public void addEnrolmentToMap(EnrolmentBo enrolment, UserBo user) {
		enrolmentMap.put(enrolment, user);
	}
}
