package filtros;

import java.time.LocalDate;

import trabajoFinal.*;

public class FiltroPorPrecioMinimo extends FiltroSimple {

	private Double valor;
	private LocalDate fecha;

	public FiltroPorPrecioMinimo(Double precio, LocalDate fechaFiltro) {
		valor = precio;
		fecha = fechaFiltro;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return valor <= publicacion.obtenerPrecioEn(fecha);
	}

}
