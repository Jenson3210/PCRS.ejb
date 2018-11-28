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
	public boolean equals(Object o) {
		return this.getId().equals(((SurveySectionTitleBo) o).getId());
	}
	
	@Override
	public int hashCode() {
		return getId();
	}

	
}
