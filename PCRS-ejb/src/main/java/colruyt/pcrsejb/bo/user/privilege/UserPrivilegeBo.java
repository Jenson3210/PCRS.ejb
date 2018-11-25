package colruyt.pcrsejb.bo.user.privilege;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class UserPrivilegeBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private PrivilegeTypeBo privilegeType;
	private Boolean active;
	/*
	 * CONSTRUCTORS
	 */
	public UserPrivilegeBo() {
		super();
	}
	public UserPrivilegeBo(PrivilegeTypeBo privilegeType, Boolean active) {
		setPrivilegeType(privilegeType);
		setActive(active);
	}
	public UserPrivilegeBo(Integer id, PrivilegeTypeBo privilegeType, Boolean active) {
		setId(id);
		setPrivilegeType(privilegeType);
		setActive(active);
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

	public PrivilegeTypeBo getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(PrivilegeTypeBo privilegeType) {
		this.privilegeType = privilegeType;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
