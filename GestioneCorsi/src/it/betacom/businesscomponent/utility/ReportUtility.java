package it.betacom.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.DocenteBC;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.Docente;

public class ReportUtility implements DAOConstants {

	private Connection conn;

	public ReportUtility() throws ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public Corso getCorsoPiuFreq() throws SQLException, ClassNotFoundException, IOException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ID_CORSO_PIU_FREQUENTATO);
		Corso corso = null;
		rs.beforeFirst();
		if (rs.next()) {
			CorsoBC cBC = new CorsoBC();
			corso = cBC.getById(rs.getLong(1));
		}

		return corso;
	}

	public Docente getDocenteConPiuCorsi() throws SQLException, ClassNotFoundException, IOException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_DOCENTE_PIU_CORSI);
		Docente docente = null;
		rs.beforeFirst();
		if (rs.next()) {
			DocenteBC dBC = new DocenteBC();
			docente = dBC.findByCod(rs.getString(1));
		}

		return docente;
	}

	public Corso[] getCorsiDisponibili() throws SQLException {
		Corso[] corsi = null;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSI_DISPONIBILI);
		rs.last();
		corsi = new Corso[rs.getRow()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			Corso c = new Corso();
			c.setCodCorso(rs.getLong(1));
			c.setCodDocente(rs.getString(2));
			c.setNome(rs.getString(3));
			c.setInizioCorso(new java.util.Date(rs.getDate(4).getTime()));
			c.setFineCorso(new java.util.Date(rs.getDate(5).getTime()));
			c.setAula(rs.getString(6));
			corsi[i] = c;
		}
		rs.close();
		return corsi;
	}

	public int countCommentiCorso(long id) throws SQLException {
		int count = 0;
		PreparedStatement ps = conn.prepareStatement(COUNT_COMMENTI_CORSO);
		ps.setLong(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			count = rs.getInt(1);
		return count;
	}

	public Vector<Corso> getCorsiCorsista(long cod) throws SQLException {

		Vector<Corso> corsi = new Vector<Corso>();
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSI_CORSISTA);
		ps.setLong(1, cod);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Corso c = new Corso();
			c.setCodCorso(rs.getLong(1));
			c.setCodDocente(rs.getString(2));
			c.setNome(rs.getString(3));
			c.setInizioCorso(new java.util.Date(rs.getDate(4).getTime()));
			c.setFineCorso(new java.util.Date(rs.getDate(5).getTime()));
			c.setAula(rs.getString(6));
			corsi.add(c);
		}

		return corsi;
	}

	public double getPercentualeCorso(long cod) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ID_CORSO_PIU_FREQUENTATO);
		int singolo = 0;
		int tot = 0;
		rs.beforeFirst();
		while (rs.next()) {
			if (rs.getLong(1) == cod) {
				singolo = rs.getInt(2);
			}
			tot += rs.getInt(2);
		}
		if (tot == 0)
			return 0;
		else
			return (double) singolo / tot * 100;
	}

	public Vector<Corso> findCorsiDocente(String cod) throws SQLException {
		Vector<Corso> corsi = new Vector<Corso>();
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSI_DOCENTE);
		ps.setString(1, cod);

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Corso c = new Corso();
			c.setCodCorso(rs.getLong(1));
			c.setCodDocente(rs.getString(2));
			c.setNome(rs.getString(3));
			c.setInizioCorso(new java.util.Date(rs.getDate(4).getTime()));
			c.setFineCorso(new java.util.Date(rs.getDate(5).getTime()));
			c.setAula(rs.getString(6));
			corsi.add(c);
		}

		return corsi;
	}
}
