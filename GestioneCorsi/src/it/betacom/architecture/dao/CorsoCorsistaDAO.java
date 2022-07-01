package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.architecture.dao.adapter.CorsoCorsistaDAOAdapter;
import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaDAO extends CorsoCorsistaDAOAdapter implements DAOConstants {

	private CachedRowSet rowSet;

	public static CorsoCorsistaDAO getFactory() throws SQLException {
		return new CorsoCorsistaDAO();
	}

	private CorsoCorsistaDAO() throws SQLException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}
	}

	@Override
	public void create(CorsoCorsista entity, Connection conn) throws SQLException {
		try {
			rowSet.setCommand(SELECT_CORSO_CORSISTA);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, entity.getCodCorsoCorsista());
			rowSet.updateLong(2, entity.getCodCorso());
			rowSet.updateLong(3, entity.getCodCorsista());

			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException e) {

			throw new SQLException(e);
		}

	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSISTA);
			ps.setLong(1, id);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}
	}

	public void deleteCorso(long corso, Connection conn) throws SQLException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSO_CORSO_CORSISTA);
			ps.setLong(1, corso);
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new SQLException(sql);
		}
	}

}
