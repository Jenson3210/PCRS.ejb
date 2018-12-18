package colruyt.pcrsejb.entity.surveys.surveySet;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
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
import colruyt.pcrsejb.util.general.LocalDateTimeAttributeConverter;

@Entity
@Table(name="SURVEYSETS")
@NamedQueries({
	@NamedQuery(name= "SURVEYSET.GETALL", query = "SELECT ss FROM SurveySet ss")
})
public class SurveySet  extends AbstractEntity implements Serializable,Comparable<SurveySet>{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYSETS_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYSETS_SEQ", allocationSize = 1, name = "SURVEYSETS_SEQ")
	@Column(name="ID")
    private Integer id;
	@Column(name="YEAR")
	
	@Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime surveyYear;
    @OneToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name="SURVEYSET_ID")

    private List<Survey> surveyList = new ArrayList<>();
    /*
     * CONSTRUCTORS
     */
    public SurveySet() {
    	super();
    }
    public SurveySet(LocalDateTime surveyYear, List<Survey> surveySet) {
        this.surveyYear = surveyYear;
        this.surveyList = surveySet;
    }
	public SurveySet(Integer id, LocalDateTime surveyYear, List<Survey> surveyList) {
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
	public LocalDateTime getSurveyYear() {
		return surveyYear;
	}
	public void setSurveyYear(LocalDateTime surveyYear) {
		this.surveyYear = surveyYear;
	}
	public List<Survey> getSurveyList() {
		return surveyList;
	}
	public void setSurveyList(List<Survey> surveyList) {
		this.surveyList = surveyList;

	}
	@Override
	public int compareTo(SurveySet arg0) {
		if(arg0 != null) {
		return this.surveyYear.compareTo(arg0.surveyYear);
		}
		else {
		return 0;
		}
	}
	
	
}
