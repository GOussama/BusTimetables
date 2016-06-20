package com.dao;

import java.io.Serializable;
import java.util.List;

public interface InterfaceDao<T, Id extends Serializable> {

	//Method to save a data object in the database
	public void persist(T entity);
	
	//Method to updtae a data object in the database
	public void update(T entity);
	
	//Method to select a data object from the database
	public T findById(Id id); 
	
	//Method to delete a data object from the database
	public void delete(T entity);
	
	//Method to select all the data objects from the database
	public List<T> findAll();
	
	//Method to delete all the data objects from the database
	public void deleteAll();
	
}
