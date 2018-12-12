package colruyt.pcrsejb.entity.surveys.survey;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;


@Entity
@Table(name="SURVEYS")
public class Survey extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYS_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYS_SEQ", allocationSize = 1, name = "SURVEYS_SEQ")
	@Column(name="ID")
	private Integer id;
	@Column(name="DATECOMPLETED")
    private LocalDate dateCompleted;
	@OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="SURVEY_ID")
    private List<SurveySection> surveySections = new ArrayList<>();
	@Enumerated(EnumType.STRING)
    private SurveyKind surveyKind;
	/*
	 * CONSTRUCTORS
	 */
	public Survey() {
		super();
    }
    public Survey(LocalDate dateCompleted, List<SurveySection> surveySections,SurveyKind kind) {
        this.dateCompleted = dateCompleted;
        this.surveySections = surveySections;
        this.surveyKind = kind;
    }
	public Survey(Integer id, LocalDate dateCompleted, List<SurveySection> surveySections, SurveyKind surveyKind) {
		super();
		this.id = id;
		this.dateCompleted = dateCompleted;
		this.surveySections = surveySections;
		this.surveyKind = surveyKind;
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
	public LocalDate getDateCompleted() {
		return dateCompleted;
	}
	public void setDateCompleted(LocalDate dateCompleted) {
		this.dateCompleted = dateCompleted;
	}
	public List<SurveySection> getSurveySections() {
		return surveySections;
	}
	public void setSurveySections(List<SurveySection> surveySections) {
		this.surveySections = surveySections;
	}
	public SurveyKind getSurveyKind() {
		return surveyKind;
	}
	public void setSurveyKind(SurveyKind surveyKind) {
		this.surveyKind = surveyKind;
	}
}
