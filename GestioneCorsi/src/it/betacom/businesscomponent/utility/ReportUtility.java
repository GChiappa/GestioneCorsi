package it.betacom.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.Docente;

public class ReportUtility implements DAOConstants {

	private Connection conn;

	public ReportUtility() throws ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public Corso getCorsoPiuFreq() throws SQLException, ClassNotFoundException, IOException {
		// TODO testing
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ID_CORSO_PIU_FREQUENTATO);
		Corso corso = null;
		rs.beforeFirst();
		if(rs.next()) {
			CorsoBC cBC = new CorsoBC();
			corso = cBC.getById(rs.getLong(1));
		}
		
		return corso;
	}

	public Docente getDocenteConPiuCorsi() {
		// TODO stmt che ritorna il docente con piu corsi
		return null;
	}

	public Corso[] getCorsiDisponibili() {
		// TODO ps che ritorna i corsi disponibili
		return null;
	}

	public int countCommentiCorso(Corso corso) {
		// TODO ps che ritorna i commenti di un corso
		return 0;
	}

	public Vector<String[]> getReportCorsoCorsista() {
		// TODO Auto-generated method stub
		return null;
	}

}
