package colruyt.pcrsejb.entity.user.team;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name = "TEAMS")
@NamedQueries({ 
	
	@NamedQuery(name = "TEAM.GETALL", query = "SELECT t FROM Team t"),
	@NamedQuery(name = "TEAM.GETTEAMFORUSER", query = "SELECT t FROM Team t join t.enrolments enrolment WHERE enrolment.user = :member and enrolment.active = :isActive"),
	@NamedQuery(name = "TEAM.GETTEAMSOFMANAGER", query = "SELECT t FROM Team t join t.enrolments enrolment where enrolment.userPrivilege.privilegeType = :privilegeType and enrolment.user= :teamManager")

//	@NamedQuery(name = "Team.getTeamOfEnrolment", query = "select t from teamenrolments te "
//			+ "join teams t on te.team_id = T.ID where te.id = :id"),
	

})
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
	@OneToMany(cascade = CascadeType.MERGE)
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
