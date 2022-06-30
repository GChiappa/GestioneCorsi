package test.it.betacom.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import it.betacom.architecture.dbaccess.DBAccess;

class DBAccessTest {

	@Test
	void test() {
		try {
			assertNotNull(DBAccess.getConnection());
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("Eccezione durante la connessione");
		}
		DBAccess.closeConnection();
	}

}
