package it.betacom.businesscomponent.model;

public class Commento {
private long IdCommento;
private long CodCorso;
private long CodCorsista;
private String Descrizione;
public long getIdCommento() {
	return IdCommento;
}
public void setIdCommento(long idCommento) {
	IdCommento = idCommento;
}
public long getCodCorso() {
	return CodCorso;
}
public void setCodCorso(long codCorso) {
	CodCorso = codCorso;
}
public long getCodCorsista() {
	return CodCorsista;
}
public void setCodCorsista(long codCorsista) {
	CodCorsista = codCorsista;
}
public String getDescrizione() {
	return Descrizione;
}
public void setDescrizione(String descrizione) {
	Descrizione = descrizione;
}
@Override
public String toString() {
	return "Commento [IdCommento=" + IdCommento + ", CodCorso=" + CodCorso + ", CodCorsista=" + CodCorsista
			+ ", Descrizione=" + Descrizione + "]";
}

}
