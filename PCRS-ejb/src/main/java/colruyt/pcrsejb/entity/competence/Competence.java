package colruyt.pcrsejb.entity.competence;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import colruyt.pcrsejb.entity.AbstractEntity;

@Entity
@Table(name="COMPETENCES")
@SecondaryTable(name="COMPETENCEDESCRIPTIONS")
@NamedQueries({
	@NamedQuery(name="COMPETENCE.GETALL", query="SELECT c FROM Competence c"),
	@NamedQuery(name="COMPETENCE.GETALLBYSECTION", query="SELECT c FROM Competence c WHERE size(c.competenceLevels) = :size")
})

public class Competence extends AbstractEntity implements Serializable {
	/*
	 * PROPERTIES
	 */
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMPETENCES_SEQ")
    @SequenceGenerator(sequenceName = "COMPETENCES_SEQ", allocationSize = 1, name = "COMPETENCES_SEQ")
    @Column(name="ID")
    private Integer id;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION",table="COMPETENCEDESCRIPTIONS", length = 1337)
    private String competenceDescription;
    @OneToMany(cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="COMPETENCES_ID")
    private Set<CompetenceLevel> competenceLevels = new HashSet<>();
	/*
	 * CONSTRUCTORS
	 */
    public Competence() {
    	super();
    }
    public Competence(String name, String competenceDescription, Set<CompetenceLevel> competenceLevels) {
		super();
		this.name = name;
		this.competenceDescription = competenceDescription;
		this.competenceLevels = competenceLevels;
	}
    public Competence(Integer id, String name, String competenceDescription, Set<CompetenceLevel> competenceLevels) {
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
	public Set<CompetenceLevel> getCompetenceLevels() {
		return competenceLevels;
	}
	public void setCompetenceLevels(Set<CompetenceLevel> competenceLevels) {
		this.competenceLevels = competenceLevels;
	};
}
