package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAOAdapter implements GenericDAO<CorsoCorsista> {

	@Override
	public void create(CorsoCorsista entity, Connection conn) throws SQLException {
	}

	@Override
	public void update(CorsoCorsista entity, Connection conn) throws SQLException {
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
	}

	@Override
	public CorsoCorsista findById(long id, Connection conn) throws SQLException {
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) throws SQLException {
		return null;
	}

}
