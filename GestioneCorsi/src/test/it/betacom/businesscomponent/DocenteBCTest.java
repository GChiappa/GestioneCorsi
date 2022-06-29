package test.it.betacom.businesscomponent;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.DocenteBC;
import it.betacom.businesscomponent.model.Docente;

class DocenteBCTest {

	DocenteBC dbc;
	
	@BeforeEach
	void setUp() throws Exception {
		dbc = new DocenteBC(); 
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindByCod() {
		try {
			Docente doc = dbc.findByCod("2208");
			assertNotNull(doc); // Controlla che non sia nullo
			System.out.println(doc.toString());
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail("Find By ID fallito: " + exc.getMessage());
		}

	}

}
