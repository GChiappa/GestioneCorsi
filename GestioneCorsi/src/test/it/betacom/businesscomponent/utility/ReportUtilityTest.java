package test.it.betacom.businesscomponent.utility;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.Docente;
import it.betacom.businesscomponent.utility.ReportUtility;

@TestMethodOrder(OrderAnnotation.class)
class ReportUtilityTest {

	static ReportUtility rep;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rep = new ReportUtility();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		rep = null;
	}

	@Test
	@Order(1)
	void testCPF() {
		System.out.println("\ngetCorsoPiuFreq");

		Corso c;
		try {
			c = rep.getCorsoPiuFreq();

			assertNotNull(c);

			System.out.println("\t" + c.toString());

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail("Errore nella ricerca");
		}

	}
	
	@Test
	@Order(2)
	void testGDCPC() {
		System.out.println("\ngetDocenteConPiuCorsi");

		Docente d;
		try {
			d = rep.getDocenteConPiuCorsi();

			assertNotNull(d);

			System.out.println("\t" + d.toString());

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail("Errore nella ricerca");
		}

	}

	@Test
	@Order(3)
	void testGCD() {
		System.out.println("\ngetCorsiDisponibili");

		Corso[] corsi;
		try {
			corsi = rep.getCorsiDisponibili();

			assertNotNull(corsi);

			for (Corso c : corsi)
				System.out.println("\t" + c.toString());

		} catch (SQLException e) {
			e.printStackTrace();
			fail("\tErrore nella ricerca");
		}

	}

	@Test
	@Order(4)
	void testCCC() {
		System.out.println("\ncountCommentiCorso");

		int numCommenti = -1;
		int failing = -1;
		try {
			numCommenti = rep.countCommentiCorso(1);

			assertNotEquals(numCommenti, failing);

				System.out.println("\tNumero commenti:" + numCommenti);

		} catch (SQLException e) {
			e.printStackTrace();
			fail("\tErrore nella ricerca");
		}

	}

}
