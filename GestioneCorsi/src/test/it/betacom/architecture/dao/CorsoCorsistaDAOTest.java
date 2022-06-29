package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dao.CorsoCorsistaDAO;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaDAOTest {

		private static CorsoCorsista cc;
		private static Corsista ca;
		private static Corso co;
		private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		conn = DBAccess.getConnection();
		
 
		cc = new CorsoCorsista();
		cc.setCodCorsoCorsista(98);
		cc.setCodCorso(198);
		cc.setCodCorsista(8);
		
		
	}

	@AfterAll
	static void tearDown() throws Exception {
		
		try {
		 
			CorsoDAO.getFactory().delete(7,conn);
			 Statement stmt = conn.createStatement();
			 stmt.executeQuery("Delete from corsista where cod_corsista = '9'");
			 conn.commit();
			 stmt.close();
			 Statement stmt2 = conn.createStatement();
			 stmt2.executeUpdate("Delete from corso_corsista where cod_corso_corsista='10'");
			 conn.commit();
			 
			 conn.close();
			DBAccess.closeConnection();
			}catch (Exception  exc) {
				exc.printStackTrace();
				fail(" Metodo di pulizia fallito: "+ exc.getMessage());
			}
	}

	@Test
	void testCreate() throws ClassNotFoundException, IOException {
	
				
		 try {
			 		 
			 CorsoDAO.getFactory().create(co, conn );
			CorsistaDAO.getFactory().create(ca, conn);
			CorsoCorsistaDAO.getFactory().create(cc, conn);
			 
			  
			  
		 }catch (SQLException exc) {
				exc.printStackTrace();
				fail(" Eccezione : "+ exc.getMessage());
			}
		
		
		 
	}

}
