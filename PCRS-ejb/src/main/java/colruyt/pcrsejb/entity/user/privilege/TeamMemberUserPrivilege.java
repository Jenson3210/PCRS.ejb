package colruyt.pcrsejb.entity.user.privilege;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveyDefinition;
import colruyt.pcrsejb.entity.surveys.surveySet.SurveySet;

@Entity
@DiscriminatorValue(value="TEAMMEMBER")
public class TeamMemberUserPrivilege extends SurveyUserPrivilege implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="STARTDATE")
	private LocalDate startDateCurrentSurveyDefinition; 
	@OneToMany
	@JoinColumn(name="USERPRIVILEGE_ID")
    private Set<SurveySet> surveySetTreeSet = new TreeSet<>();
	/*
	 * CONSTRUCTORS
	 */
	public TeamMemberUserPrivilege() {
		super();
	}
	public TeamMemberUserPrivilege(PrivilegeType privilegeType, Boolean active, SurveyDefinition surveyDefinition,
			LocalDate startDateCurrentSurveyDefinition, Set<SurveySet> surveySetTreeSet) {
		super(privilegeType, active, surveyDefinition);
		this.startDateCurrentSurveyDefinition = startDateCurrentSurveyDefinition;
		this.surveySetTreeSet = surveySetTreeSet;
	}
	public TeamMemberUserPrivilege(Integer id, PrivilegeType privilegeType, Boolean active,
			SurveyDefinition surveyDefinition, LocalDate startDateCurrentSurveyDefinition,
			Set<SurveySet> surveySetTreeSet) {
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
	public Set<SurveySet> getSurveySetTreeSet() {
		return surveySetTreeSet;
	}
	public void setSurveySetTreeSet(Set<SurveySet> surveySetTreeSet) {
		this.surveySetTreeSet = surveySetTreeSet;
	}
	
	
}
