package colruyt.pcrsejb.bo.surveys.rating;

import java.io.Serializable;

import colruyt.pcrsejb.bo.AbstractBo;
import colruyt.pcrsejb.bo.competence.CompetenceImplBo;

public class RatingBo extends AbstractBo implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
    private Integer level;
    private Boolean energy;
    private CompetenceImplBo competence;
    /*
     * CONSTRUCTORS
     */
    public RatingBo(){
    	super();
    }
    public RatingBo(Integer level, Boolean energy, CompetenceImplBo competence){
        setLevel(level);
        setEnergy(energy);
        setCompetence(competence);
    }   
	public RatingBo(Integer id, Integer level, Boolean energy, CompetenceImplBo competence) {
		super();
		this.id = id;
		this.level = level;
		this.energy = energy;
		this.competence = competence;
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Boolean getEnergy() {
		return energy;
	}
	public void setEnergy(Boolean energy) {
		this.energy = energy;
	}
	public CompetenceImplBo getCompetence() {
		return competence;
	}
	public void setCompetence(CompetenceImplBo competence) {
		this.competence = competence;
	}
}
