package formation.sopra.formationSpringBoot.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", allocationSize = 1, initialValue = 100)
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	@Column(name = "produit_id")
	@JsonView(JsonViews.Common.class)
	private Long id;
	@Column(name = "produit_nom", nullable = false, length = 200)
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Lob
	@Column(name = "produit_description")
	@JsonView(JsonViews.Common.class)
	private String description;
	@Lob
	@Column(name = "produit_photo")
	@Type(type = "org.hibernate.type.BinaryType")
	@JsonView(JsonViews.Common.class)
	private byte[] photo;
	@Column(name = "produit_prix")
	@DecimalMin(value = "0.1", message = "il faut un prix superieur à 0")
	@JsonView(JsonViews.Common.class)
	private double prix;
	// @JsonIgnore
	@OneToMany(mappedBy = "id.produit")
	@JsonView({JsonViews.ProduitAvecLigneCommande.class})
	private Set<LigneCommande> lignesCommandes;

	public Produit() {

	}

	public Produit(String nom, String description) {
		this.nom = nom;
		this.description = description;
	}

	public Produit(String nom, String description, byte[] photo) {
		this.nom = nom;
		this.description = description;
		this.photo = photo;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Set<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(Set<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
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
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
