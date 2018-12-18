package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;
/**
 * ADMIN PRIVILEGE FILTER
 * @author jda1mbw
 */
public class AdminPrivilegeFilter extends PrivilegeFilter {
	public AdminPrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.ADMINISTRATOR);
	}
}
