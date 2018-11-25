package colruyt.pcrsejb.entity.surveys.rating;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import colruyt.pcrsejb.entity.competence.Competence;

@Entity
@DiscriminatorValue(value="CONSENSUS") 
public class ConsensusRating extends Rating implements Serializable{
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Column(name="RATING_COMMENT")
    private String comment;
    
	/*
	 * CONSTRUCTORS
	 */
    public ConsensusRating(){
    	super();
    }
	public ConsensusRating(Integer level, boolean energy, Competence competence,
			String comment) {
		super(level, energy, competence);
		this.comment = comment;
	}
	public ConsensusRating(Integer id, Integer level, Boolean energy, Competence competence, String comment) {
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
