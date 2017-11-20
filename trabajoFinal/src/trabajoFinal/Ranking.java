package trabajoFinal;

import interfaces.Rankeable;
import usuario.Usuario;

public class Ranking {

	private Rankeable _entidad;
	private Puntuacion _puntuacion;
	private Usuario _rankeador;
	private String _tipoDeRanking;

	public Ranking(Rankeable entidad, Puntuacion puntuacion, Usuario rankeador) {
		_entidad = entidad;
		_puntuacion = puntuacion;
		_rankeador = rankeador;
		_tipoDeRanking = this.obtenerEntidad().tipoDeRanking();
	}

	public Rankeable obtenerEntidad() {
		return _entidad;
	}

	public Puntuacion obtenerPuntuacion() {
		return _puntuacion;
	}

	public Usuario obtenerRankeador() {
		return _rankeador;
	}

	public Double obtenerPuntaje() {
		return this.obtenerPuntuacion().obtenerPuntaje();
	}

	public String obtenerCategoria() {
		return this.obtenerPuntuacion().obtenerCategoria();
	}
	
	public String tipoDeRanking() {
		return _tipoDeRanking;
	}
}
