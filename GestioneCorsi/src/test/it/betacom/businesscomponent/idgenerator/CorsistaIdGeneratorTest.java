package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void test() {
		CorsistaIdGenerator idGen;
		try {
			idGen = CorsistaIdGenerator.getInstance();
			assertEquals(idGen.getNextId(), idGen.getNextId() - 1);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail("Errore Sequenza: " + e.getMessage());
		}
	}

}
