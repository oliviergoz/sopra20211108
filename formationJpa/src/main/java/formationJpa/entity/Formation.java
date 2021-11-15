package formationJpa.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "formation")
@SequenceGenerator(name = "seqFormation", sequenceName = "seq_formation", allocationSize = 1, initialValue = 100)
@NamedQueries({
		@NamedQuery(name = "Formation.findWithModules", query = "select f from Formation f left join fetch f.modules"),
		@NamedQuery(name = "Formation.findByIdWithModules", query = "select f from Formation f left join fetch f.modules where f.id=:id"),
		@NamedQuery(name = "Formation.findByReferent", query = "select f from Formation f where f.referent=:referent") })
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqFormation")
	@Column(name = "formation_id")
	private Long id;
	@Column(name = "formation_nom", length = 150, nullable = false)
	private String nom;
	@Column(name = "formation_date")
	private LocalDate date;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "formation_referent_id", foreignKey = @ForeignKey(name = "formation_referent_id"))
	private Formateur referent; // from Formation f where f.referent.prenom='olivier'
	@OneToMany(mappedBy = "id.formation", fetch = FetchType.LAZY)
	private Set<ModuleFormation> modules; // from Formation f join f.modules m join m.??? where m.nom='java'
//	@ManyToMany
//	@JoinTable(name = "module_formation", joinColumns = @JoinColumn(name = "module_formation_formation_id"), inverseJoinColumns = @JoinColumn(name = "module_formation_module_id"))
//	private Set<Module> modules;

//	@Temporal(TemporalType.DATE)
//	private Date oldDate;

	public Formation() {

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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Formateur getReferent() {
		return referent;
	}

	public void setReferent(Formateur referent) {
		this.referent = referent;
	}

//	public Set<Module> getModules() {
//		return modules;
//	}
//
//	public void setModules(Set<Module> modules) {
//		this.modules = modules;
//	}

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
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
