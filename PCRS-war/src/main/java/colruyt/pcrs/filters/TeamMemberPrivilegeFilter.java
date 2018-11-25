package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

public class TeamMemberPrivilegeFilter extends PrivilegeFilter {

	public TeamMemberPrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.TEAMMEMBER);
	}

}
