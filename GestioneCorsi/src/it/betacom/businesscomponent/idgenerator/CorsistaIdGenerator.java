package it.betacom.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;

public class CorsistaIdGenerator implements IdGeneratorInterface, DAOConstants {

	private static CorsistaIdGenerator idGen;
	private Connection conn;

	private CorsistaIdGenerator() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}

	public static CorsistaIdGenerator getInstance() throws ClassNotFoundException, SQLException, IOException {
		if (idGen == null)
			idGen = new CorsistaIdGenerator();
		return idGen;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, SQLException, IOException {
		long cod = 0;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_CORSISTA_SEQ);
		rs.next();
		cod = rs.getLong(1);
		return cod;
	}

}
