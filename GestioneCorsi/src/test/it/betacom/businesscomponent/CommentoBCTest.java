package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import it.betacom.businesscomponent.CommentoBC;
import it.betacom.businesscomponent.model.Commento;

@TestMethodOrder(OrderAnnotation.class)
public class CommentoBCTest {

	static CommentoBC cBC;
	static Commento commento;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cBC = new CommentoBC();
		commento = new Commento();
		commento.setIdCommento(186);
		commento.setCodCorso(22078);
		commento.setCodCorsista(2221);
		commento.setDescrizione("Ottimo!");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			cBC.delete(commento.getIdCommento());
		} catch (SQLException e) {
			fail("Eccezione durante eliminazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		} finally {
			DBAccess.closeConnection();
			commento = null;
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			cBC.createOrUpdate(commento);
		} catch (ClassNotFoundException | IOException e) {
			fail("Eccezione durante la creazione: " + e.getMessage());
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(3)
	void testUpdate() {
		try {
			commento.setDescrizione("Cambiata!");
			cBC.createOrUpdate(commento);
		} catch (ClassNotFoundException | IOException e) {
			fail("Eccezione durante update: " + e.getMessage());
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(4)
	void testGetAll() {
		try {
			Commento[] c = cBC.getAll();
			assertNotNull(c);
			for (Commento comm : c) {
				System.out.println("\t" + comm.toString());
			}
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}
}
