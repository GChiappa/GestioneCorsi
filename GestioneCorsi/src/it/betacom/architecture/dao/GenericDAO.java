package it.betacom.architecture.dao;

import java.sql.Connection;

public interface GenericDAO<T> {

	public void create(T entity, Connection conn);
	
	public void update(T entity, Connection conn);
	
	public void delete(T entity, Connection conn);
	
	public T findById(long id, Connection conn);
	
	public T[] getAll(Connection conn);

}
