package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.BC.model.Corsista;

public class CorsistaDAO implements DAOConstants, GenericDAO<Corsista> {

	private CachedRowSet rowSet;

	public static CorsistaDAO getFactry() throws SQLException {
		return new CorsistaDAO();
	}

	private CorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Corsista entity, Connection conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Corsista entity, Connection conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Corsista entity, Connection conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Corsista findById(long id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Corsista[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

}
