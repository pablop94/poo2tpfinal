package filtros;

import java.time.LocalDate;

import trabajoFinal.Publicacion;

public class FiltroPorFechaDeEntrada extends FiltroSimple {

	private LocalDate valor;

	public FiltroPorFechaDeEntrada(LocalDate fecha) {
		valor = fecha;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return this.valor.equals(publicacion.getFechaDeEntrada());
	}

}
