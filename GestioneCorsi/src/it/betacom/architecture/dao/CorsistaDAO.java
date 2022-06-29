package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.Corsista;

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
		ps.setLong(4, entity.getCodCorsista());

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
		Corsista corsista = null;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(FBYID_CORSISTA);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				corsista = new Corsista();
				corsista.setCodCorsista(rs.getLong(1));
				corsista.setNome(rs.getString(2));
				corsista.setCognome(rs.getString(3));
				corsista.setPrecedentiFormativi(rs.getString(4));
			}
		} catch (SQLException e) {
			throw e;
		}
		return corsista;
	}

	@Override
	public Corsista[] getAll(Connection conn) throws SQLException {
		Corsista[] corsisti = null;
		Corsista c;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTA);

			rs.beforeFirst();
			if (rs.next()) {
				rs.last();
				corsisti = new Corsista[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					c = new Corsista();
					c.setCodCorsista(rs.getLong(1));
					c.setNome(rs.getString(2));
					c.setCognome(rs.getString(3));
					c.setPrecedentiFormativi(rs.getString(4));
					corsisti[i] = c;
				}
			}

		} catch (SQLException e) {
			throw e;
		}
		return corsisti;
	}

}
