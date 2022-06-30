package it.betacom.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.businesscomponent.model.Docente;

public class DocenteDAO implements GenericDAO<Docente>, DAOConstants {

	private DocenteDAO() throws SQLException {
	}

	public static DocenteDAO getFactory() throws SQLException {
		return new DocenteDAO();

	}

	@Override
	public Docente findById(long id, Connection conn) throws SQLException {

		return null;
	}

	public Docente findByCod(String cod, Connection conn) throws SQLException {
		Docente docente = null;
		PreparedStatement ps;
		ps = conn.prepareStatement(FBYID_DOCENTE);
		ps.setString(1, cod);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			docente = new Docente();
			docente.setCodDocente(rs.getString(1));
			docente.setNome(rs.getString(2));
			docente.setCognome(rs.getString(3));
			docente.setCv(rs.getString(4));
		}

		return docente;
	}

	@Override
	public void create(Docente entity, Connection conn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Docente entity, Connection conn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id, Connection conn) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Docente[] getAll(Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
