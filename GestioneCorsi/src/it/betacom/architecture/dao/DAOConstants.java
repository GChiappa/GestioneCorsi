package it.betacom.architecture.dao;

public interface DAOConstants {

	String SELECT_CORSO = "select * from CORSO";
	String DELETE_CORSO = "delete from CORSO where cod_corso = ?";
	String FBYID_CORSO = "select * from CORSO where cod_corso = ?";
	String UPDATE_CORSO = "update CORSO set cod_docente = ?, nome = ?, data_inizio = ?, data_fine = ?, aula = ? where cod_corso = ?";

	String SELECT_CORSO_SEQ = "select CORSO_SEQ.nextval from dual";

	String SELECT_CORSISTA = "select * from CORSISTA";
	String DELETE_CORSISTA = "delete from CORSISTA where cod_corsista = ?";
	String FBYID_CORSISTA = "select * from CORSISTA where cod_corsista = ?";
	String UPDATE_CORSISTA = "update CORSISTA set nome = ?, cognome = ?, precedenti_formativi = ? where cod_corsista = ?";
	String SELECT_NUM_CORSISTI = "select count(cod_corsista) as NCorsisti from corsista";

	String SELECT_CORSISTA_SEQ = "select CORSISTA_SEQ.nextval from dual";

	String SELECT_DOCENTE = "select * from DOCENTE";
	String FBYID_DOCENTE = "select * from DOCENTE where cod_docente = ?";

	String SELECT_CORSO_CORSISTA = "select * from CORSO_CORSISTA";
	String DELETE_CORSO_CORSISTA = "delete from CORSO_CORSISTA where cod_corso_corsista = ?";
	String INIZIO_ULTIMO_CORSO = "select data_inizio from corso where cod_corso=(select max(cod_corso) from corso)";
	String DURATA_MEDIA_CORSI = "SELECT AVG( data_inizio - data_fine) as Media FROM corso;";

	String SELECT_CORSO_CORSISTA_SEQ = "select CORSO_CORSISTA_SEQ.nextval from dual";

	String SELECT_COMMENTO = "select * from COMMENTO";
	String SELECT_COMMENTO_CORSO = "select * from COMMENTO where cod_corso = ?";
	String UPDATE_COMMENTO = "update COMMENTO set CodCorso = ?, CodCorsista = ?, Descrizione = ? WHERE idCommento=?";
	String DELETE_COMMENTO = "delete from COMMENTO where IdCommento = ?";

	String SELECT_COMMENTO_SEQ = "select COMMENTO_SEQ.nextval from dual";

	String SELECT_REPORT_ISCRIZIONI = "select * from REPORT_ISCRIZIONI";

	String PASSWORD_AMMINISTRATORE = "select password from AMMINISTRATORE where cod_amministratore = ?";
	String NOMINATIVO_AMMINISTRATORE = "select nome, cognome from AMMINISTRATORE where cod_amministratore = ?";

	// ReportUtility
	String SELECT_ID_CORSO_PIU_FREQUENTATO = "select cod_corso, count(*) as num from CORSO_CORSISTA group by cod_corso order by num desc";

	String SELECT_DOCENTE_PIU_CORSI = "select cod_docente from CORSO group by cod_docente order by count(*) desc";

	String SELECT_CORSI_DISPONIBILI = "select * from CORSO where cod_corso not in (select cod_corso from CORSO_CORSISTA group by cod_corso)";

	String COUNT_COMMENTI_CORSO = "select count(*) from commento where cod_corso = ?";

	String SELECT_CORSI_DOCENTE = "select * from CORSO where cod_docente = ?";
}
