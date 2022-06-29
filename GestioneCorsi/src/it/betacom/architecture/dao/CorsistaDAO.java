package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.BC.model.Corsista;

public class CorsistaDAO implements DAOConstants, GenericDAO<Corsista> {

	private CachedRowSet rowSet;

	public static CorsistaDAO getFactory() throws SQLException {
		return new CorsistaDAO();
	}

	private CorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Corsista entity, Connection conn) throws SQLException {

		rowSet.setCommand(SELECT_CORSISTA);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();

		rowSet.updateLong(1, entity.getCodCorsista());
		rowSet.updateString(2, entity.getNome());
		rowSet.updateString(3, entity.getCognome());
		rowSet.updateString(4, entity.getPrecedentiFormativi());

		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();

	}

	@Override
	public void update(Corsista entity, Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_CORSISTA);

		ps.setString(1, entity.getNome());
		ps.setString(2, entity.getCognome());
		ps.setString(3, entity.getPrecedentiFormativi());
		ps.setLong(3, entity.getCodCorsista());

		ps.execute();
		conn.commit();
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_CORSISTA);

		ps.setLong(1, id);
		ps.execute();
		conn.commit();

	}

	@Override
	public Corsista findById(long id, Connection conn) throws SQLException {
		Corsista c = null;

		try {
			rowSet.setCommand(FBYID_CORSISTA);
			rowSet.setLong(1, id);
			rowSet.execute(conn);

			rowSet.beforeFirst();
			rowSet.next();

			c = new Corsista();
			c.setCodCorsista(rowSet.getLong(1));
			c.setNome(rowSet.getString(2));
			c.setCognome(rowSet.getString(3));
			c.setPrecedentiFormativi(rowSet.getString(4));
		} catch (SQLException e) {
			throw e;
		}
		return c;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws SQLException {
		Corsista[] corsisti = null;
		Corsista c;
		try {
			rowSet.setCommand(FBYID_CORSISTA);
			rowSet.execute(conn);

			rowSet.last();
			corsisti = new Corsista[rowSet.getRow()];

			rowSet.beforeFirst();
			for (int i = 0; rowSet.next(); i++) {
				c = new Corsista();
				c.setCodCorsista(rowSet.getLong(1));
				c.setNome(rowSet.getString(2));
				c.setCognome(rowSet.getString(3));
				c.setPrecedentiFormativi(rowSet.getString(4));
				corsisti[i] = c;
			}

		} catch (SQLException e) {
			throw e;
		}
		return corsisti;
	}

}
