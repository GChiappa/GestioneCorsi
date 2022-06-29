package it.betacom.BC.model;

public class Docente {
private String CodDocente;
private String nome;
private String congnome;
private String cv;
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
public String getCongnome() {
	return congnome;
}
public void setCongnome(String congnome) {
	this.congnome = congnome;
}
public String getCv() {
	return cv;
}
public void setCv(String cv) {
	this.cv = cv;
}
@Override
public String toString() {
	return "Docente [CodDocente=" + CodDocente + ", nome=" + nome + ", congnome=" + congnome + ", cv=" + cv + "]";
}




}
