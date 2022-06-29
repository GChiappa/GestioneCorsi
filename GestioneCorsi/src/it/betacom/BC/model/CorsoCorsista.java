package it.betacom.BC.model;

public class CorsoCorsista {
	private String CodCorsoCorsista;
	private long CodCorso;
	private long CodCorsista;
	public String getCodCorsoCorsista() {
		return CodCorsoCorsista;
	}
	public void setCodCorsoCorsista(String codCorsoCorsista) {
		CodCorsoCorsista = codCorsoCorsista;
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
	@Override
	public String toString() {
		return "CorsoCorsista [CodCorsoCorsista=" + CodCorsoCorsista + ", CodCorso=" + CodCorso + ", CodCorsista="
				+ CodCorsista + "]";
	}
	
	
	
}
