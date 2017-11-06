package filtros;

import java.util.List;

import trabajoFinal.Publicacion;

public abstract class Filtro {
	public abstract List<Publicacion> filtrar(List<Publicacion> publicaciones);
}
