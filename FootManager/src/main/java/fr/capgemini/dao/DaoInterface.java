package fr.capgemini.dao;

import java.util.List;

import fr.capgemini.utils.MultiplePlayerFoundException;

public interface DaoInterface<T> {
	//creation de l'interface DAO en vue de le brancher au dao hibernate
	
	T createOrUpdate(T item);
	T find(Long id);
	T findByEmail (String email) throws MultiplePlayerFoundException;
	List<T>findAll();
	void delete(Long id);

}