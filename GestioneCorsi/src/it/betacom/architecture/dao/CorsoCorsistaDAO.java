package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO implements GenericDAO<CorsoCorsista>,DAOConstants {
	
	public static CorsoCorsistaDAO getFactory() throws SQLException {
		return new CorsoCorsistaDAO();
	}

	private CachedRowSet rowSet;
	
	
	private CorsoCorsistaDAO() throws SQLException {
		 try {
			 rowSet = RowSetProvider.newFactory().createCachedRowSet();
		 }
		 catch(SQLException sql) {
			 throw new SQLException(sql);
		 }
	}

	@Override
	public void create(CorsoCorsista entity, Connection conn) throws SQLException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1,entity.getCodCorsoCorsista());
			rowSet.updateLong(2,entity.getCodCorso());
			rowSet.updateLong(3,entity.getCodCorsista());
			
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
		
		} catch (SQLException e) {
		 
			throw new  SQLException(e);
		}
		
	}

	@Override
	public void update(CorsoCorsista entity, Connection conn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSISTA);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
		} catch(SQLException sql) {
			throw new SQLException(sql);
		}
	}

	@Override
	public CorsoCorsista findById(long id, Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CorsoCorsista[] getAll(Connection conn) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
