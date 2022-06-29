package it.betacom.BC.model;

public class Corsista {
private long CodCorsista;
private String nome;
private String congnome;
private String PrecedentiFormativi;
public long getCodCorsista() {
	return CodCorsista;
}
public void setCodCorsista(long codCorsista) {
	CodCorsista = codCorsista;
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
public String getPrecedentiFormativi() {
	return PrecedentiFormativi;
}
public void setPrecedentiFormativi(String precedentiFormativi) {
	PrecedentiFormativi = precedentiFormativi;
}
@Override
public String toString() {
	return "Corsista [CodCorsista=" + CodCorsista + ", nome=" + nome + ", congnome=" + congnome
			+ ", PrecedentiFormativi=" + PrecedentiFormativi + "]";
}

}
