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
		SurveySectionDefinitionImplBo other = (SurveySectionDefinitionImplBo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
