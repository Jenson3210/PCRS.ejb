package colruyt.pcrsejb.bo.surveys.rating;

import java.io.Serializable;

import colruyt.pcrsejb.bo.competence.CompetenceImplBo;
public class ConsensusRatingBo extends RatingBo implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    private String comment;
    
	/*
	 * CONSTRUCTORS
	 */
    public ConsensusRatingBo(){
    	super();
    }
	public ConsensusRatingBo(Integer level, Boolean energy, CompetenceImplBo competence,
			String comment) {
		super(level, energy, competence);
		this.comment = comment;
	}
	public ConsensusRatingBo(Integer id, Integer level, Boolean energy, CompetenceImplBo competence, String comment) {
		super(id, level, energy, competence);
		this.comment = comment;
	}
	/*
	 * GETTERS AND SETTERS
	 */
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
