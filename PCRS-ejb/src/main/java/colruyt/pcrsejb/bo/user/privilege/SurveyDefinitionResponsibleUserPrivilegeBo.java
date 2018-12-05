package colruyt.pcrsejb.bo.user.privilege;

import java.io.Serializable;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;

public class SurveyDefinitionResponsibleUserPrivilegeBo extends SurveyUserPrivilegeBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * CONSTRUCTORS
	 */

	public SurveyDefinitionResponsibleUserPrivilegeBo() {
		super();
	}

	public SurveyDefinitionResponsibleUserPrivilegeBo(Integer id, PrivilegeTypeBo privilegeType, Boolean active,
			SurveyDefinitionBo surveyDefinition) {
		super(id, privilegeType, active, surveyDefinition);
	}

	public SurveyDefinitionResponsibleUserPrivilegeBo(PrivilegeTypeBo privilegeType, Boolean active,
			SurveyDefinitionBo surveyDefinition) {
		super(privilegeType, active, surveyDefinition);
	}
	/*
	 * GETTERS AND SETTERS
	 */
	
}
