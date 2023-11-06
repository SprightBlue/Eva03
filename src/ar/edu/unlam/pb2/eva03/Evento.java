package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;

public class Evento {

	private TipoDeEvento tipo;
	private Integer numeroDeInscripcion;
	private Map<Integer, Deportista> participantes;
	
	public Evento(TipoDeEvento tipo) {
		this.setTipo(tipo);
		this.numeroDeInscripcion = 0;
		participantes = new HashMap<Integer, Deportista>();
	}
	
	public TipoDeEvento getTipo() {
		return tipo;
	}
	
	private void setTipo(TipoDeEvento tipo) {
		this.tipo = tipo;
	}

	public Integer getNumeroDeInscripcion() {
		return numeroDeInscripcion;
	}

	private void setNumeroDeInscripcion() {
		this.numeroDeInscripcion++;
	}

	public Map<Integer, Deportista> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(Deportista participante) {
		this.setNumeroDeInscripcion();
		this.participantes.put(this.numeroDeInscripcion, participante);
	}
	
}
