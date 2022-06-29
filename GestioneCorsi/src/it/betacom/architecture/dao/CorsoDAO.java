package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.BC.model.Corso;

public class CorsoDAO implements GenericDAO<Corso>, DAOConstants {

	private CachedRowSet rowset;

	private CorsoDAO() throws SQLException {

		rowset = RowSetProvider.newFactory().createCachedRowSet();

	}
	public static CorsoDAO getFactory() throws SQLException{
		return new CorsoDAO();
		
	}
	@Override
	public void create(Corso entity, Connection conn) throws SQLException {
		try {
			rowset.setCommand(SELECT_CORSO);
			rowset.execute(conn);
			rowset.moveToInsertRow();
			rowset.updateLong(1, entity.getCodCorso());
			rowset.updateString(2, entity.getCodDocente());
			rowset.updateString(3, entity.getNome());
			rowset.updateDate(4, new java.sql.Date(entity.getInizioCorso().getTime()));
			rowset.updateDate(5, new java.sql.Date(entity.getFineCorso().getTime()));

			rowset.insertRow();
			rowset.moveToCurrentRow();
			rowset.acceptChanges();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public void update(Corso entity, Connection conn) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(UPDATE_CORSO);
		ps.setString(1, entity.getCodDocente());
		ps.setString(2, entity.getNome());
		ps.setDate(3, new java.sql.Date(entity.getInizioCorso().getTime()));
		ps.setDate(4, new java.sql.Date(entity.getFineCorso().getTime()));
		ps.setLong(5, entity.getCodCorso());
		ps.execute();
		conn.commit();
	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
		PreparedStatement ps;
		ps = conn.prepareStatement(DELETE_CORSO);
		ps.setLong(1, id);
		ps.execute();
		conn.commit();

	}

	@Override
	public Corso findById(long id, Connection conn) throws SQLException {
		Corso corso = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(FBYID_CORSO);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			corso = new Corso();
			corso.setCodCorso(rs.getLong(1));
			corso.setCodDocente(rs.getString(2));
			corso.setNome(rs.getString(3));
			corso.setInizioCorso(rs.getDate(4));
			corso.setFineCorso(rs.getDate(5));

		}
		return corso;
	}

	@Override
	public Corso[] getAll(Connection conn) throws SQLException {
		Corso[] corso = null;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSO);
		rs.last();
		corso = new Corso[rs.getRow()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			Corso c = new Corso();
			c.setCodCorso(rs.getLong(1));
			c.setCodDocente(rs.getString(2));
			c.setNome(rs.getString(3));
			c.setInizioCorso(new java.util.Date(rs.getDate(4).getTime()));
			c.setFineCorso(new java.util.Date(rs.getDate(5).getTime()));
			corso[i] = c;
		}
		rs.close();
		return null;
	}

}
