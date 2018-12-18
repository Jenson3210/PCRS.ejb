package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

/**
 * TEAM MANAGER PRIVILEGE FILTER
 * @author jda1mbw
 */
public class TeamManagerPrivilegeFilter extends PrivilegeFilter {

	/**
	 * Constructor
	 */
	public TeamManagerPrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.TEAMMANAGER);
	}

}
