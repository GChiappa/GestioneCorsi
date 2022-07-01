package test.it.betacom.businesscomponent.utility;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.utility.LoginUtility;
import it.betacom.security.AlgoritmoMD5;

class LoginUtilityTest {

	@Test
	void testPSW() {
		try {
			LoginUtility lu = new LoginUtility();
			String password = AlgoritmoMD5.convertiMD5("Pass01");
			assertEquals(lu.getAdminPass("CodAdm176"), password);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("Eccezione durante Password");
		}
	}
	
	@Test
	void testNOM() {
		try {
			LoginUtility lu = new LoginUtility();
			String nominativo = lu.getAdminNom("CodAdm176");
			assertNotNull(nominativo);
		} catch (SQLException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("Eccezione durante Password");
		}
	}

}
