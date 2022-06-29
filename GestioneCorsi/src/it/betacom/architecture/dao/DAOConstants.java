package it.betacom.architecture.dao;

public interface DAOConstants {

	String SELECT_CORSO = "select * from CORSO";

	String SELECT_CORSISTA = "select * from CORSISTA";

	String SELECT_DOCENTE = "select * from DOCENTE";

	String SELECT_CORSO_CORSISTA = "select * from CORSO_CORSISTA";

	String SELECT_COMMENTO = "select * from COMMENTO";

	String SELECT_REPORT_ISCRIZIONI = "select * from REPORT_ISCRIZIONI";
	
	String PASSWORD_AMMINISTRATORE = "select password from AMMINISTRATORE where cod_amministratore = ?";

	
	
}
