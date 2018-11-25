package colruyt.pcrsejb.entity.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;

@Entity
@Table(name="SURVEYSECTIONDEFINITIONS")
public class SurveySectionDefinition extends AbstractEntity implements Serializable {
	/* 
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYSECTIONDEFINITIONS_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYSECTIONDEFINITIONS_SEQ", allocationSize = 1, name = "SURVEYSECTIONDEFINITIONS_SEQ")
	@Column(name="ID")
	private Integer id;
	private Boolean administratorCreated;
	@Enumerated(EnumType.STRING)
	private SurveySectionRequirementLevel surveySectionRequirementLevel;
	@ManyToOne
	private SurveySectionTitle surveySectionTitle;
	@OneToOne
	private SurveySectionStrategy surveySectionStrategy;
	@OneToMany
	@JoinColumn(name="SURVEYSECTIONDEFINITIONS_ID")
	private List<Competence> surveySectionCompetences;
	/*
	 * CONSTRUCTORS
	 */
	public SurveySectionDefinition() {
		super();
	}
	public SurveySectionDefinition(SurveySectionTitle surveySectionTitle, SurveySectionStrategy surveySectionStrategy, List<Competence> surveySectionCompetences, Boolean administratorCreated, SurveySectionRequirementLevel surveySectionRequirementLevel) {
		super();
		this.surveySectionTitle = surveySectionTitle;
		this.surveySectionStrategy = surveySectionStrategy;
		this.surveySectionCompetences = surveySectionCompetences;
		this.administratorCreated = administratorCreated;
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
	}
	public SurveySectionDefinition(Integer id,SurveySectionTitle surveySectionTitle, SurveySectionStrategy surveySectionStrategy, List<Competence> surveySectionCompetences, Boolean administratorCreated, SurveySectionRequirementLevel surveySectionRequirementLevel) {
		super();
		this.id = id;
		this.surveySectionTitle = surveySectionTitle;
		this.surveySectionStrategy = surveySectionStrategy;
		this.surveySectionCompetences = surveySectionCompetences;
		this.administratorCreated = administratorCreated;
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
	}
	/*
	 * GETTERS AND SETTERS
	 */	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public SurveySectionTitle getSurveySectionTitle() {
		return surveySectionTitle;
	}
	public void setSurveySectionTitle(SurveySectionTitle surveySectionTitle) {
		this.surveySectionTitle = surveySectionTitle;
	}
	public SurveySectionStrategy getSurveySectionStrategy() {
		return surveySectionStrategy;
	}
	public void setSurveySectionStrategy(SurveySectionStrategy surveySectionStrategy) {
		this.surveySectionStrategy = surveySectionStrategy;
	}
	public List<Competence> getSurveySectionCompetences() {
		return surveySectionCompetences;
	}
	public void setSurveySectionCompetences(List<Competence> surveySectionCompetences) {
		this.surveySectionCompetences = surveySectionCompetences;
	}
	public Boolean getAdministratorCreated() {
		return administratorCreated;
	}
	public void setAdministratorCreated(Boolean administratorCreated) {
		this.administratorCreated = administratorCreated;
	}
	public SurveySectionRequirementLevel getSurveySectionRequirementLevel() {
		return surveySectionRequirementLevel;
	}
	public void setSurveySectionRequirementLevel(SurveySectionRequirementLevel surveySectionRequirementLevel) {
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
	}
}
