package ar.edu.unlam.pb2.eva03;

import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Nadador extends Deportista implements INadador{

	private String estiloPreferido;
	
	public Nadador(Integer numeroDeSocio, String nombre, String estiloPreferido) {
		super(numeroDeSocio, nombre);
		this.setEstiloPreferido(estiloPreferido);
	}

	public String getEstiloPreferido() {
		return estiloPreferido;
	}

	private void setEstiloPreferido(String estiloPreferido) {
		this.estiloPreferido = estiloPreferido;
	}


}
