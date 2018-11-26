package colruyt.pcrsejb.entity.user;

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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.user.privilege.UserPrivilege;

@Entity
@Table(name="USERS")
public class User extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
    @SequenceGenerator(sequenceName = "USERS_SEQ", allocationSize = 1, name = "USERS_SEQ")
    @Column(name="ID")
    private Integer id;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;
    @Column(name="EMAIL")
    private String email;
    @Column(name="PASSWORD")
    private String password="";
    @Column(name="HOMECOUNTRY")
    private String country;
    @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name="USER_ID")
    private Set<UserPrivilege> privileges = new HashSet<>();
    /*
     * CONSTRUCTORS
     */
    public User() {
    	super();
    }
	public User(String firstName, String lastName, String email, String password, String country,
			Set<UserPrivilege> privileges) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.country = country;
		this.privileges = privileges;
	}
	public User(Integer id, String firstName, String lastName, String email, String password,
			String country, Set<UserPrivilege> privileges) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.country = country;
		this.privileges = privileges;
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
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Set<UserPrivilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<UserPrivilege> privileges) {
		this.privileges = privileges;
	}    
}
