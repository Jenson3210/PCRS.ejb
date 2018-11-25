package colruyt.pcrsejb.bo.user.privilege;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import colruyt.pcrsejb.bo.surveyDefinition.survey.SurveyDefinitionBo;
import colruyt.pcrsejb.bo.surveys.surveySet.SurveySetBo;

public class TeamMemberUserPrivilegeBo extends SurveyUserPrivilegeBo implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private LocalDate startDateCurrentSurveyDefinition;
    private Set<SurveySetBo> surveySetTreeSet = new TreeSet<>();
	/*
	 * CONSTRUCTORS
	 */
	public TeamMemberUserPrivilegeBo() {
		super();
	}
	public TeamMemberUserPrivilegeBo(PrivilegeTypeBo privilegeType, Boolean active, SurveyDefinitionBo surveyDefinition,
			LocalDate startDateCurrentSurveyDefinition, Set<SurveySetBo> surveySetTreeSet) {
		super(privilegeType, active, surveyDefinition);
		this.startDateCurrentSurveyDefinition = startDateCurrentSurveyDefinition;
		this.surveySetTreeSet = surveySetTreeSet;
	}
	public TeamMemberUserPrivilegeBo(Integer id, PrivilegeTypeBo privilegeType, Boolean active,
			SurveyDefinitionBo surveyDefinition, LocalDate startDateCurrentSurveyDefinition,
			Set<SurveySetBo> surveySetTreeSet) {
		super(id, privilegeType, active, surveyDefinition);
		this.startDateCurrentSurveyDefinition = startDateCurrentSurveyDefinition;
		this.surveySetTreeSet = surveySetTreeSet;
	}
	/*
	 * GETTERS AND SETTERS
	 */
	public LocalDate getStartDateCurrentSurveyDefinition() {
		return startDateCurrentSurveyDefinition;
	}
	public void setStartDateCurrentSurveyDefinition(LocalDate startDateCurrentSurveyDefinition) {
		this.startDateCurrentSurveyDefinition = startDateCurrentSurveyDefinition;
	}
	public Set<SurveySetBo> getSurveySetTreeSet() {
		return surveySetTreeSet;
	}
	public void setSurveySetTreeSet(Set<SurveySetBo> surveySetTreeSet) {
		this.surveySetTreeSet = surveySetTreeSet;
	}
	
	
}
