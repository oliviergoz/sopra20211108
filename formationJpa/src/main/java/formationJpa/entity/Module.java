package formationJpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "module")
@SequenceGenerator(name = "seqModule", sequenceName = "seq_module", allocationSize = 1, initialValue = 100)
public class Module {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqModule")
	@Column(name = "module_id")
	private Long id;
	@Column(name = "module_name")
	private String nom;
	@Column(name = "module_description")
	@Lob
	private String description;
	@Column(name = "module_duree")
	private int duree;
	@OneToMany(mappedBy = "id.module")
	private Set<ModuleFormation> modulesFormations;

	public Module() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Set<ModuleFormation> getModulesFormations() {
		return modulesFormations;
	}

	public void setModulesFormations(Set<ModuleFormation> modulesFormations) {
		this.modulesFormations = modulesFormations;
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
		Module other = (Module) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
