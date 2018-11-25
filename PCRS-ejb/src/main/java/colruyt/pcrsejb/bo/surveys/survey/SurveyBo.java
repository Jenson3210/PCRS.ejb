package colruyt.pcrsejb.bo.surveys.survey;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.AbstractBo;

public class SurveyBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private LocalDate dateCompleted;
    private List<SurveySectionBo> surveySections = new ArrayList<>();
    private SurveyKindBo surveyKind;
	/*
	 * CONSTRUCTORS
	 */
	public SurveyBo() {
		super();
    }
    public SurveyBo(LocalDate dateCompleted, List<SurveySectionBo> surveySections,SurveyKindBo kind) {
        this.dateCompleted = dateCompleted;
        this.surveySections = surveySections;
        this.surveyKind = kind;
    }
	public SurveyBo(Integer id, LocalDate dateCompleted, List<SurveySectionBo> surveySections, SurveyKindBo surveyKind) {
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
	public List<SurveySectionBo> getSurveySections() {
		return surveySections;
	}
	public void setSurveySections(List<SurveySectionBo> surveySections) {
		this.surveySections = surveySections;
	}
	public SurveyKindBo getSurveyKind() {
		return surveyKind;
	}
	public void setSurveyKind(SurveyKindBo surveyKind) {
		this.surveyKind = surveyKind;
	}
}
