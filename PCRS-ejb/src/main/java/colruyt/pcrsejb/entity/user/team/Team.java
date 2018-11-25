package colruyt.pcrsejb.entity.user.team;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name = "TEAMS")
//@NamedQueries({ @NamedQuery(name = "Team.getAllElements", query = "select t from Team t"),
//		@NamedQuery(name = "Team.getTeamOfUser", query = "select t from users us join userprivileges up "
//				+ "on US.ID = UP.USER_ID join teamenrolments te on UP.id = TE.USERPRIVILEGE_ID "
//				+ "join teams t on te.team_id = t.id where us.id = :id"),
//		@NamedQuery(name = "Team.getTeamOfEnrolment", query = "select t from teamenrolments te "
//				+ "join teams t on te.team_id = T.ID where te.id = :id") })
public class Team extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TEAMS_SEQ")
	@SequenceGenerator(sequenceName = "TEAMS_SEQ", allocationSize = 1, name = "TEAMS_SEQ")
	@Column(name = "ID")
	private Integer id;
	private String name;
	@OneToMany
	@JoinColumn(name = "TEAM_ID")
	private Set<Enrolment> enrolments = new HashSet<>();
	/*
	 * CONSTRUCTORS
	 */
	public Team() {
		super();
	}
	public Team(String name, Set<Enrolment> enrolments) {
		super();
		this.name = name;
		this.enrolments = enrolments;
	}
	public Team(Integer id, String name, Set<Enrolment> enrolments) {
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
	public Set<Enrolment> getEnrolments() {
		return enrolments;
	}
	public void setEnrolments(Set<Enrolment> enrolments) {
		this.enrolments = enrolments;
	}
}
