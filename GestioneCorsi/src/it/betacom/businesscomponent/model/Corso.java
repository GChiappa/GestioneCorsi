package it.betacom.businesscomponent.model;

import java.util.Date;

public class Corso {
private long CodCorso;
private String CodDocente;
private String nome;
private Date InizioCorso;
private Date FineCorso;
public long getCodCorso() {
	return CodCorso;
}
public void setCodCorso(long codCorso) {
	CodCorso = codCorso;
}
public String getCodDocente() {
	return CodDocente;
}
public void setCodDocente(String codDocente) {
	CodDocente = codDocente;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public Date getInizioCorso() {
	return InizioCorso;
}
public void setInizioCorso(Date inizioCorso) {
	InizioCorso = inizioCorso;
}
public Date getFineCorso() {
	return FineCorso;
}
public void setFineCorso(Date fineCorso) {
	FineCorso = fineCorso;
}
@Override
public String toString() {
	return "Corso [CodCorso=" + CodCorso + ", CodDocente=" + CodDocente + ", nome=" + nome + ", InizioCorso="
			+ InizioCorso + ", FineCorso=" + FineCorso + "]";
}


}
