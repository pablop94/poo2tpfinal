package filtros;

import java.util.List;
import java.util.stream.Collectors;

import trabajoFinal.Publicacion;

public class FiltroOR extends FiltroCompuesto {

	public FiltroOR(Filtro filtro1, Filtro filtro2) {
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}

	@Override
	public List<Publicacion> filtrar(List<Publicacion> publicaciones) {
		List<Publicacion> resultado = this.filtro1.filtrar(publicaciones);
		resultado.addAll(this.filtro2.filtrar(publicaciones));
		return resultado.stream().distinct().collect(Collectors.toList());				
	}

}
