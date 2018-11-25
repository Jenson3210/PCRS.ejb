package colruyt.pcrsejb.bo.user.privilege;

import java.io.Serializable;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;

public class SurveyUserPrivilegeBo extends UserPrivilegeBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private SurveyDefinitionBo surveyDefinition;
	/*
	 * CONSTRUCTORS
	 */
	public SurveyUserPrivilegeBo() {
		super();
	}
	public SurveyUserPrivilegeBo(PrivilegeTypeBo privilegeType, Boolean active, SurveyDefinitionBo surveyDefinition) {
		super(privilegeType, active);
		this.surveyDefinition = surveyDefinition;
	}
	public SurveyUserPrivilegeBo(Integer id, PrivilegeTypeBo privilegeType, Boolean active,
			SurveyDefinitionBo surveyDefinition) {
		super(id, privilegeType, active);
		this.surveyDefinition = surveyDefinition;
	}
	/*
	 * GETTERS AND SETTERS
	 */

	public SurveyDefinitionBo getSurveyDefinition() {
		return surveyDefinition;
	}
	public void setSurveyDefinition(SurveyDefinitionBo surveyDefinition) {
		this.surveyDefinition = surveyDefinition;
	}
}
