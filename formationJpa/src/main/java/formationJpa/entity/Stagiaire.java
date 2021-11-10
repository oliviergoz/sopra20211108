package formationJpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("stagiaire")
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_stagiaire", initialValue = 200, allocationSize = 1)
public class Stagiaire extends Personne {
	@Column(name = "stagiaire_entreprise", length = 200)
	private String entreprise;

	public Stagiaire() {

	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

}
