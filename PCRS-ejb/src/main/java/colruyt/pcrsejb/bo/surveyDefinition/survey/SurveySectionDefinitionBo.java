package colruyt.pcrsejb.bo.surveyDefinition.survey;

import java.io.Serializable;
import java.util.List;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.surveyDefinition.strategy.SurveySectionStrategyBo;

public class SurveySectionDefinitionBo extends AbstractBo implements Serializable {
	/* 
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Boolean administratorCreated;
	private SurveySectionRequirementLevelBo surveySectionRequirementLevel;
	private SurveySectionTitleBo surveySectionTitle;
	private SurveySectionStrategyBo surveySectionStrategy;
	private List<CompetenceBo> surveySectionCompetences;
	/*
	 * CONSTRUCTORS
	 */
	public SurveySectionDefinitionBo() {
		super();
	}
	public SurveySectionDefinitionBo(SurveySectionTitleBo surveySectionTitle, SurveySectionStrategyBo surveySectionStrategy, List<CompetenceBo> surveySectionCompetences, Boolean administratorCreated, SurveySectionRequirementLevelBo surveySectionRequirementLevel) {
		super();
		this.surveySectionTitle = surveySectionTitle;
		this.surveySectionStrategy = surveySectionStrategy;
		this.surveySectionCompetences = surveySectionCompetences;
		this.administratorCreated = administratorCreated;
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
	}
	public SurveySectionDefinitionBo(Integer id,SurveySectionTitleBo surveySectionTitle, SurveySectionStrategyBo surveySectionStrategy, List<CompetenceBo> surveySectionCompetences, Boolean administratorCreated, SurveySectionRequirementLevelBo surveySectionRequirementLevel) {
		super();
		this.id = id;
		this.surveySectionTitle = surveySectionTitle;
		this.surveySectionStrategy = surveySectionStrategy;
		this.surveySectionCompetences = surveySectionCompetences;
		this.administratorCreated = administratorCreated;
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
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
	public SurveySectionTitleBo getSurveySectionTitle() {
		return surveySectionTitle;
	}
	public void setSurveySectionTitle(SurveySectionTitleBo surveySectionTitle) {
		this.surveySectionTitle = surveySectionTitle;
	}
	public SurveySectionStrategyBo getSurveySectionStrategy() {
		return surveySectionStrategy;
	}
	public void setSurveySectionStrategy(SurveySectionStrategyBo surveySectionStrategy) {
		this.surveySectionStrategy = surveySectionStrategy;
	}
	public List<CompetenceBo> getSurveySectionCompetences() {
		return surveySectionCompetences;
	}
	public void setSurveySectionCompetences(List<CompetenceBo> surveySectionCompetences) {
		this.surveySectionCompetences = surveySectionCompetences;
	}
	public Boolean getAdministratorCreated() {
		return administratorCreated;
	}
	public void setAdministratorCreated(Boolean administratorCreated) {
		this.administratorCreated = administratorCreated;
	}
	public SurveySectionRequirementLevelBo getSurveySectionRequirementLevel() {
		return surveySectionRequirementLevel;
	}
	public void setSurveySectionRequirementLevel(SurveySectionRequirementLevelBo surveySectionRequirementLevel) {
		this.surveySectionRequirementLevel = surveySectionRequirementLevel;
	}
}
