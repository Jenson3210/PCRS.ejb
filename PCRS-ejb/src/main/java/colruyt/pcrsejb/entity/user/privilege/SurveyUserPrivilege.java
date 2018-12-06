package colruyt.pcrsejb.entity.user.privilege;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;

@Entity
@DiscriminatorValue(value="HAS_SURVEYDEFINITION")
public class SurveyUserPrivilege extends UserPrivilege implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne(cascade= {CascadeType.MERGE})
	private SurveyDefinition surveyDefinition;
	/*
	 * CONSTRUCTORS
	 */
	public SurveyUserPrivilege() {
		super();
	}
	public SurveyUserPrivilege(PrivilegeType privilegeType, Boolean active, SurveyDefinition surveyDefinition) {
		super(privilegeType, active);
		this.surveyDefinition = surveyDefinition;
	}
	public SurveyUserPrivilege(Integer id, PrivilegeType privilegeType, Boolean active,
			SurveyDefinition surveyDefinition) {
		super(id, privilegeType, active);
		this.surveyDefinition = surveyDefinition;
	}
	/*
	 * GETTERS AND SETTERS
	 */

	public SurveyDefinition getSurveyDefinition() {
		return surveyDefinition;
	}
	public void setSurveyDefinition(SurveyDefinition surveyDefinition) {
		this.surveyDefinition = surveyDefinition;
	}
}
