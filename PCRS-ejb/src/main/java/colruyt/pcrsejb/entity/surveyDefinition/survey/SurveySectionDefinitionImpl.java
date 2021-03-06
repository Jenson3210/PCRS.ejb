package colruyt.pcrsejb.entity.surveyDefinition.survey;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
@Entity
@Table(name="SURVEYSECTIONDEFIMPL")
@NamedQuery(name = "SURVEYSECTIONDEFINITIONIMPL.GETALL", query="SELECT impl FROM SurveySectionDefinitionImpl impl")
public class SurveySectionDefinitionImpl extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SURVEYSECTIONDEFIMPL_SEQ")
    @SequenceGenerator(sequenceName = "SURVEYSECTIONDEFIMPL_SEQ", allocationSize = 1, name = "SURVEYSECTIONDEFIMPL_SEQ")
	@Column(name="ID")
    private Integer id;
    @Enumerated(EnumType.STRING)
    private SurveySectionRequirementLevel surveySectionRequirementLevel;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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
