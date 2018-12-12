package colruyt.pcrsejb.entity.surveys.survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.surveyDefinition.survey.SurveySectionDefinitionImpl;
import colruyt.pcrsejb.entity.surveys.rating.Rating;


@Entity
@Table(name="SURVEYSECTIONS")
public class SurveySection extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYSECTIONS_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYSECTIONS_SEQ", allocationSize = 1, name = "SURVEYSECTIONS_SEQ")
	@Column(name="ID")
	private Integer id;
	@ManyToOne
	private SurveySectionDefinitionImpl surveySectionDefinition;
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="SURVEYSECTIONS_ID")
	private List<Rating> ratings = new ArrayList<>();

	
	public SurveySection() {
		super();
	}
	public SurveySection(SurveySectionDefinitionImpl surveySectionDefinition, List<Rating> ratings) {
		super();
		this.surveySectionDefinition = surveySectionDefinition;
		this.ratings = ratings;
	}
	public SurveySection(Integer id, SurveySectionDefinitionImpl surveySectionDefinition, List<Rating> ratings) {
		super();
		this.id = id;
		this.surveySectionDefinition = surveySectionDefinition;
		this.ratings = ratings;
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
	public SurveySectionDefinitionImpl getSurveySectionDefinition() {
		return surveySectionDefinition;
	}
	public void setSurveySectionDefinition(SurveySectionDefinitionImpl surveySectionDefinition) {
		this.surveySectionDefinition = surveySectionDefinition;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
}
