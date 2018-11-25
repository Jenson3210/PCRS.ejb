package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

public class TeamManagerPrivilegeFilter extends PrivilegeFilter {

	public TeamManagerPrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.TEAMMANAGER);
	}

}
