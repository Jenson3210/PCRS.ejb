package colruyt.pcrsejb.entity.surveyDefinition.survey;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name="SURVEYSECTIONTITLES")
@NamedQuery(name = "SURVEYSECTIONTITLE.GETALL", query = "SELECT sst FROM SurveySectionTitle sst")
public class SurveySectionTitle extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYSECTIONTITLES_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYSECTIONTITLES_SEQ", allocationSize = 1, name = "SURVEYSECTIONTITLES_SEQ")
	@Column(name="ID")
	private Integer id;
	private String title;
	/*
	 * CONSTRUCTOR
	 */
	public SurveySectionTitle() {
		super();
	}
	public SurveySectionTitle(String title) {
		super();
		this.title = title;
	}
	public SurveySectionTitle(Integer id, String title) {
		super();
		this.id = id;
		this.title = title;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
