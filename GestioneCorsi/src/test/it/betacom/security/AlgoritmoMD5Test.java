package test.it.betacom.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.betacom.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void test() {
		System.out.println("insert into amministratore values ('CodAdm176','Aldo','Baglio','" + AlgoritmoMD5.convertiMD5("Pass01") + "');");
		assertNotEquals(AlgoritmoMD5.convertiMD5("Pass01"), "Pass01");
	}

}
