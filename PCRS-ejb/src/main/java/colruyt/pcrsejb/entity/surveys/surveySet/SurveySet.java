package colruyt.pcrsejb.entity.surveys.surveySet;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.surveys.survey.Survey;

@Entity
@Table(name="SURVEYSETS")
@NamedQueries({
	@NamedQuery(name= "SURVEYSET.GETALL", query = "SELECT ss FROM SurveySet ss")
})
public class SurveySet  extends AbstractEntity implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYSETS_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYSETS_SEQ", allocationSize = 1, name = "SURVEYSETS_SEQ")
	@Column(name="ID")
    private Integer id;
	@Column(name="YEAR")
    private LocalDate surveyYear;
    @OneToMany
    @JoinColumn(name="SURVEYSET_ID")
    private List<Survey> surveyList = new ArrayList<>();
    /*
     * CONSTRUCTORS
     */
    public SurveySet() {
    	super();
    }
    public SurveySet(LocalDate surveyYear, List<Survey> surveySet) {
        this.surveyYear = surveyYear;
        this.surveyList = surveySet;
    }
	public SurveySet(Integer id, LocalDate surveyYear, List<Survey> surveyList) {
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
	public List<Survey> getSurveyList() {
		return surveyList;
	}
	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;
	}
}
