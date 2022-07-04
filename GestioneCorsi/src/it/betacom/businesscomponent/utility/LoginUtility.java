package it.betacom.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {
	private Connection conn;

	public LoginUtility() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getAdminPass(String codAdmin) throws SQLException {

		PreparedStatement ps = conn.prepareStatement(PASSWORD_AMMINISTRATORE);
		ps.setString(1, codAdmin);
		ResultSet rs = ps.executeQuery();

		if (rs.next())
			return rs.getString(1);
		else
			return null;

	}

	public String getAdminNom(String codAdmin) throws SQLException {

		PreparedStatement ps = conn.prepareStatement(NOMINATIVO_AMMINISTRATORE);
		ps.setString(1, codAdmin);
		ResultSet rs = ps.executeQuery();

		if (rs.next())
			return rs.getString(1) + " " + rs.getString(2);
		else
			return null;

	}

	public void saveSession(HttpSession session) throws SQLException {
		CachedRowSet rowSet = RowSetProvider.newFactory().createCachedRowSet();

		rowSet.setCommand(SELECT_SESSIONI);
		rowSet.execute(conn);

		rowSet.moveToInsertRow();

		rowSet.updateString(1, (String) session.getAttribute("admin"));
		rowSet.updateLong(2, session.getCreationTime());

		rowSet.insertRow();

		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}
}
