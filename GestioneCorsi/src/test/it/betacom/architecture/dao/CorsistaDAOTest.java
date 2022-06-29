package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dao.CorsistaDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaDAOTest {
	
	static Connection conn;
	static Corsista corsista;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodCorsista(1584);
		corsista.setNome("Aldo");
		corsista.setCognome("Baglio");
		corsista.setPrecedentiFormativi("SI");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(corsista.getCodCorsista(), conn);
		} catch (SQLException e) {
			fail("Eccezione durante eliminazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		} finally {
			conn.close();
			corsista = null;
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(corsista, conn);
		} catch (SQLException e) {
			fail("Eccezione durante la creazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(2)
	void testUpdate() {
		try {
			corsista.setPrecedentiFormativi("NO");
			CorsistaDAO.getFactory().update(corsista, conn);
		} catch (SQLException e) {
			fail("Eccezione durante update: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(3)
	void testGetById() {
		try {
			Corsista c = CorsistaDAO.getFactory().findById(corsista.getCodCorsista(), conn);
			assertNotNull(c);
		} catch (SQLException e) {
			fail("Eccezione durante find by id: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(4)
	void testGetAll() {
		try {
			Corsista[] c = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(c);
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

}
