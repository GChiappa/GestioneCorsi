package it.betacom.architecture.dao.adapter;

import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.GenericDAO;
import it.betacom.businesscomponent.model.Commento;

public class CommentoDAOAdapter implements GenericDAO<Commento> {

	@Override
	public void create(Commento entity, Connection conn) throws SQLException {
	}

	@Override
	public void update(Commento entity, Connection conn) throws SQLException {
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
	}

	@Override
	public Commento findById(long id, Connection conn) throws SQLException {
		return null;
	}

	@Override
	public Commento[] getAll(Connection conn) throws SQLException {
		return null;
	}

}
