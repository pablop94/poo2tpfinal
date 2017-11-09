package filtros;

import java.time.LocalDate;

import trabajoFinal.Publicacion;

public class FiltroPorHorarioCheckOut extends FiltroSimple {

	private LocalDate valor;

	public FiltroPorHorarioCheckOut(LocalDate horarioCheckout) {
		valor = horarioCheckout;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return this.valor.equals(publicacion.getHorarioCheckOut());
	}

}
