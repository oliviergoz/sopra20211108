package exoJpa.dao;

import java.util.List;

import exoJpa.entity.Client;

public interface DaoClient extends DaoGeneric<Client, Long> {
	Client findByKeyWithCommandes(Long key);

	List<Client> findAllWithCommandes();
}
