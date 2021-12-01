package formation.sopra.formationSpringBoot.entities;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "users")
@SequenceGenerator(name = "seqUser", sequenceName = "seq_users", initialValue = 100, allocationSize = 1)
public class User {
	@Id
	@GeneratedValue(generator = "seqUser", strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "USERS_LOGIN", length = 255, unique = true, nullable = false)
	@JsonView(JsonViews.Common.class)
	private String login;
	@Column(name = "USERS_PASSWORD", length = 255, nullable = false)
	private String password;
	@Column(name = "USERS_ENABLE", nullable = false)
	private boolean enable;
	@CollectionTable(name = "USERS_ROLES")
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Role.class)
	private List<Role> roles;
	@OneToOne(mappedBy = "user")
	private Client client;

	public User() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
