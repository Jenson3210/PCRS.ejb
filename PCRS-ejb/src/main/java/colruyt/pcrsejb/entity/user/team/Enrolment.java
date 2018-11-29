package colruyt.pcrsejb.entity.user.team;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;

@Entity
@Table(name="TEAMENROLMENTS")
@NamedQueries({ 
	@NamedQuery(name = "ENROLMENT.GETALL", query = "SELECT e FROM Enrolment e"),
	@NamedQuery(name = "ENROLMENT.DEACTIVATE", query = "UPDATE UserPrivilege SET active = :active WHERE id = :id")
})

public class Enrolment extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENROLMENTS_SEQ")
    @SequenceGenerator(sequenceName = "ENROLMENTS_SEQ", allocationSize = 1, name = "ENROLMENTS_SEQ")
    @Column(name="ID")
    private Integer id;
    @ManyToOne
    private UserPrivilege userPrivilege;
    private Boolean active;
    /*
     * CONSTRUCTORS
     */
    public Enrolment() {
    	super();
    }
    public Enrolment(UserPrivilege userPrivilege, Boolean active) {
		super();
		this.userPrivilege = userPrivilege;
		this.active = active;
	}
    public Enrolment(Integer id, UserPrivilege userPrivilege, Boolean active) {
		super();
		this.id = id;
		this.userPrivilege = userPrivilege;
		this.active = active;
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
	public UserPrivilege getUserPrivilege() {
		return userPrivilege;
	}
	public void setUserPrivilege(UserPrivilege userPrivilege) {
		this.userPrivilege = userPrivilege;
	}
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
