package colruyt.pcrsejb.entity.user.privilege;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;

@Entity
@DiscriminatorValue(value="SURVEYDEFINITIONRESPONSIBLE")
public class SurveyDefinitionResponsibleUserPrivilege extends SurveyUserPrivilege implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * CONSTRUCTORS
	 */

	public SurveyDefinitionResponsibleUserPrivilege() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SurveyDefinitionResponsibleUserPrivilege(PrivilegeType privilegeType, Boolean active,
			SurveyDefinition surveyDefinition) {
		super(privilegeType, active, surveyDefinition);
		// TODO Auto-generated constructor stub
	}
	public SurveyDefinitionResponsibleUserPrivilege(Integer id, PrivilegeType privilegeType, Boolean active,
			SurveyDefinition surveyDefinition) {
		super(id, privilegeType, active, surveyDefinition);
		// TODO Auto-generated constructor stub
	}
	/*
	 * GETTERS AND SETTERS
	 */
}
