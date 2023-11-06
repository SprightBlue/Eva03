package ar.edu.unlam.pb2.eva03;

import java.util.Objects;

public abstract class Deportista {

	protected Integer numeroDeSocio;
	protected String nombre;

	public Deportista(Integer numeroDeSocio, String nombre) {
		this.setNumeroDeSocio(numeroDeSocio);
		this.setNombre(nombre);
	}

	public Integer getNumeroDeSocio() {
		return numeroDeSocio;
	}

	protected void setNumeroDeSocio(Integer numeroDeSocio) {
		this.numeroDeSocio = numeroDeSocio;
	}

	public String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(numeroDeSocio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Deportista other = (Deportista) obj;
		return Objects.equals(numeroDeSocio, other.numeroDeSocio);
	}
	
}
