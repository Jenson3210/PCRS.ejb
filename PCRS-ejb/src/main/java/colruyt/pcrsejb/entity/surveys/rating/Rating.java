package colruyt.pcrsejb.entity.surveys.rating;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;
import colruyt.pcrsejb.entity.competence.CompetenceImpl;

@Entity
@Table(name="RATINGS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="RATINGTYPE")
@DiscriminatorValue(value="REGULAR")
public class Rating extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RATINGSS_SEQ")
    @SequenceGenerator(sequenceName = "RATINGSS_SEQ", allocationSize = 1, name = "RATINGSS_SEQ")
	@Column(name="ID")
	private Integer id;
	@Column(name="RATING_LEVEL")
    private Integer level;
	@Enumerated(EnumType.STRING) 
    private EnergyOrInterestOption energy;
	@Enumerated(EnumType.STRING) 
    private EnergyOrInterestOption interest;
    @ManyToOne
    private CompetenceImpl competence;
    /*
     * CONSTRUCTORS
     */
    public Rating(){
    	super();
    }
    public Rating(Integer level, EnergyOrInterestOption energy, EnergyOrInterestOption interest, CompetenceImpl competence){
        setLevel(level);
        setEnergy(energy);
        setInterest(interest);
        setCompetence(competence);
    }   
	public Rating(Integer id, Integer level, EnergyOrInterestOption energy, EnergyOrInterestOption interest, CompetenceImpl competence) {
		super();
		this.id = id;
		this.level = level;
		this.energy = energy;
		this.competence = competence;
		this.interest = interest;
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
	public EnergyOrInterestOption getEnergy() {
		return energy;
	}
	public void setEnergy(EnergyOrInterestOption energy) {
		this.energy = energy;
	}
	public CompetenceImpl getCompetence() {
		return competence;
	}
	public void setCompetence(CompetenceImpl competence) {
		this.competence = competence;
	}
	public EnergyOrInterestOption getInterest() {
		return interest;
	}
	public void setInterest(EnergyOrInterestOption interest) {
		this.interest = interest;
	}
}
