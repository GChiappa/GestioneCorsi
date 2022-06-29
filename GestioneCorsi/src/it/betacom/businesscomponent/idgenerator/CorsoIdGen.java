package it.betacom.businesscomponent.idgenerator;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import it.betacom.architecture.dao.DAOConstants;
import it.betacom.architecture.dbaccess.DBAccess;


public class CorsoIdGen implements DAOConstants,IdGeneratorInterface {
	private static CorsoIdGen idgen;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CorsoIdGen() throws ClassNotFoundException, IOException, SQLException{
		conn=DBAccess.getConnection();
	}

	public static CorsoIdGen GetInstance() throws SQLException , ClassNotFoundException, IOException{
		if(idgen==null)
			idgen=new CorsoIdGen();
		return idgen;
		
	}
	@Override
	public long getNextId() throws ClassNotFoundException, SQLException, IOException {
		long id=0;
		try {
			stmt=conn.createStatement();
			rs= stmt.executeQuery(SELECT_CORSO_SEQ);
			rs.next();
			id=rs.getLong(1);
		}catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
	return id;
	}
	
}
