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
	private String name;
	private List<SurveySectionDefinitionImplBo> surveySections = new ArrayList<>();
	/*
	 * CONSTRUCTORS
	 */
	public SurveyDefinitionBo() {
		super();
	}
	public SurveyDefinitionBo(String name, List<SurveySectionDefinitionImplBo> surveySections) {
		super();
		this.name = name;
		this.surveySections = surveySections;
	}
	public SurveyDefinitionBo(Integer id, String name, List<SurveySectionDefinitionImplBo> surveySections) {
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
