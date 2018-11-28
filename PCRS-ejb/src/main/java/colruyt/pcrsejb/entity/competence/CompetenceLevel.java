package colruyt.pcrsejb.entity.competence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name="COMPETENCELEVELS")
@NamedQuery(name= "COMPETENCELEVEL.GETALL", query = "SELECT cl FROM CompetenceLevel cl")
public class CompetenceLevel extends AbstractEntity implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPETENCELEVELS_SEQ")
    @SequenceGenerator(sequenceName = "COMPETENCELEVELS_SEQ", allocationSize = 1, name = "COMPETENCELEVELS_SEQ")
	@Column(name="ID")
	private Integer Id;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="ORDERLEVEL")
	private Integer orderLevel;
	/*
	 * CONSTRUCTORS
	 */
	public CompetenceLevel() {
		super();
	}
	public CompetenceLevel(String description, Integer orderLevel) {
		super();
		this.description = description;
		this.orderLevel = orderLevel;
	}
	public CompetenceLevel(Integer id, String description, Integer orderLevel) {
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
}
