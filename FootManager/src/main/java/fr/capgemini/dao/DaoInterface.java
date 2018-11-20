package fr.capgemini.dao;

import java.util.List;

public interface DaoInterface<T> {
	//creation de l'interface DAO en vue de le brancher au dao hibernate
	
	T createOrUpdate(T item);
	T find(Long id);
	List<T>findAll();
	void delete(Long id);

}