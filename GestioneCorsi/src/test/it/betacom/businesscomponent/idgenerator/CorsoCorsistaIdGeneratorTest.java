package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.idgenerator.CorsoCorsistaIdGenerator;

class CorsoCorsistaIdGeneratorTest {

	@Test
	void test() {
		CorsoCorsistaIdGenerator idGen;
		try {
			idGen = CorsoCorsistaIdGenerator.getInstance();
			assertEquals(idGen.getNextId(), idGen.getNextId() - 1);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail("Errore Sequenza: " + e.getMessage());
		}
	}

}
