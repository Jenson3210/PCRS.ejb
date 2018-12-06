package colruyt.pcrsejb.bo.competence;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class CompetenceLevelBo extends AbstractBo implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer Id;
	private String description;
	private Integer orderLevel;
	/*
	 * CONSTRUCTORS
	 */
	public CompetenceLevelBo() {
		super();
	}
	public CompetenceLevelBo(String description, Integer orderLevel) {
		super();
		this.description = description;
		this.orderLevel = orderLevel;
	}
	public CompetenceLevelBo(Integer id, String description, Integer orderLevel) {
		super();
		Id = id;
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderLevel == null) ? 0 : orderLevel.hashCode());
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
		CompetenceLevelBo other = (CompetenceLevelBo) obj;
		if (orderLevel == null) {
			if (other.orderLevel != null)
				return false;
		} else if (!orderLevel.equals(other.orderLevel))
			return false;
		return true;
	}
	
}
