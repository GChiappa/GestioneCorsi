package test.it.betacom.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.model.Docente;

class DocenteDAOTest {
	private static Connection conn;

	@BeforeEach
	void setUp() throws Exception {
		conn = DBAccess.getConnection();
	}

	@AfterEach
	void tearDown() throws Exception {
		DBAccess.closeConnection();
	}

	@Test
	void testFindByCod() {
		try {
			Docente doc = DocenteDAO.getFactory().findByCod("1", conn);
			assertNotNull(doc); // Controlla che non sia nullo
			System.out.println(doc.toString());
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail("Find By ID fallito: " + exc.getMessage());
		}

	}

}
