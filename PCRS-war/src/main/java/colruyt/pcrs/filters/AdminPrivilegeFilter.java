package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

public class AdminPrivilegeFilter extends PrivilegeFilter {
	public AdminPrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.ADMINISTRATOR);
	}
}
