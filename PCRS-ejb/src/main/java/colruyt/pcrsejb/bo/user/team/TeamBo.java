package colruyt.pcrsejb.bo.user.team;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import colruyt.pcrsejb.bo.AbstractBo;

public class TeamBo extends AbstractBo implements Serializable, Comparable<TeamBo> {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Set<EnrolmentBo> enrolments = new HashSet<>();
	/*
	 * CONSTRUCTORS
	 */
	public TeamBo() {
		super();
	}
	public TeamBo(String name, Set<EnrolmentBo> enrolments) {
		super();
		this.name = name;
		this.enrolments = enrolments;
	}
	public TeamBo(Integer id, String name, Set<EnrolmentBo> enrolments) {
		super();
		this.id = id;
		this.name = name;
		this.enrolments = enrolments;
	}
	/*
	 * GETTERS AND SETTERS
	 */
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<EnrolmentBo> getEnrolments() {
		return enrolments;
	}
	public void setEnrolments(Set<EnrolmentBo> enrolments) {
		this.enrolments = enrolments;
	}
	@Override
	public int compareTo(TeamBo team) {
		if(this.id == team.id) {
			return 0;
		}else {
			return -1;
		}
	}
}
