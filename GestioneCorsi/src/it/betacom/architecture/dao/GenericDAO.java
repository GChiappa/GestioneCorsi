package it.betacom.architecture.dao;

public interface GenericDAO<T> {

	public void create(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public T findById(long id);
	
	public T[] getAll();

}
