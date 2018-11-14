package fr.cantine.dao;

import java.util.List;

public interface DaoInterface<T> {

	T createOrUpdate(T item);
	T findById(Long Id);
	List<T> findAll();
	void delete(Long id);
	
}
