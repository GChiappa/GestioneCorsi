package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dao.CommentoDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Commento;

@TestMethodOrder(OrderAnnotation.class)
class CommentoDAOTest {
	static Connection conn;
	static Commento commento;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		commento = new Commento();
		commento.setIdCommento(159);
		commento.setCodCorso(1);
		commento.setCodCorsista(2);
		commento.setDescrizione("Ottimo!");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CommentoDAO.getFactory().delete(commento.getIdCommento(), conn);
		} catch (SQLException e) {
			fail("Eccezione durante eliminazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		} finally {
			conn.close();
			commento = null;
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CommentoDAO.getFactory().create(commento, conn);
		} catch (SQLException e) {
			fail("Eccezione durante la creazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(2)
	void testUpdate() {
		try {
			commento.setDescrizione("Benissimo!");
			CommentoDAO.getFactory().update(commento, conn);
		} catch (SQLException e) {
			fail("Eccezione durante update: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(3)
	void testGetAll() {
		try {
			Commento[] c = CommentoDAO.getFactory().getAll(conn);
			assertNotNull(c);
			for (Commento comm : c) {
				System.out.println("\t" + comm.toString());
			}
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}
}
