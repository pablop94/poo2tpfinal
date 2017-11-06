package filtros;

import trabajoFinal.Publicacion;

public class FiltroPorCiudad extends FiltroSimple{

	private String valor;

	public FiltroPorCiudad(String ciudad) {
		valor = ciudad;
	}

	@Override
	protected Boolean coincide(Publicacion publicacion) {
		return this.valor.equals(publicacion.getCiudad());
	}
	
}
