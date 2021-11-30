package formation.sopra.formationSpringBoot.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "client")
@NamedQueries({
		@NamedQuery(name = "Client.findAllWithCommandes", query = "select c from Client c left join fetch c.commandes") })
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", allocationSize = 1, initialValue = 100)
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_id")
	@JsonView(JsonViews.Common.class)
	private Long id;
	@Column(name = "client_prenom", nullable = false, length = 200)
	@NotBlank
	@NotEmpty
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@NotBlank
	@NotEmpty
	@Column(name = "client_nom", nullable = false, length = 200)
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "client_civilite", length = 5)
	@JsonView(JsonViews.Common.class)
	private Civilite civilite;
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;
	@Version
	@Column(name = "client_version")
	private int version;
	@OneToOne
	@JoinColumn(name = "client_user_id")
	private User user;

	public String getInfos() {
		return id + " " + prenom + " " + nom;
	}

	public Client() {

	}

	public Client(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
