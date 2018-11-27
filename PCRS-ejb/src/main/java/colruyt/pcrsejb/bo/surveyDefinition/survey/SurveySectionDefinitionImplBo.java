package colruyt.pcrsejb.bo.surveyDefinition.survey;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class SurveySectionDefinitionImplBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    private SurveySectionRequirementLevelBo surveySectionRequirementLevelBo;
    private SurveySectionDefinitionBo surveySectionDefinitionBo;

	/*
	 * CONSTRUCTORS
	 */
    public SurveySectionDefinitionImplBo() {
    	super();
    }
    public SurveySectionDefinitionImplBo(SurveySectionRequirementLevelBo surveySectionRequirementLevelBo, SurveySectionDefinitionBo surveySectionDefinitionBo) {
		super();
		this.surveySectionRequirementLevelBo = surveySectionRequirementLevelBo;
		this.surveySectionDefinitionBo = surveySectionDefinitionBo;
	}
	public SurveySectionDefinitionImplBo(Integer id, SurveySectionRequirementLevelBo surveySectionRequirementLevelBo,SurveySectionDefinitionBo surveySectionDefinitionBo) {
		super();
		this.id = id;
		this.surveySectionRequirementLevelBo = surveySectionRequirementLevelBo;
		this.surveySectionDefinitionBo = surveySectionDefinitionBo;
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
	public SurveySectionRequirementLevelBo getSurveySectionRequirementLevelBo() {
		return surveySectionRequirementLevelBo;
	}
	public void setSurveySectionRequirementLevelBo(SurveySectionRequirementLevelBo surveySectionRequirementLevelBo) {
		this.surveySectionRequirementLevelBo = surveySectionRequirementLevelBo;
	}
	public SurveySectionDefinitionBo getSurveySectionDefinitionBo() {
		return surveySectionDefinitionBo;
	}
	public void setSurveySectionDefinitionBo(SurveySectionDefinitionBo surveySectionDefinitionBo) {
		this.surveySectionDefinitionBo = surveySectionDefinitionBo;
	}
}
