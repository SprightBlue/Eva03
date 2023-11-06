package ar.edu.unlam.pb2.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import ar.edu.unlam.pb2.eva03.enumeradores.TipoDeEvento;
import ar.edu.unlam.pb2.eva03.interfaces.ICiclista;
import ar.edu.unlam.pb2.eva03.interfaces.ICorredor;
import ar.edu.unlam.pb2.eva03.interfaces.INadador;

public class Club {

	private String nombre;
	private Set<Deportista> socios;
	private Map<String, Evento> competencias;
	
	public Club(String nombre) {
		this.setNombre(nombre);
		socios = new HashSet<Deportista>();
		competencias = new HashMap<String, Evento>();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarDeportista(Deportista deportista) {
		if(!this.socios.contains(deportista)) {
			this.socios.add(deportista);
		}
	}

	public Integer getCantidadSocios() {
		return this.socios.size();
	}

	public void crearEvento(TipoDeEvento tipoDeEvento, String nombre) {
		if(!this.competencias.containsKey(nombre)) {
			this.competencias.put(nombre, new Evento(tipoDeEvento));
		}
	}

	public Integer inscribirEnEvento(String nombreEvento, Deportista deportista) throws NoEstaPreparado{
		Evento eventoBuscado = this.competencias.get(nombreEvento);
		Integer numeroDeInscripcion = 0;
		switch(eventoBuscado.getTipo()) {
		case CARRERA_10K:
		case CARRERA_21K:
		case CARRERA_42K:
		case CARRERA_5K:
			if(deportista instanceof ICorredor || deportista instanceof ICiclista) {
				eventoBuscado.setParticipantes(deportista);
				numeroDeInscripcion = eventoBuscado.getNumeroDeInscripcion();
			}else {
				throw new NoEstaPreparado();
			}
			break;
		case CARRERA_NATACION_EN_AGUAS_ABIERTAS:
		case CARRERA_NATACION_EN_PICINA:
			if(deportista instanceof INadador) {
				eventoBuscado.setParticipantes(deportista);
				numeroDeInscripcion = eventoBuscado.getNumeroDeInscripcion();
			}else {
				throw new NoEstaPreparado();
			}
			break;
		case DUATLON:
		case TRIATLON_IRONMAN:
		case TRIATLON_MEDIO:
		case TRIATLON_OLIMPICO:
		case TRIATLON_SHORT:
			if(deportista instanceof Triatleta) {
				eventoBuscado.setParticipantes(deportista);
				numeroDeInscripcion = eventoBuscado.getNumeroDeInscripcion();
			}else {
				throw new NoEstaPreparado();
			}
		}
		return numeroDeInscripcion;
	}
	
}
