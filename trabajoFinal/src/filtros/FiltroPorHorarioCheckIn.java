package filtros;

import java.time.LocalDate;

import trabajoFinal.Publicacion;

public class FiltroPorHorarioCheckIn extends FiltroSimple {

	private LocalDate valor;

	public FiltroPorHorarioCheckIn(LocalDate fecha) {
		valor = fecha;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return this.valor.equals(publicacion.getHorarioCheckIn());
	}

}
