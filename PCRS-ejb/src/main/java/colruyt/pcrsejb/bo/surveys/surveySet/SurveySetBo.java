package colruyt.pcrsejb.bo.surveys.surveySet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.surveys.survey.SurveyBo;

public class SurveySetBo extends AbstractBo implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    private LocalDate surveyYear;
    private List<SurveyBo> surveyList = new ArrayList<>();
    /*
     * CONSTRUCTORS
     */
    public SurveySetBo() {
    	super();
    }
    public SurveySetBo(LocalDate surveyYear, List<SurveyBo> surveySet) {
        this.surveyYear = surveyYear;
        this.surveyList = surveySet;
    }
	public SurveySetBo(Integer id, LocalDate surveyYear, List<SurveyBo> surveyList) {
		super();
		this.id = id;
		this.surveyYear = surveyYear;
		this.surveyList = surveyList;
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
	public LocalDate getSurveyYear() {
		return surveyYear;
	}
	public void setSurveyYear(LocalDate surveyYear) {
		this.surveyYear = surveyYear;
	}
	public List<SurveyBo> getSurveyList() {
		return surveyList;
	}
	public void setSurveyList(List<SurveyBo> surveyList) {
		this.surveyList = surveyList;
	}
}
