package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface GenericDAO<T> {

	public void create(T entity, Connection conn) throws SQLException;

	public void update(T entity, Connection conn) throws SQLException;

	public void delete(T entity, Connection conn) throws SQLException;

	public T findById(long id, Connection conn) throws SQLException;

	public T[] getAll(Connection conn) throws SQLException;

}
