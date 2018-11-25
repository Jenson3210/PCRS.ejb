package colruyt.pcrsejb.bo.competence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import colruyt.pcrsejb.bo.AbstractBo;

public class CompetenceBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String competenceDescription;
    private Set<CompetenceLevelBo> competenceLevels = new HashSet<>();
	/*
	 * CONSTRUCTORS
	 */
    public CompetenceBo() {
    	super();
    }
    public CompetenceBo(String name, String competenceDescription, Set<CompetenceLevelBo> competenceLevels) {
		super();
		this.name = name;
		this.competenceDescription = competenceDescription;
		this.competenceLevels = competenceLevels;
	}
    public CompetenceBo(Integer id, String name, String competenceDescription, Set<CompetenceLevelBo> competenceLevels) {
		super();
		this.id = id;
		this.name = name;
		this.competenceDescription = competenceDescription;
		this.competenceLevels = competenceLevels;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompetenceDescription() {
		return competenceDescription;
	}
	public void setCompetenceDescription(String competenceDescription) {
		this.competenceDescription = competenceDescription;
	}
	public Set<CompetenceLevelBo> getCompetenceLevels() {
		return competenceLevels;
	}
	public void setCompetenceLevels(Set<CompetenceLevelBo> competenceLevels) {
		this.competenceLevels = competenceLevels;
	};
}
