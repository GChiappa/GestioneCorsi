package it.betacom.businesscomponent.utility;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import it.betacom.businesscomponent.facade.AdminFacade;
import it.betacom.businesscomponent.model.Docente;

public class ControlloInUtility {

	public static String checkNomeCorsista(String in) {
		return checkNome(in, "nome", "corsista");
	}

	public static String checkCognomeCorsista(String in) {
		return checkNome(in, "cognome", "corsista");
	}

	public static String checkNomeCorso(String in) {
		return checkNome(in, "nome", "corso");
	}

	public static String checkDataInizioCorso(String in) {
		return checkData(in, "data inizio", "corso");
	}

	public static String checkDataFineCorso(String in) {
		return checkData(in, "data fine", "corso");
	}

	public static String checkCommento(String in) {

		if (in == null)
			return "Il campo del commento non deve essere nullo";
		if (in.equals(""))
			return "Il campo del commento non deve essere nullo";

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9 .,?!()]{0,200}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo del commento deve essere di massimo 200 caratteri";
		}
	}

	public static String checkPrecedentiFormativiCorsista(String in) {

		if (in == null)
			return "Il campo dei precedenti formativi del corsista non deve essere nullo";
		if (in.equals(""))
			return "Il campo dei precedenti formativi del corsista non deve essere nullo";

		Pattern pattern = Pattern.compile("^(SI|NO){1,1}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo dei precedenti formativi del corsista deve essere SI o NO";
		}

	}

	public static String checkAulaCorso(String in) {

		if (in == null)
			return "Il campo aula di corso non deve essere nullo";
		if (in.equals(""))
			return "Il campo aula di corso non deve essere nullo";

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]{2,30}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo aula di corso deve contenere da 2 a 30 lettere (a-z, A-Z, 0-9)";
		}
	}

	public static Docente checkDocente(String cod) throws ClassNotFoundException, IOException, SQLException {
		return AdminFacade.getInstance().findDocByCod(cod);
	}

	private static String checkNome(String in, String campo, String tabella) {

		if (in == null)
			return "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		if (in.equals(""))
			return "Il campo " + campo + " di " + tabella + " non deve essere nullo";

		Pattern pattern = Pattern.compile("^[a-zA-Z]{2,30}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo " + campo + " di " + tabella + " deve contenere da 2 a 30 lettere (a-z, A-Z)";
		}
	}

	private static String checkData(String in, String campo, String tabella) {

		if (in == null)
			return "Il campo " + campo + " di " + tabella + " non deve essere nullo";
		if (in.equals(""))
			return "Il campo " + campo + " di " + tabella + " non deve essere nullo";

		Pattern pattern = Pattern.compile(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo " + campo + " di " + tabella + " deve essere valida e in formato DD/MM/YYYY";
		}
	}

}
