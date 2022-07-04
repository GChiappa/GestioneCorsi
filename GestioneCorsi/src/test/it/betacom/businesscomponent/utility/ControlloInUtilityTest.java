package test.it.betacom.businesscomponent.utility;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.utility.ControlloInUtility;

class ControlloInUtilityTest {

	@Test
	void testNomeCorsista() {
		String campo = "nome";
		String tabella = "corsista";
		String nullo = "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		String regex = "Il campo " + campo + " di " + tabella + " deve contenere da 2 a 30 lettere (a-z, A-Z)";

		assertEquals(ControlloInUtility.checkNomeCorsista(null), nullo);
		assertEquals(ControlloInUtility.checkNomeCorsista(""), nullo);
		assertEquals(ControlloInUtility.checkNomeCorsista("Sas1"), regex);
		assertEquals(ControlloInUtility.checkNomeCorsista("S"), regex);
		assertEquals(ControlloInUtility.checkNomeCorsista("Simoneeeeeeeeeeeeeeeeeeeeeeeeeeeeee"), regex);
		assertNull(ControlloInUtility.checkNomeCorsista("Simone"));
	}

	@Test
	void testCognomeCorsista() {
		String campo = "cognome";
		String tabella = "corsista";
		String nullo = "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		String regex = "Il campo " + campo + " di " + tabella + " deve contenere da 2 a 30 lettere (a-z, A-Z)";

		assertEquals(ControlloInUtility.checkCognomeCorsista(null), nullo);
		assertEquals(ControlloInUtility.checkCognomeCorsista(""), nullo);
		assertEquals(ControlloInUtility.checkCognomeCorsista("Sas1"), regex);
		assertEquals(ControlloInUtility.checkCognomeCorsista("S"), regex);
		assertEquals(ControlloInUtility.checkCognomeCorsista("Simoneeeeeeeeeeeeeeeeeeeeeeeeeeeeee"), regex);
		assertNull(ControlloInUtility.checkCognomeCorsista("Simone"));
	}

	@Test
	void testPrecedentiCorsista() {
		assertEquals(ControlloInUtility.checkPrecedentiFormativiCorsista(null),
				"Il campo dei precedenti formativi del corsista non deve essere nullo");
		assertEquals(ControlloInUtility.checkPrecedentiFormativiCorsista(""),
				"Il campo dei precedenti formativi del corsista non deve essere nullo");
		assertEquals(ControlloInUtility.checkPrecedentiFormativiCorsista("NOO"),
				"Il campo dei precedenti formativi del corsista deve essere SI o NO");
		assertEquals(ControlloInUtility.checkPrecedentiFormativiCorsista("NI"),
				"Il campo dei precedenti formativi del corsista deve essere SI o NO");
		assertEquals(ControlloInUtility.checkPrecedentiFormativiCorsista("Si"),
				"Il campo dei precedenti formativi del corsista deve essere SI o NO");
		assertNull(ControlloInUtility.checkPrecedentiFormativiCorsista("SI"));
		assertNull(ControlloInUtility.checkPrecedentiFormativiCorsista("NO"));
	}

	@Test
	void testNomeCorso() {
		String campo = "nome";
		String tabella = "corso";
		String nullo = "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		String regex = "Il campo " + campo + " di " + tabella + " deve contenere da 2 a 30 lettere (a-z, A-Z)";

		assertEquals(ControlloInUtility.checkNomeCorso(null), nullo);
		assertEquals(ControlloInUtility.checkNomeCorso(""), nullo);
		assertEquals(ControlloInUtility.checkNomeCorso("SQL1"), regex);
		assertEquals(ControlloInUtility.checkNomeCorso("S"), regex);
		assertEquals(ControlloInUtility.checkNomeCorso("SQLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL"), regex);
		assertNull(ControlloInUtility.checkNomeCorso("SQL"));
	}

	@Test
	void testNomeDataInizio() {
		String campo = "data inizio";
		String tabella = "corso";
		String nullo = "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		String regex = "Il campo " + campo + " di " + tabella + " deve essere valida e in formato DD/MM/YYYY";

		assertEquals(ControlloInUtility.checkDataInizioCorso(null), nullo);
		assertEquals(ControlloInUtility.checkDataInizioCorso(""), nullo);
		assertEquals(ControlloInUtility.checkDataInizioCorso("11/18/2000"), regex);
		assertEquals(ControlloInUtility.checkDataInizioCorso("2000/18/11"), regex);
		assertEquals(ControlloInUtility.checkDataInizioCorso("2000/11/18"), regex);
		assertEquals(ControlloInUtility.checkDataInizioCorso("39/04/2000"), regex);
		assertEquals(ControlloInUtility.checkDataInizioCorso("30/02/2000"), regex);
		assertEquals(ControlloInUtility.checkDataInizioCorso("29/02/1999"), regex);
		assertNull(ControlloInUtility.checkDataInizioCorso("18/04/2000"));
		assertNull(ControlloInUtility.checkDataInizioCorso("29/02/2000"));
	}

	@Test
	void testNomeDataFine() {
		String campo = "data fine";
		String tabella = "corso";
		String nullo = "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		String regex = "Il campo " + campo + " di " + tabella + " deve essere valida e in formato DD/MM/YYYY";

		assertEquals(ControlloInUtility.checkDataFineCorso(null), nullo);
		assertEquals(ControlloInUtility.checkDataFineCorso(""), nullo);
		assertEquals(ControlloInUtility.checkDataFineCorso("11/18/2000"), regex);
		assertEquals(ControlloInUtility.checkDataFineCorso("2000/18/11"), regex);
		assertEquals(ControlloInUtility.checkDataFineCorso("2000/11/18"), regex);
		assertEquals(ControlloInUtility.checkDataFineCorso("39/04/2000"), regex);
		assertEquals(ControlloInUtility.checkDataFineCorso("30/02/2000"), regex);
		assertEquals(ControlloInUtility.checkDataFineCorso("29/02/1999"), regex);
		assertNull(ControlloInUtility.checkDataFineCorso("18/04/2000"));
		assertNull(ControlloInUtility.checkDataFineCorso("29/02/2000"));
	}

	@Test
	void testCommento() {
		String max = "";

		for (int i = 0; i < 208; i++) {
			max = max.concat("a");
		}

		String nullo = "Il campo del commento non deve essere nullo";
		assertEquals(ControlloInUtility.checkCommento(null), nullo);
		assertEquals(ControlloInUtility.checkCommento(""), nullo);

		assertEquals(ControlloInUtility.checkCommento(max),
				"Il campo del commento deve essere di massimo 200 caratteri");
		assertNull(ControlloInUtility.checkCommento("Commento, Prova01."));
	}

	@Test
	void testAulaCorso() {
		String campo = "aula";
		String tabella = "corso";
		String nullo = "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		String regex = "Il campo " + campo + " di " + tabella + " deve contenere da 2 a 30 lettere (a-z, A-Z, 0-9)";

		assertEquals(ControlloInUtility.checkAulaCorso(null), nullo);
		assertEquals(ControlloInUtility.checkAulaCorso(""), nullo);
		assertEquals(ControlloInUtility.checkAulaCorso("S"), regex);
		assertEquals(ControlloInUtility.checkAulaCorso("Alfa0555555555555555555555555555555"), regex);
		assertNull(ControlloInUtility.checkAulaCorso("Alfa05"));
	}

	@Test
	void testDocente() {
		try {
			assertNotNull(ControlloInUtility.checkDocente("1"));
			assertNull(ControlloInUtility.checkDocente("sas"));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
			fail("Eccezione durante la ricerca: " + e.getMessage());
		}
	}

}
