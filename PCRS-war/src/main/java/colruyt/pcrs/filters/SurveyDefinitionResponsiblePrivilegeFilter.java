package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

/**
 * SURVEY DEFINITION RESPONSIBLE PRIVILEGE FILTER
 */
public class SurveyDefinitionResponsiblePrivilegeFilter extends PrivilegeFilter {

	/**
	 * Constructor
	 */
	public SurveyDefinitionResponsiblePrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE);
	}

}
