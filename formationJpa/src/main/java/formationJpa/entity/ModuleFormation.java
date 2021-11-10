package formationJpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "module_formation")
public class ModuleFormation {

	@EmbeddedId
	private ModuleFormationKey id;
	@Column(name="module_formation_date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name="module_formation_formateur_id",foreignKey = @ForeignKey(name="module_formation_formateur_id_fk"))
	private Formateur formateur;

	public ModuleFormation() {

	}

	public ModuleFormationKey getId() {
		return id;
	}

	public void setId(ModuleFormationKey id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModuleFormation other = (ModuleFormation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
