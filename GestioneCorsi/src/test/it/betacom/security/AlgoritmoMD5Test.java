package test.it.betacom.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.betacom.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void test() {
		System.out.println(AlgoritmoMD5.convertiMD5("Spass£1"));
		assertNotEquals(AlgoritmoMD5.convertiMD5("Spass£1"), "Spass£1");
	}

}
