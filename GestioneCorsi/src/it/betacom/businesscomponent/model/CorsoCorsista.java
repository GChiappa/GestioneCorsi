package it.betacom.businesscomponent.model;

public class CorsoCorsista {
	private long CodCorsoCorsista;
	private long CodCorso;
	private long CodCorsista;
	public long getCodCorsoCorsista() {
		return CodCorsoCorsista;
	}
	public void setCodCorsoCorsista(long codCorsoCorsista) {
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
