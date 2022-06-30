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
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaBCTest {

	static CorsistaBC cBC;
	static Corsista corsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		cBC = new CorsistaBC();
		corsista = new Corsista();
		corsista.setCodCorsista(0);
		corsista.setNome("Aldo");
		corsista.setCognome("Baglio");
		corsista.setPrecedentiFormativi("SI");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			cBC.delete(corsista.getCodCorsista());
		} catch (SQLException e) {
			fail("Eccezione durante eliminazione: " + e.getMessage() + "\n\n" + e.getErrorCode());
		} finally {
			DBAccess.closeConnection();
			corsista = null;
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			cBC.createOrUpdate(corsista);
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
			corsista.setPrecedentiFormativi("NO");
			cBC.createOrUpdate(corsista);
		} catch (ClassNotFoundException | IOException e) {
			fail("Eccezione durante update: " + e.getMessage());
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(2)
	void testGetById() {
		try {
			Corsista c = cBC.findById(corsista.getCodCorsista());
			;
			assertNotNull(c);
			System.out.println("\t" + c.toString());
		} catch (SQLException e) {
			fail("Eccezione durante find by id: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(4)
	void testGetAll() {
		try {
			Corsista[] c = cBC.getAll();
			assertNotNull(c);
			for (Corsista cors : c) {
				System.out.println("\t" + cors.toString());
			}
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}

	@Test
	@Order(5)
	void testGetNumCorsisti() {
		try {
			int num = cBC.getNumeroCorsisti();
			assertNotNull(num);
			 System.out.println("Numero corsisti : "+num);
		} catch (SQLException e) {
			fail("Eccezione durante get all: " + e.getMessage() + "\n\n" + e.getErrorCode());
		}
	}
	
}
