package trabajoFinal;

public class Puntuacion {

	private String _categoria;
	private Double _puntaje;
	private String _comentario;

	public Puntuacion(String categoria, Double puntaje, String comentario) {
		_categoria = categoria;
		_puntaje = puntaje;
		_comentario = comentario;
	}

	public String obtenerCategoria() {
		return _categoria;
	}

	public Double obtenerPuntaje() {
		return _puntaje;
	}

	public String obtenerComentario() {
		return _comentario;
	}

}
