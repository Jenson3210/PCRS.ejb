package colruyt.pcrsejb.bo.surveyDefinition.survey;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class SurveySectionTitleBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String title;
	/*
	 * CONSTRUCTOR
	 */
	public SurveySectionTitleBo() {
		super();
	}
	public SurveySectionTitleBo(String title) {
		super();
		this.title = title;
	}
	public SurveySectionTitleBo(Integer id, String title) {
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
	
	@Override
	public String toString() {
		return "SurveySectionTitleBo [id=" + id + ", title=" + title + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SurveySectionTitleBo other = (SurveySectionTitleBo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
	
}
