package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import filtros.Filtro;
import usuario.Usuario;

public class Sitio {

	private List<String> _servicios;
	private List<String> _tiposDeInmueble;
	private List<String> _categoriasDeRankeo;
	private List<Usuario> _usuarios;
	
	public Sitio(){
		_servicios = new ArrayList<String>();
		_tiposDeInmueble = new ArrayList<String>();
		_categoriasDeRankeo = new ArrayList<String>();
		_usuarios = new ArrayList<Usuario>();
	}

	public List<String> obtenerServicios() {
		return _servicios;
	}

	public void agregarServicio(String servicio) {
		_servicios.add(servicio);		
	}

	public void agregarTipoDeInmueble(String tipoDeInmueble) {
		_tiposDeInmueble.add(tipoDeInmueble);
	}

	public List<String> obtenerTiposDeInmueble() {
		return _tiposDeInmueble;
	}

	public void agregarCategoriaDeRankeo(String categoria) {
		_categoriasDeRankeo.add(categoria);
	}
	
	public List<String> obtenerCategoriasDeRankeo() {
		return _categoriasDeRankeo;
	}

	public List<Usuario> obtenerListadoDeGestion() {
		return _usuarios;
	}

	public List<Publicacion> buscar(Filtro filtro, List<Publicacion> publicaciones) {
		return filtro.filtrar(publicaciones);
	}

	public void agregarUsuario(Usuario user) {
		_usuarios.add(user);
	}

}
