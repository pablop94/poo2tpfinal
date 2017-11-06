package filtros;

import java.util.List;
import java.util.stream.Collectors;

import trabajoFinal.Publicacion;

public abstract class FiltroSimple extends Filtro{

	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		return publicaciones.stream()
				.filter((publicacion) -> this.coincide(publicacion)).collect(Collectors.toList());
	}

	protected abstract Boolean coincide(Publicacion publicacion);
}
