package test.it.betacom.businesscomponent.idgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.idgenerator.CorsoIdGenerator;

class CorsoIdGeneratorTest {

	@Test
	void test() {
		CorsoIdGenerator idGen;
		try {
			idGen = CorsoIdGenerator.getInstance();
			assertEquals(idGen.getNextId(), idGen.getNextId() - 1);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
			fail("Errore Sequenza: " + e.getMessage());
		}
	}

}
