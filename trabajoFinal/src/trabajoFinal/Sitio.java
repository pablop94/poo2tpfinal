package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

import filtros.Filtro;
import interfaces.MailServer;
import usuario.Usuario;

public class Sitio {

	private List<String> _servicios;
	private List<String> _tiposDeInmueble;
	private List<String> _categoriasDeRankeo;
	private List<Usuario> _usuarios;
	private MailServer mailServer;
	private static Sitio instance;
	
	public Sitio(MailServer mailServer){
		this();
		this.mailServer = mailServer;
	}
	
	public Sitio() {
		_servicios = new ArrayList<String>();
		_tiposDeInmueble = new ArrayList<String>();
		_categoriasDeRankeo = new ArrayList<String>();
		_usuarios = new ArrayList<Usuario>();
		instance = this;
	}

	public static Sitio getInstance(){
		if (instance == null){
			instance = new Sitio();
		}
		return instance;
	}
	
	public MailServer getMailServer(){
		return this.mailServer;
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

	public List<Usuario> obtenerUsuarios() {
		return _usuarios;
	}

	public List<Publicacion> buscar(Filtro filtro, List<Publicacion> publicaciones) {
		return filtro.filtrar(publicaciones);
	}

	public void agregarUsuario(Usuario user) {
		_usuarios.add(user);
	}

}
