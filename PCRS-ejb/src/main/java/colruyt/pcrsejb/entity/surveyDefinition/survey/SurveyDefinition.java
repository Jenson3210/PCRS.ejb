package colruyt.pcrsejb.entity.surveyDefinition.survey;

import java.io.Serializable;
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

@Entity
@Table(name="SURVEYDEFINITIONS")
@NamedQueries
(
	{
			@NamedQuery(name = "SURVEYDEFINITION.GETALL", query = "SELECT sd FROM SurveyDefinition sd"),
	}
	
)
public class SurveyDefinition extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYDEFINITIONS_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYDEFINITIONS_SEQ", allocationSize = 1, name = "SURVEYDEFINITIONS_SEQ")
	@Column(name="ID")
	private Integer id;
	private String name;
	@OneToMany
	@JoinColumn(name="SURVEYDEFINITIONS_ID")
	private List<SurveySectionDefinition> surveySections = new ArrayList<>();
	/*
	 * CONSTRUCTORS
	 */
	public SurveyDefinition() {
		super();
	}
	public SurveyDefinition(String name, List<SurveySectionDefinition> surveySections) {
		super();
		this.name = name;
		this.surveySections = surveySections;
	}
	public SurveyDefinition(Integer id, String name, List<SurveySectionDefinition> surveySections) {
		super();
		this.id = id;
		this.name = name;
		this.surveySections = surveySections;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SurveySectionDefinition> getSurveySections() {
		return surveySections;
	}
	public void setSurveySections(List<SurveySectionDefinition> surveySections) {
		this.surveySections = surveySections;
	}	
}
