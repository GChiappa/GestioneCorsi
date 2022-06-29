package it.betacom.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.CorsoCorsista;

public class CorsoCorsistaBC {
private Connection conn;
 
	
	public CorsoCorsistaBC() throws ClassNotFoundException, SQLException, IOException{
		conn = DBAccess.getConnection();
 
	}
	
	public void create (CorsoCorsista cc) throws ClassNotFoundException, IOException, SQLException {
		try {
			
			 
			CorsoCorsistaDAO.getFactory().create(cc, conn);
			
		} catch (SQLException  exc) {
			throw new SQLException(exc);
			 
		}
	}
	
	public void delete (long id) throws SQLException {
		try {
			CorsoCorsistaDAO.getFactory().delete(id, conn);
			
		}
		catch (SQLException  exc) {
			throw new SQLException(exc);
			 
		}
	}
	
	
}
