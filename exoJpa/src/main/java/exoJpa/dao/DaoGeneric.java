package exoJpa.dao;

import java.util.List;

import exoJpa.entity.Client;

public interface DaoGeneric<T, K> {
	List<T> findAll();

	T findByKey(K key);

	void insert(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteByKey(K key);
}
