package formationJpa.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
//@DiscriminatorValue("stagiaire")
@Table(name = "stagiaire")
@SequenceGenerator(name = "seqPersonne", sequenceName = "seq_stagiaire", initialValue = 200, allocationSize = 1)
public class Stagiaire extends Personne {
	@Column(name = "stagiaire_entreprise", length = 200)
	private String entreprise;
	@OneToOne
	@JoinColumn(name="stagiaire_ordinateur_id",foreignKey = @ForeignKey(name="stagiaire_ordinateur_id_fk"))
	private Ordinateur pc;

	public Stagiaire() {

	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public Ordinateur getPc() {
		return pc;
	}

	public void setPc(Ordinateur pc) {
		this.pc = pc;
	}

}
