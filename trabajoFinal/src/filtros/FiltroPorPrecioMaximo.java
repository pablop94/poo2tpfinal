package filtros;

import java.time.LocalDate;

import trabajoFinal.Publicacion;

public class FiltroPorPrecioMaximo extends FiltroSimple {

	private Double valor;
	private LocalDate fecha;
	
	public FiltroPorPrecioMaximo(Double precio, LocalDate fechaFiltro) {
		valor = precio;
		fecha = fechaFiltro;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return valor >= publicacion.obtenerPrecioEn(fecha);
	}

}
