package it.betacom.architecture.dao;

public interface DAOConstants {

	String SELECT_CORSO = "select * from CORSO";
	String DELETE_CORSO = "delete from CORSO where cod_corso = ?";
	String FBYID_CORSO = "select * from CORSO where cod_corso = ?";
	String UPDATE_CORSO = "update CORSO set cod_docente = ?, nome = ?, data_inizio = ?, data_fine = ?, aula = ? where cod_corso = ?";

	String SELECT_CORSISTA = "select * from CORSISTA";
	String DELETE_CORSISTA = "delete from CORSISTA where cod_corsista = ?";
	String FBYID_CORSISTA = "select * from CORSISTA where cod_corso = ?";
	String UPDATE_CORSISTA = "update CORSISTA set nome = ?, cognome = ?, precedenti_formativi = ? where cod_corsista = ?";

	String SELECT_DOCENTE = "select * from DOCENTE";
	String FBYID_DOCENTE = "select * from DOCENTE where cod_docente = ?";

	String SELECT_CORSO_CORSISTA = "select * from CORSO_CORSISTA";
	String DELETE_CORSO_CORSISTA = "delete from CORSO_CORSISTA where cod_corso_corsista = ?";

	String SELECT_COMMENTO = "select * from COMMENTO";
	String SELECT_COMMENTO_CORSO = "select * from COMMENTO where cod_corso = ?";

	String SELECT_REPORT_ISCRIZIONI = "select * from REPORT_ISCRIZIONI";

	String PASSWORD_AMMINISTRATORE = "select password from AMMINISTRATORE where cod_amministratore = ?";
}
