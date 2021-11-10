package formationJpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("formateur")
@Table(name = "formateur")
@SequenceGenerator(name = "seqFormateur", sequenceName = "seq_formateur", initialValue = 100, allocationSize = 1)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "formateur_id")),
		@AttributeOverride(name = "prenom", column = @Column(name = "formateur_prenom", length = 200)) })
public class Formateur extends Personne {
	@Column(name = "formateur_exp")
	private int experience;

	public Formateur() {

	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormateur")
	@Override
	public Long getId() {
		return super.getId();
	}

}
