package colruyt.pcrsejb.bo.user.team;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.user.privilege.UserPrivilegeBo;

public class EnrolmentBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    private UserBo user;
    private UserPrivilegeBo userPrivilege;
    private Boolean active;
    /*
     * CONSTRUCTORS
     */
    public EnrolmentBo() {
    	super();
    }
    public EnrolmentBo(UserBo user, UserPrivilegeBo userPrivilege, Boolean active) {
		super();
		this.user = user;
		this.userPrivilege = userPrivilege;
		this.active = active;
	}
    public EnrolmentBo(Integer id, UserBo user, UserPrivilegeBo userPrivilege, Boolean active) {
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
	public UserBo getUser() {
		return user;
	}
	public void setUser(UserBo user) {
		this.user = user;
	}
	public UserPrivilegeBo getUserPrivilege() {
		return userPrivilege;
	}
	public void setUserPrivilege(UserPrivilegeBo userPrivilege) {
		this.userPrivilege = userPrivilege;
	}
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
}
