package trabajoFinal;

public class Ranking {

	private IRankeable _entidad;
	private Puntuacion _puntuacion;
	private Usuario _rankeador;

	public Ranking(IRankeable entidad, Puntuacion puntuacion, Usuario rankeador) {
		_entidad = entidad;
		_puntuacion = puntuacion;
		_rankeador = rankeador;
	}

	public IRankeable obtenerEntidad() {
		return _entidad;
	}

	public Puntuacion obtenerPuntuacion() {
		return _puntuacion;
	}

	public Usuario obtenerRankeador() {
		return _rankeador;
	}

	public Double obtenerPuntaje() {
		return _puntuacion.obtenerPuntaje();
	}

	public String obtenerCategoria() {
		return _puntuacion.obtenerCategoria();
	}
}
