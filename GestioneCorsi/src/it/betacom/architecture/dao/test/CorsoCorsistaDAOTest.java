package it.betacom.architecture.dao.test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
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

		private CorsoCorsista cc;
		private Corsista ca;
		private Corso co;
		private static Connection conn;
	
	@BeforeEach
	void setUp() throws Exception {
		
		co.setNome("CorsoProva");
		co.setCodCorso(1);
		co.setCodDocente("c1");
		co.setInizioCorso(new GregorianCalendar(1990,10,1).getTime());
		co.setFineCorso(new GregorianCalendar(1990,10,4).getTime());
		
		ca.setCodCorsista(3);
		ca.setNome("NomeT");
		ca.setCognome("CognomeT");
		ca.setPrecedentiFormativi("precedenti Test");
		
		cc.setCodCorsoCorsista("cc1");
		cc.setCodCorso(1);
		cc.setCodCorsista(3);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		try {
			conn = DBAccess.getConnection();
			CorsoDAO.getFactory().delete(1,DBAccess.getConnection());
			 Statement stmt = conn.createStatement();
			 stmt.executeQuery("Delete from corsista where cod_corsista = '3'");
			 conn.commit();
			 stmt.close();
			 Statement stmt2 = conn.createStatement();
			 stmt2.executeUpdate("Delete from corso_corsista where cod_corso_corsista='cc1'");
			 conn.commit();
			 
			DBAccess.closeConnection();
			}catch (Exception  exc) {
				exc.printStackTrace();
				fail(" Metodo di pulizia fallito: "+ exc.getMessage());
			}
	}

	@Test
	void testCreate() throws ClassNotFoundException, IOException {
		 try {
			 
			 
			 CorsoDAO.getFactory().create(co, DBAccess.getConnection() );
			CorsistaDAO.getFactory().create(ca, DBAccess.getConnection());
			CorsoCorsistaDAO.getFactory().create(cc,DBAccess.getConnection());
			 
			  
			  
		 }catch (SQLException exc) {
				exc.printStackTrace();
				fail(" Eccezione : "+ exc.getMessage());
			}
		
		
		 
	}

}
