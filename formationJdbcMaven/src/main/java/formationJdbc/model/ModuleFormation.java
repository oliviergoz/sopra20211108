package formationJdbc.model;

import java.time.LocalDate;

public class ModuleFormation {
	private ModuleFormationKey key;
	private LocalDate date;
	private Formateur formateur;

	public ModuleFormation() {

	}

	public ModuleFormation(ModuleFormationKey key, LocalDate date, Formateur formateur) {
		this.key = key;
		this.date = date;
		this.formateur = formateur;
	}

	public ModuleFormationKey getKey() {
		return key;
	}

	public void setKey(ModuleFormationKey key) {
		this.key = key;
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
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
