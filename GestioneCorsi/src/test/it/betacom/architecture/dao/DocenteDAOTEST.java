package test.it.betacom.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.architecture.dao.DocenteDAO;
import it.betacom.businesscomponent.model.Docente;

class DocenteDAOTEST {
	private static Connection conn;
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindByID() {
		try {
			Docente doc = DocenteDAO.getFactory().findById(6, conn);
			System.out.println(doc.toString());
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail("Find By ID fallito: " +exc.getMessage());
		}
		
	}

}