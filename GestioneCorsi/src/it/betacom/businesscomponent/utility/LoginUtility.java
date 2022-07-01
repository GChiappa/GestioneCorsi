package it.betacom.businesscomponent.utility;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;

public class LoginUtility implements DAOConstants {
	private Connection conn;

	public LoginUtility() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}

	public String getadminpass(String username) throws SQLException {

		PreparedStatement ps = conn.prepareStatement(PASSWORD_AMMINISTRATORE);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getString(1);
		return null;

	}

	public String getadminname(String codAdmin) throws SQLException {

		PreparedStatement ps = conn.prepareStatement(NOMINATIVO_AMMINISTRATORE);
		ps.setString(1, codAdmin);
		ResultSet rs = ps.executeQuery();
		if (rs.next())
			return rs.getString(1) + " " + rs.getString(1);
		return null;

	}
}
