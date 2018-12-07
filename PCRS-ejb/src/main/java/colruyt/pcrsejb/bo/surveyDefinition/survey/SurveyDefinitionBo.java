package colruyt.pcrsejb.bo.surveyDefinition.survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.AbstractBo;

public class SurveyDefinitionBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String function;
	private String operatingUnit;
	private String country;
	private List<SurveySectionDefinitionImplBo> surveySections = new ArrayList<>();
	/*
	 * CONSTRUCTORS
	 */
	public SurveyDefinitionBo() {
		super();
	}
	public SurveyDefinitionBo(String function, String operatingUnit, String country, List<SurveySectionDefinitionImplBo> surveySections) {
		super();
		this.function = function;
		this.operatingUnit = operatingUnit;
		this.country = country;
		this.surveySections = surveySections;
	}
	public SurveyDefinitionBo(Integer id, String function, String operatingUnit, String country, List<SurveySectionDefinitionImplBo> surveySections) {
		super();
		this.id = id;
		this.function = function;
		this.operatingUnit = operatingUnit;
		this.country = country;
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
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getOperatingUnit() {
		return operatingUnit;
	}
	public void setOperatingUnit(String operatingUnit) {
		this.operatingUnit = operatingUnit;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public List<SurveySectionDefinitionImplBo> getSurveySections() {
		return surveySections;
	}
	public void setSurveySections(List<SurveySectionDefinitionImplBo> surveySections) {
		this.surveySections = surveySections;
	}	
	
	public void addSurveySection(SurveySectionDefinitionImplBo bo) {
		this.surveySections.add(bo);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		SurveyDefinitionBo other = (SurveyDefinitionBo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
