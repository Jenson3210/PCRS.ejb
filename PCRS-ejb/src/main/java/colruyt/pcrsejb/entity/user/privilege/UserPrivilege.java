package colruyt.pcrsejb.entity.user.privilege;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name="USERPRIVILEGES")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="P_DISCRIMINATOR")
@DiscriminatorValue(value="NON-FUNCTIONHOLDING")
//@NamedQuery(name="USER.GETALL", query="select u from User u"), 
@NamedQueries({		@NamedQuery(name="USER.GETACTIVEPRIVILEGE", 
						query="select p from User u join u.privileges p where p.active = :isActive and u = :user")})
public class UserPrivilege extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERPRIVILEGES_SEQ")
    @SequenceGenerator(sequenceName = "USERPRIVILEGES_SEQ", allocationSize = 1, name = "USERPRIVILEGES_SEQ")
	@Column(name="ID")
	private Integer id;
	@Enumerated(EnumType.STRING) 
	@NotNull
	private PrivilegeType privilegeType;
	@NotNull
	private Boolean active;
	/*
	 * CONSTRUCTORS
	 */
	public UserPrivilege() {
		super();
	}
	public UserPrivilege(PrivilegeType privilegeType, Boolean active) {
		setPrivilegeType(privilegeType);
		setActive(active);
	}
	public UserPrivilege(Integer id, PrivilegeType privilegeType, Boolean active) {
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

	public PrivilegeType getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(PrivilegeType privilegeType) {
		this.privilegeType = privilegeType;
	}

	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
}
