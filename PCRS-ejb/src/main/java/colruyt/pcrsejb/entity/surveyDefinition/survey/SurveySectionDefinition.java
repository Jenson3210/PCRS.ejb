package colruyt.pcrsejb.entity.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.competence.CompetenceImpl;
import colruyt.pcrsejb.entity.surveyDefinition.strategy.SurveySectionStrategy;

@Entity
@Table(name="SURVEYSECTIONDEFINITIONS")
@NamedQuery(name= "SURVEYSECTIONDEFINITION.GETALL", query = "SELECT ssd FROM SurveySectionDefinition ssd")


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
	@ManyToOne
	private SurveySectionTitle surveySectionTitle;
	@OneToOne
	private SurveySectionStrategy surveySectionStrategy;
	@OneToMany
	@JoinColumn(name="SURVEYSECTIONDEFINITIONS_ID")
	private List<CompetenceImpl> surveySectionCompetences;
	/*
	 * CONSTRUCTORS
	 */
	public SurveySectionDefinition() {
		super();
	}
	public SurveySectionDefinition(SurveySectionTitle surveySectionTitle, SurveySectionStrategy surveySectionStrategy, List<CompetenceImpl> surveySectionCompetences, Boolean administratorCreated) {
		super();
		this.surveySectionTitle = surveySectionTitle;
		this.surveySectionStrategy = surveySectionStrategy;
		this.surveySectionCompetences = surveySectionCompetences;
		this.administratorCreated = administratorCreated;
	}
	public SurveySectionDefinition(Integer id,SurveySectionTitle surveySectionTitle, SurveySectionStrategy surveySectionStrategy, List<CompetenceImpl> surveySectionCompetences, Boolean administratorCreated) {
		super();
		this.id = id;
		this.surveySectionTitle = surveySectionTitle;
		this.surveySectionStrategy = surveySectionStrategy;
		this.surveySectionCompetences = surveySectionCompetences;
		this.administratorCreated = administratorCreated;
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
	public List<CompetenceImpl> getSurveySectionCompetences() {
		return surveySectionCompetences;
	}
	public void setSurveySectionCompetences(List<CompetenceImpl> surveySectionCompetences) {
		this.surveySectionCompetences = surveySectionCompetences;
	}
	public Boolean getAdministratorCreated() {
		return administratorCreated;
	}
	public void setAdministratorCreated(Boolean administratorCreated) {
		this.administratorCreated = administratorCreated;
	}
}
