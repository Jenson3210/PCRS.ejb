package colruyt.pcrsejb.bo.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;

public class UserBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
 
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password="";
    private String country;
    private String shortName;
    private Set<UserPrivilegeBo> privileges = new HashSet<>();
    /*
     * CONSTRUCTORS
     */
    public UserBo() {
    	super();
    }
	public UserBo(String firstName, String lastName, String email, String password, String country, String shortName,
			Set<UserPrivilegeBo> privileges) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.country = country;
		this.shortName = shortName;
		this.privileges = privileges;
	}
	public UserBo(Integer id, String firstName, String lastName, String email, String password,
			String country, String shortName, Set<UserPrivilegeBo> privileges) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.country = country;
		this.shortName = shortName;
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
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public Set<UserPrivilegeBo> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(Set<UserPrivilegeBo> privileges) {
		this.privileges = privileges;
	}
}
