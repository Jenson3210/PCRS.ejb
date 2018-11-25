package colruyt.pcrsejb.bo.competence;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class CompetenceLevelBo extends AbstractBo implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private Boolean minLevel;
	private String description;
	private Integer orderLevel;
	/*
	 * CONSTRUCTORS
	 */
	public CompetenceLevelBo() {
		super();
	}
	public CompetenceLevelBo(Boolean minLevel, String description, Integer orderLevel) {
		super();
		this.minLevel = minLevel;
		this.description = description;
		this.orderLevel = orderLevel;
	}
	public CompetenceLevelBo(Integer id, Boolean minLevel, String description, Integer orderLevel) {
		super();
		Id = id;
		this.minLevel = minLevel;
		this.description = description;
		this.orderLevel = orderLevel;
	}
	/*
	 * GETTERS AND SETTERS
	 */
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public Boolean getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Boolean minLevel) {
		this.minLevel = minLevel;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOrderLevel() {
		return orderLevel;
	}
	public void setOrderLevel(Integer orderLevel) {
		this.orderLevel = orderLevel;
	} 
}
