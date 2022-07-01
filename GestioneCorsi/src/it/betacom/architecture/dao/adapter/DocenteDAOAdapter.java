package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.businesscomponent.model.Docente;

public class DocenteDAOAdapter implements GenericDAO<Docente> {

	@Override
	public void create(Docente entity, Connection conn) throws SQLException {
	}

	@Override
	public void update(Docente entity, Connection conn) throws SQLException {
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
	}

	@Override
	public Docente findById(long id, Connection conn) throws SQLException {
		return null;
	}

	@Override
	public Docente[] getAll(Connection conn) throws SQLException {
		return null;
	}

}
