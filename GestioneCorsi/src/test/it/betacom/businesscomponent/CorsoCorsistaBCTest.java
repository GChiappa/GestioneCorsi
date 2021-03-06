package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.model.CorsoCorsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsoCorsistaBCTest {

	static CorsoCorsistaBC ccBC;
 
	static CorsoCorsista cc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		cc= new CorsoCorsista();
		ccBC = new CorsoCorsistaBC();
		cc.setCodCorsoCorsista(20);
		cc.setCodCorso(1);
		cc.setCodCorsista(1);
	 
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			ccBC.delete(20);
			System.out.println("Riga eliminata Correttamente");
		} catch (SQLException e) {
			fail("Eccezione durante eliminazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		} finally {
			DBAccess.closeConnection();
			 
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		
		try {
			ccBC.create(cc);
			System.out.println("Riga creata correttamente");
		} catch (ClassNotFoundException | IOException e) {
			fail("Eccezione durante la creazione: " + e.getMessage());
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	 
}
