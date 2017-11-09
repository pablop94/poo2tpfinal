package filtros;

import java.util.List;
import java.util.stream.Collectors;

import trabajoFinal.Publicacion;

public class FiltroAND extends FiltroCompuesto{

	public FiltroAND(Filtro filtro1, Filtro filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		return this.filtro1.filtrar(publicaciones)
				.stream().filter((publicacion) -> 
										this.filtro2.filtrar(publicaciones).contains(publicacion))
										.collect(Collectors.toList());
	}
}
