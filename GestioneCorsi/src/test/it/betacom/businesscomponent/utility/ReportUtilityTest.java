package test.it.betacom.businesscomponent.utility;

import static org.junit.Assert.assertNotNull;
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
	void test() {

		Corso c;
		try {
			c = rep.getCorsoPiuFreq();

			assertNotNull(c);

			System.out.println(c.toString());

		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail("Errore nella ricerca");
		}

	}

}
