package it.betacom.BC.model;

public class Corsista {
	private long codCorsista;
	private String nome;
	private String cognome;
	private String precedentiFormativi;

	public long getCodCorsista() {
		return codCorsista;
	}

	public void setCodCorsista(long codCorsista) {
		this.codCorsista = codCorsista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPrecedentiFormativi() {
		return precedentiFormativi;
	}

	public void setPrecedentiFormativi(String precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}

	@Override
	public String toString() {
		return "Corsista [CodCorsista=" + codCorsista + ", nome=" + nome + ", cognome=" + cognome
				+ ", PrecedentiFormativi=" + precedentiFormativi + "]";
	}

}
