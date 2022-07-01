package it.betacom.businesscomponent.facade;

import java.io.IOException;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Set;
import java.util.stream.Collectors;

import it.betacom.businesscomponent.CommentoBC;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.DocenteBC;
import it.betacom.businesscomponent.model.Commento;
import it.betacom.businesscomponent.model.Corsista;
import it.betacom.businesscomponent.model.Corso;
import it.betacom.businesscomponent.model.Docente;

public class AdminFacade {

	private static AdminFacade cF;
	private static CorsoBC corsoBC;
	private static CorsoCorsistaBC ccBC;
	private static CorsistaBC corsistaBC;
	private static DocenteBC docenteBC;
	private static CommentoBC cBC;
	private static CommentoBC comBC;

	private AdminFacade() {
	}

	public static AdminFacade getInstance() {
		if (cF == null)
			cF = new AdminFacade();
		return cF;
	}

	public Corsista[] getCorsisti() throws ClassNotFoundException, IOException, SQLException {

		corsistaBC = new CorsistaBC();
		return corsistaBC.getAll();

	}

	public void createCorsista(Corsista corsista) throws ClassNotFoundException, SQLException, IOException {

		corsistaBC = new CorsistaBC();
		corsistaBC.createOrUpdate(corsista);
	}

	public Date getInizioUltimoCorso() throws ClassNotFoundException, SQLException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.getUltimoCorso();

	}

	public double getDurataMediaCorsi() throws ClassNotFoundException, SQLException, IOException {

		double totale = 0;
		Corso[] corsi = getCorsi();
		Calendar inizio = Calendar.getInstance();
		Calendar fine = Calendar.getInstance();

		for (Corso corso : corsi) {
			inizio.setTime(corso.getInizioCorso());
			fine.setTime(corso.getFineCorso());
			do {
				if (inizio.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY
						&& inizio.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY)
					totale++;
				inizio.add(Calendar.DAY_OF_MONTH, 1);
			} while (inizio.get(Calendar.DAY_OF_YEAR) < fine.get(Calendar.DAY_OF_YEAR)
					|| inizio.get(Calendar.YEAR) < fine.get(Calendar.YEAR));
		}

		return (double) totale / corsi.length;
	}

	public int getNumCorsisti() throws ClassNotFoundException, IOException, SQLException {
		corsistaBC = new CorsistaBC();
		return corsistaBC.getNumeroCorsisti();

	}

	public void deleteCorso(long id) throws ClassNotFoundException, SQLException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.delete(id);
	}

	public Commento[] getCommenti() throws ClassNotFoundException, SQLException, IOException {
		comBC = new CommentoBC();
		return comBC.getAll();
	}

	public Corso findCorsoById(long id) throws ClassNotFoundException, SQLException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.getById(id);
	}

	public Corsista findCorsistaById(long id) throws ClassNotFoundException, SQLException, IOException {
		corsistaBC = new CorsistaBC();
		return corsistaBC.findById(id);
	}

	public Corso[] getCorsi() throws ClassNotFoundException, SQLException, IOException {
		corsoBC = new CorsoBC();
		return corsoBC.getCorsi();
	}

	public Docente findDocByCod(String cod) throws ClassNotFoundException, IOException, SQLException {
		docenteBC = new DocenteBC();
		return docenteBC.findByCod(cod);
	}

}
