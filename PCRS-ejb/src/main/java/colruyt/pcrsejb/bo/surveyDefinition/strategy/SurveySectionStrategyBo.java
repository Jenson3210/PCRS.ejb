package colruyt.pcrsejb.bo.surveyDefinition.strategy;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class SurveySectionStrategyBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer amountOfLevels;
	private Boolean energyRated;
	private Boolean interestRated;
	private String name;
	private Boolean descriptionRequired;
	private Boolean hasMinimumLevel;
	private Boolean flexibleDescription;
	// NICE TO HAVE BEYOND THIS POINT
	// private Boolean commentInConsensus;
	// private Boolean textRated;
	/*
	 * CONSTRUCTORS
	 */
	public SurveySectionStrategyBo() {
		super();
	}

	public SurveySectionStrategyBo(Integer amountOfLevels, Boolean energyRated, Boolean interestRated, String name,
			Boolean descriptionRequired, Boolean hasMinimumLevel, Boolean flexibleDescription) {
		super();
		this.amountOfLevels = amountOfLevels;
		this.energyRated = energyRated;
		this.interestRated = interestRated;
		this.name = name;
		this.descriptionRequired = descriptionRequired;
		this.hasMinimumLevel = hasMinimumLevel;
		this.flexibleDescription = flexibleDescription;
	}

	public SurveySectionStrategyBo(Integer id, Integer amountOfLevels, Boolean energyRated, Boolean interestRated,
			String name, Boolean descriptionRequired, Boolean hasMinimumLevel, Boolean flexibleDescription) {
		super();
		this.id = id;
		this.amountOfLevels = amountOfLevels;
		this.energyRated = energyRated;
		this.interestRated = interestRated;
		this.name = name;
		this.descriptionRequired = descriptionRequired;
		this.hasMinimumLevel = hasMinimumLevel;
		this.flexibleDescription = flexibleDescription;
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

	public Integer getAmountOfLevels() {
		return amountOfLevels;
	}

	public void setAmountOfLevels(Integer amountOfLevels) {
		this.amountOfLevels = amountOfLevels;
	}

	public Boolean getEnergyRated() {
		return energyRated;
	}

	public void setEnergyRated(Boolean energyRated) {
		this.energyRated = energyRated;
	}

	public Boolean getInterestRated() {
		return interestRated;
	}

	public void setInterestRated(Boolean interestRated) {
		this.interestRated = interestRated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getDescriptionRequired() {
		return descriptionRequired;
	}

	public void setDescriptionRequired(Boolean descriptionRequired) {
		this.descriptionRequired = descriptionRequired;
	}

	public Boolean getHasMinimumLevel() {
		return hasMinimumLevel;
	}

	public void setHasMinimumLevel(Boolean hasMinimumLevel) {
		this.hasMinimumLevel = hasMinimumLevel;
	}

	public Boolean getFlexibleDescription() {
		return flexibleDescription;
	}

	public void setFlexibleDescription(Boolean flexibleDescription) {
		this.flexibleDescription = flexibleDescription;
	}
}
