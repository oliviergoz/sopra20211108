package formationJpa.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqMateriel", sequenceName = "seq_casque", allocationSize = 1, initialValue = 100)
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "casque_id")),
		@AttributeOverride(name = "marque", column = @Column(name = "casque_marque", length = 200)) })
public class Casque extends Materiel {
	@Column(name = "casque_filere")
	private boolean filere;

	public Casque() {

	}

	public boolean isFilere() {
		return filere;
	}

	public void setFilere(boolean filere) {
		this.filere = filere;
	}

}
