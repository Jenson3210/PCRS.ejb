package colruyt.pcrs.filters;

import colruyt.pcrsejb.bo.user.privilege.PrivilegeTypeBo;

public class SurveyDefinitionResponsiblePrivilegeFilter extends PrivilegeFilter {

	public SurveyDefinitionResponsiblePrivilegeFilter() {
		super();
		setMinimumPrivilege(PrivilegeTypeBo.SURVEYDEFINITIONRESPONSIBLE);
	}

}
