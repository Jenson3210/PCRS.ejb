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
    private UserPrivilegeBo userPrivilege;
    private Boolean active;
    /*
     * CONSTRUCTORS
     */
    public EnrolmentBo() {
    	super();
    }
    public EnrolmentBo(UserPrivilegeBo userPrivilege, Boolean active) {
		super();
		this.userPrivilege = userPrivilege;
		this.active = active;
	}
    public EnrolmentBo(Integer id, UserPrivilegeBo userPrivilege, Boolean active) {
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
