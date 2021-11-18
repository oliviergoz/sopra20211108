package formationJpa.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("formateur")
@Table(name = "formateur")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_formateur", initialValue = 100, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "formateur_id")),
		@AttributeOverride(name = "prenom", column = @Column(name = "formateur_prenom", length = 200)) })
public class Formateur extends Personne {
	@Column(name = "formateur_exp")
	private int experience;
	@OneToMany(mappedBy = "referent",fetch = FetchType.LAZY)
	private Set<Formation> formations; 

	public Formateur() {

	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Set<Formation> getFormations() {
		return formations;
	}

	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormateur")
//	@Override
//	public Long getId() {
//		return super.getId();
//	}

}
