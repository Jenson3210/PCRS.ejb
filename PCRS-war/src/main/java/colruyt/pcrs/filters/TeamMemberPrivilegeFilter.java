package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

/**
 * TEAM MEMBER PRIVILEGE FILTER
 * @author jda1mbw
 */
public class TeamMemberPrivilegeFilter extends PrivilegeFilter {

	/**
	 * Constructor
	 */
	public TeamMemberPrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.TEAMMEMBER);
	}

}
