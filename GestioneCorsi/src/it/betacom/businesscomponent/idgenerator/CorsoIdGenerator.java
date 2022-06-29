package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;

public class CorsoIdGenerator implements DAOConstants, IdGeneratorInterface {
	private static CorsoIdGenerator idgen;
	private Connection conn;

	private CorsoIdGenerator() throws ClassNotFoundException, IOException, SQLException {
		conn = DBAccess.getConnection();
	}

	public static CorsoIdGenerator getInstance() throws SQLException, ClassNotFoundException, IOException {
		if (idgen == null)
			idgen = new CorsoIdGenerator();
		return idgen;

	}

	@Override
	public long getNextId() throws ClassNotFoundException, SQLException, IOException {
		long id = 0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_CORSO_SEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return id;
	}

}
