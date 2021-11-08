package formationJdbc.model;

import java.time.LocalDate;

public class Formation {
	private Integer id;
	private String nom;
	private LocalDate date;
	private Formateur referent;

	public Formation() {

	}

	public Formation(Integer id, String nom, LocalDate date) {
		this.id = id;
		this.nom = nom;
		this.date = date;
	}

	public Formation(String nom, LocalDate date) {
		this.nom = nom;
		this.date = date;
	}

	public Formation(Integer id, String nom, LocalDate date, Formateur referent) {
		this.id = id;
		this.nom = nom;
		this.date = date;
		this.referent = referent;
	}

	public Formation(String nom, LocalDate date, Formateur referent) {
		this.nom = nom;
		this.date = date;
		this.referent = referent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
