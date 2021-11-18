package formationJpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_ordinateur", allocationSize = 1, initialValue = 100)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "ordinateur_id")),
		@AttributeOverride(name = "marque", column = @Column(name = "ordinateur_marque", length = 200)), })
public class Ordinateur extends Materiel {
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ordinateur_ram")
	private Ram ram;
	@Column(name = "ordinateur_disque", length = 10)
	@Enumerated(EnumType.STRING)
	private Disque disque;
	@OneToOne(mappedBy = "pc",fetch = FetchType.EAGER)
	private Stagiaire stagiaire;

	public Ordinateur() {

	}

	public Ram getRam() {
		return ram;
	}

	public void setRam(Ram ram) {
		this.ram = ram;
	}

	public Disque getDisque() {
		return disque;
	}

	public void setDisque(Disque disque) {
		this.disque = disque;
	}

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

}
