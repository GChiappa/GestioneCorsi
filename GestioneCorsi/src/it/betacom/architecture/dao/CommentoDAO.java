package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.businesscomponent.model.Commento;

public class CommentoDAO implements DAOConstants, GenericDAO<Commento> {

	private CachedRowSet rowSet;

	public static CommentoDAO getFactory() throws SQLException {
		return new CommentoDAO();
	}

	private CommentoDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	@Override
	public void create(Commento entity, Connection conn) throws SQLException {

		rowSet.setCommand(SELECT_COMMENTO);
		rowSet.execute(conn);

		rowSet.moveToInsertRow();

		rowSet.updateLong(1, entity.getIdCommento());
		rowSet.updateLong(2, entity.getCodCorso());
		rowSet.updateLong(3, entity.getCodCorsista());
		rowSet.updateString(4, entity.getDescrizione());

		rowSet.insertRow();

		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();

	}

	@Override
	public void update(Commento entity, Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_COMMENTO);

		ps.setLong(1, entity.getCodCorso());
		ps.setLong(2, entity.getCodCorsista());
		ps.setString(3, entity.getDescrizione());
		ps.setLong(4, entity.getIdCommento());

		ps.execute();
		conn.commit();
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_COMMENTO);

		ps.setLong(1, id);
		ps.execute();
		conn.commit();

	}

	@Override
	public Commento findById(long id, Connection conn) throws SQLException {
		// NO
		return null;
	}

	@Override
	public Commento[] getAll(Connection conn) throws SQLException {
		Commento[] commento = null;
		Commento c;
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_COMMENTO);

			rs.beforeFirst();
			if (rs.next()) {
				rs.last();
				commento = new Commento[rs.getRow()];
				rs.beforeFirst();
				for (int i = 0; rs.next(); i++) {
					c = new Commento();
					c.setIdCommento(rs.getLong(1));
					c.setCodCorso(rs.getLong(2));
					c.setCodCorsista(rs.getLong(3));
					c.setDescrizione(rs.getString(4));
					commento[i] = c;
				}
			}

		} catch (SQLException e) {
			throw e;
		}
		return commento;
	}

}
