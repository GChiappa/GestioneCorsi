package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.businesscomponent.model.Corso;
import it.betacom.architecture.dao.CorsoDAO;
import it.betacom.architecture.dbaccess.DBAccess;
@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Corso corso;
	private static Connection conn;
	
	@BeforeAll
	public static void setUP() throws Exception{
		conn=DBAccess.getConnection();
		corso = new Corso();
		corso.setCodCorso(5);
		corso.setCodDocente("2");
		corso.setNome("DATABASE");
		corso.setInizioCorso(new GregorianCalendar(2022, 7, 10).getTime());
		corso.setInizioCorso(new GregorianCalendar(2022, 8, 10).getTime());
		corso.setAula("C5");
	}
	
	
	@Test
	@Order(1)
	void testcreate() {
		try {
			CorsoDAO.getFactory().create(corso, conn);
	} catch (SQLException e) {
		e.printStackTrace();

		fail("eccezione dovuta la create: " + e.getMessage());
	}
	}
	
	@Test
	@Order(2)
	void testupdateGetbyid() {
		try {
			corso = new Corso();
			corso.setCodDocente("3");
			corso.setNome("Chittara");
			corso.setInizioCorso(new GregorianCalendar(2022, 8, 16).getTime());
			corso.setFineCorso(new GregorianCalendar(2022, 9, 16).getTime());
			corso.setCodCorso(5);
			CorsoDAO.getFactory().update(corso, conn);
			System.out.println("Aggiornamento corso");
			Corso cor=CorsoDAO.getFactory().findById(5, conn);
			System.out.println(cor.toString());
		} catch (SQLException e) {
			e.printStackTrace();

			fail("getByid o update fallito: " + e.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetall() {
		try {
		Corso[] corsi = CorsoDAO.getFactory().getAll(conn);
		assertNotNull(corsi);
	} catch (SQLException e) {
		e.printStackTrace();

		fail("eccezione dovuta la create: " + e.getMessage());
		
	}
		
	}
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {

			CorsoDAO.getFactory().delete(5, conn);
			System.out.println("articolo corso");
			
			DBAccess.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();

			fail("metodo di pulizia fallito: " + e.getMessage());
		}
	}

}
