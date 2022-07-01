package test.it.betacom.businesscomponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import it.betacom.architecture.dbaccess.DBAccess;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {
	private static Corso corso;
	private static Connection conn;
	private static CorsoBC cbc;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corso();
		corso.setCodCorso(0);
		corso.setCodDocente("2");
		corso.setNome("DATABASE");
		corso.setInizioCorso(new GregorianCalendar(2022, 7, 10).getTime());
		System.out.println(corso.getInizioCorso());
		corso.setFineCorso(new GregorianCalendar(2022, 8, 10).getTime());
		System.out.println(corso.getFineCorso());
		corso.setAula("C5");

		cbc = new CorsoBC();

	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		try {

			cbc.delete(corso.getCodCorso());
			System.out.println("eliminazione corso corso");

			DBAccess.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();

			fail("metodo di pulizia fallito: " + e.getMessage());
		} finally {
			conn.close();
			cbc = null;
		}
	}

	@Test
	@Order(1)
	void testcreate() {
		try {
			cbc.CreateorUpdate(corso);
			System.out.println("corso Creato");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			fail("Eccezione durante la creazione: " + e.getMessage());
		}

	}

	@Test
	@Order(2)
	void testUpdate() {
		try {
			corso.setCodDocente("3");
			corso.setNome("Chittara");
			corso.setInizioCorso(new GregorianCalendar(2022, 8, 16).getTime());
			corso.setFineCorso(new GregorianCalendar(2022, 9, 16).getTime());
			corso.setAula("A5");
			cbc.CreateorUpdate(corso);
			assertNotNull(corso);
			System.out.println("Articolo Aggiornato");
		} catch (SQLException | ClassNotFoundException | IOException e) {
			fail("Eccezione durante l'update: " + e.getMessage());
		}
	}

	@Test
	@Order(3)
	void testFindById() {
		try {
			Corso c = cbc.getById(corso.getCodCorso());
			assertNotNull(c);
			System.out.println("corso trovato tramite chiave:\n\t" + c.toString());
		} catch (SQLException e) {
			fail("Eccezione durante la ricerca per id: " + e.getMessage());
		}
	}

	@Test
	@Order(4)
	void testGetAll() {
		try {
			Corso[] corsi = cbc.getCorsi();
			assertNotNull(corsi);
			System.out.println("corsi trovati:");
			for (Corso c : corsi) {
				System.out.println("\t" + c.toString());
			}
		} catch (SQLException e) {
			fail("Eccezione durante getAll: " + e.getMessage());
		}
	}

	@Test
	@Order(5)
	void testUltimoCorso() {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
			java.util.Date data = new java.util.Date(cbc.getUltimoCorso().getTime());

			System.out.println("Data inizio Ultimo Corso:");

			System.out.println(simpleDateFormat.format(data));
		} catch (SQLException e) {
			fail("Eccezione durante getAll: " + e.getMessage());
		}
	}

}
