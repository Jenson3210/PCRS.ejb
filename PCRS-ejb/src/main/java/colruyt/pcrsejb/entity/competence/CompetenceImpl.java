package colruyt.pcrsejb.entity.competence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name="COMPETENCEIMPLEMENTATIONS")
@SecondaryTable(name="COMPETENCEDESCRIPTIONS")
public class CompetenceImpl extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPETENCEIMPLEMENTATIONS_SEQ")
    @SequenceGenerator(sequenceName = "COMPETENCEIMPLEMENTATIONS_SEQ", allocationSize = 1, name = "COMPETENCEIMPLEMENTATIONS_SEQ")
    @Column(name="ID")
    private Integer id;
    @ManyToOne
    private Competence competence;
    @Column(name="DESCRIPTION",table="COMPETENCEDESCRIPTIONS")
    private String competenceDescription;
    @Column(name="MINLEVEL")
    private Integer minLevel;
	/*
	 * CONSTRUCTORS
	 */
    public CompetenceImpl() {
    	super();
    }
    public CompetenceImpl(Competence competence, String competenceDescription, Integer minLevel) {
		super();
		this.competence = competence;
		this.competenceDescription = competenceDescription;
		this.minLevel = minLevel;
	}
	public CompetenceImpl(Integer id, Competence competence, String competenceDescription, Integer minLevel) {
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
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
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
}
