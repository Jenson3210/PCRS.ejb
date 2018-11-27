package colruyt.pcrsejb.entity.surveyDefinition.survey;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import colruyt.pcrsejb.entity.AbstractEntity;

public class SurveySectionDefinitionImpl extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    @Enumerated(EnumType.STRING)
    private SurveySectionRequirementLevel surveySectionRequirementLevel;
    private SurveySectionDefinition surveySectionDefinition;

	/*
	 * CONSTRUCTORS
	 */
    public SurveySectionDefinitionImpl() {
    	super();
    }
    public SurveySectionDefinitionImpl(SurveySectionRequirementLevel surveySectionRequirementLevel, SurveySectionDefinition surveySectionDefinition) {
		super();
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
		this.surveySectionDefinition = surveySectionDefinition;
	}
	public SurveySectionDefinitionImpl(Integer id, SurveySectionRequirementLevel surveySectionRequirementLevel,SurveySectionDefinition surveySectionDefinition) {
		super();
		this.id = id;
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
		this.surveySectionDefinition = surveySectionDefinition;
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
	public SurveySectionRequirementLevel getSurveySectionRequirementLevel() {
		return surveySectionRequirementLevel;
	}
	public void setSurveySectionRequirementLevel(SurveySectionRequirementLevel surveySectionRequirementLevel) {
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
	}
	public SurveySectionDefinition getSurveySectionDefinition() {
		return surveySectionDefinition;
	}
	public void setSurveySectionDefinition(SurveySectionDefinition surveySectionDefinition) {
		this.surveySectionDefinition = surveySectionDefinition;
	}
}
