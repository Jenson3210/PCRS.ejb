package colruyt.pcrsejb.bo.competence;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;

public class CompetenceImplBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    private CompetenceBo competence;
    private String competenceDescription;
    private Integer minLevel;
	/*
	 * CONSTRUCTORS
	 */
    public CompetenceImplBo() {
    	super();
    }
    public CompetenceImplBo(CompetenceBo competence, String competenceDescription, Integer minLevel) {
		super();
		this.competence = competence;
		this.competenceDescription = competenceDescription;
		this.minLevel = minLevel;
	}
	public CompetenceImplBo(Integer id, CompetenceBo competence, String competenceDescription, Integer minLevel) {
		super();
		this.id = id;
		this.competence = competence;
		this.competenceDescription = competenceDescription;
		this.minLevel = minLevel;
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
	public CompetenceBo getCompetence() {
		return competence;
	}
	public void setCompetence(CompetenceBo competence) {
		this.competence = competence;
	}
	public String getCompetenceDescription() {
		return competenceDescription;
	}
	public void setCompetenceDescription(String competenceDescription) {
		this.competenceDescription = competenceDescription;
	}
	public Integer getMinLevel() {
		return minLevel;
	}
	public void setMinLevel(Integer minLevel) {
		this.minLevel = minLevel;
	}
	
	@Override
	public String toString() {
		return "CompetenceImplBo [id=" + id + "]";
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
		CompetenceImplBo other = (CompetenceImplBo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
