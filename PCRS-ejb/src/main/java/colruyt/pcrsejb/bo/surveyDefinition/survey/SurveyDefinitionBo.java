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
}
