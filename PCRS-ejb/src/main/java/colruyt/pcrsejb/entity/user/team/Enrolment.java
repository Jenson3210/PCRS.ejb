package colruyt.pcrsejb.entity.user.team;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
import colruyt.pcrsejb.entity.user.User;
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
    @ManyToOne(cascade= {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
    private User user;
    @ManyToOne
    private UserPrivilege userPrivilege;
    private Boolean active;
    /*
     * CONSTRUCTORS
     */
    public Enrolment() {
    	super();
    }
    public Enrolment(User user, UserPrivilege userPrivilege, Boolean active) {
		super();
		this.user = user;
		this.userPrivilege = userPrivilege;
		this.active = active;
	}
    public Enrolment(Integer id, User user, UserPrivilege userPrivilege, Boolean active) {
		super();
		this.id = id;
		this.user = user;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
