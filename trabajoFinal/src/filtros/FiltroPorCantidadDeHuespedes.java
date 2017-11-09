package filtros;

import trabajoFinal.Publicacion;

public class FiltroPorCantidadDeHuespedes extends FiltroSimple {

	private Integer valor;

	public FiltroPorCantidadDeHuespedes(Integer huespedes) {
		valor = huespedes;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return valor <= publicacion.obtenerCantidadDeHuespedes();
	}

}
