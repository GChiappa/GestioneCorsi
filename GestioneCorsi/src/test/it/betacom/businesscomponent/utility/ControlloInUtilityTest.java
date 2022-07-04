package test.it.betacom.businesscomponent.utility;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import it.betacom.businesscomponent.utility.ControlloInUtility;

class ControlloInUtilityTest {

	@Test
	void testNomeCorsista() {
		assertEquals(ControlloInUtility.checkNomeCorsista(null),
				"Il campo del nome del corsista non deve essere nullo");
		assertEquals(ControlloInUtility.checkNomeCorsista(""), "Il campo del nome del corsista non deve essere nullo");
		assertEquals(ControlloInUtility.checkNomeCorsista("Sas1"),
				"Il campo del nome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)");
		assertEquals(ControlloInUtility.checkNomeCorsista("S"),
				"Il campo del nome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)");
		assertEquals(ControlloInUtility.checkNomeCorsista("Simoneeeeeeeeeeeeeeeeeeeeeeeeeeeeee"),
				"Il campo del nome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)");
		assertNull(ControlloInUtility.checkNomeCorsista("Simone"));
	}

	@Test
	void testCognomeCorsista() {
		assertEquals(ControlloInUtility.checkCognomeCorsista(null),
				"Il campo del cognome del corsista non deve essere nullo");
		assertEquals(ControlloInUtility.checkCognomeCorsista(""),
				"Il campo del cognome del corsista non deve essere nullo");
		assertEquals(ControlloInUtility.checkCognomeCorsista("Sas1"),
				"Il campo del cognome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)");
		assertEquals(ControlloInUtility.checkCognomeCorsista("S"),
				"Il campo del cognome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)");
		assertEquals(ControlloInUtility.checkCognomeCorsista("Simoneeeeeeeeeeeeeeeeeeeeeeeeeeeeee"),
				"Il campo del cognome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)");
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

}
