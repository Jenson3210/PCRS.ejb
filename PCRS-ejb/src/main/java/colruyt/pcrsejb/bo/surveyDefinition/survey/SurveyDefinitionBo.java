package colruyt.pcrsejb.bo.surveyDefinition.survey;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.user.UserBo;

public class SurveyDefinitionBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserBo responsibleUser;
	private String name;
	private List<SurveySectionDefinitionBo> surveySections = new ArrayList<>();
	/*
	 * CONSTRUCTORS
	 */
	public SurveyDefinitionBo() {
		super();
	}
	public SurveyDefinitionBo(UserBo responsibleUser, String name, List<SurveySectionDefinitionBo> surveySections) {
		super();
		this.responsibleUser = responsibleUser;
		this.name = name;
		this.surveySections = surveySections;
	}
	public SurveyDefinitionBo(Integer id, UserBo responsibleUser, String name, List<SurveySectionDefinitionBo> surveySections) {
		super();
		this.id = id;
		this.responsibleUser = responsibleUser;
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
	public UserBo getResponsibleUser() {
		return responsibleUser;
	}
	public void setResponsibleUser(UserBo responsibleUser) {
		this.responsibleUser = responsibleUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SurveySectionDefinitionBo> getSurveySections() {
		return surveySections;
	}
	public void setSurveySections(List<SurveySectionDefinitionBo> surveySections) {
		this.surveySections = surveySections;
	}	
}
