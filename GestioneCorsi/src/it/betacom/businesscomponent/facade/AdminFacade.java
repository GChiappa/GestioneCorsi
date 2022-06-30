package it.betacom.businesscomponent.facade;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import it.betacom.businesscomponent.CommentoBC;
import it.betacom.businesscomponent.CorsistaBC;
import it.betacom.businesscomponent.CorsoBC;
import it.betacom.businesscomponent.CorsoCorsistaBC;
import it.betacom.businesscomponent.DocenteBC;
import it.betacom.businesscomponent.model.Corsista;

public class AdminFacade {

	private static AdminFacade cF;
	private static CorsoBC corsoBC;
	private static CorsoCorsistaBC ccBC;
	private static CorsistaBC corsistaBC;
	private static DocenteBC docenteBC;
	private static CommentoBC cBC;

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

	public double getDurataMediaCorsi() {
		// TODO getDurataMediaCorsi
		return 0;
	}

	public int getNumCorsisti() throws ClassNotFoundException, IOException, SQLException {
		corsistaBC = new CorsistaBC();
		return corsistaBC.getNumeroCorsisti();
		 
	}

	public void deleteCorso(long id) throws ClassNotFoundException, SQLException, IOException {
		corsoBC = new CorsoBC();
		corsoBC.delete(id);
	}
}
