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
	public boolean equals(Object o) {
		boolean equal = false;
		if (this.getClass().equals(o.getClass())) {
			equal = (this.getId() == ((CompetenceLevelBo) o).getId());
		}
		return equal;
	}
	
	@Override
	public int hashCode() {
		return orderLevel;
	}
}
