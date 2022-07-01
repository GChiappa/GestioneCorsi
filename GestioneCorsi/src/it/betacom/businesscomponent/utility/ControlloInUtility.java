package it.betacom.businesscomponent.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControlloInUtility {

	public static String checkNomeCorsista(String in) {
		if (in == null)
			return "Il campo del nome del corsista non deve essere nullo";
		if (in.equals(""))
			return "Il campo del nome del corsista non deve essere nullo";
		Pattern pattern = Pattern.compile("^[a-zA-Z]{2,30}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo del nome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)";
		}

	}

	public static String checkCognomeCorsista(String in) {
		if (in == null)
			return "Il campo del cognome del corsista non deve essere nullo";
		if (in.equals(""))
			return "Il campo del cognome del corsista non deve essere nullo";
		Pattern pattern = Pattern.compile("^[a-zA-Z]{2,30}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo del cognome del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)";
		}

	}

	public static String checkPrecedentiFormativiCorsista(String in) {
		if (in == null)
			return "Il campo dei precedenti formativi del corsista non deve essere nullo";
		Pattern pattern = Pattern.compile("^(SI|NO){1,1}$");
		Matcher matcher = pattern.matcher(in);

		if (matcher.find()) {
			return null;
		} else {
			return "Il campo dei precedenti formativi del corsista deve contenere da 2 a 30 lettere (a-z, A-Z)";
		}

	}

}
