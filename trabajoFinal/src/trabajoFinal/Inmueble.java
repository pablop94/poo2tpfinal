package trabajoFinal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import usuario.Usuario;

public class Inmueble implements IRankeable{
	private Usuario propietario;
	private String direccion;
	private List<String> servicios;
	private String tipoDeInmueble;
	private String pais;
	private String ciudad;
	private Double superficie;
	private String fotos;
	private Integer capacidad;
	private List<Ranking> rankings;
	
	public Inmueble(Usuario usuario, String direccion, List<String> servicios2, String tipoInmueble, String pais,
			String ciudad2, Double superficieEnM2, String foto, Integer cantidadHuespedes) {
		this.propietario = usuario;
		this.direccion = direccion;
		this.servicios = servicios2;
		this.tipoDeInmueble = tipoInmueble;
		this.pais = pais;
		this.ciudad = ciudad2;
		this.superficie = superficieEnM2;
		this.fotos = foto;
		this.capacidad = cantidadHuespedes;
		this.rankings = new ArrayList<>();
	}

	public Usuario obtenerPropietario() {
		return(this.propietario);
	}
	
	public String obtenerDireccion() {
		return(this.direccion);
	}
	
	public List<String> obtenerServicios() {
		return(this.servicios);
	}
	
	public String obtenerTipoDeInmueble() {
		return(this.tipoDeInmueble);
	}
	
	public String obtenerPais() {
		return(this.pais);
	}
	
	public String obtenerCiudad() {
		return(this.ciudad);
	}
	
	public Double obtenerSuperficie() {
		return(this.superficie);
	}

	public String obtenerFotos() {
		return(this.fotos);
	}
	
	public Integer obtenerCapacidad() {
		return(this.capacidad);
	}

	@Override
	public void agregarRanking(Ranking ranking) {
		this.rankings.add(ranking);
	}

	@Override
	public Double obtenerPuntajePromedio() {
		return obtenerPuntajePromedioDeRankings(this.obtenerRankings());
	}

	@Override
	public Double obtenerPuntajePromedioPorCategoria(String categoria) {
		return obtenerPuntajePromedioDeRankings(
				this.obtenerRankings().stream().filter((ranking) -> ranking.obtenerCategoria().equals(categoria)).collect(Collectors.toList()));
	}

	@Override
	public List<Ranking> obtenerRankings() {
		return this.rankings;
	}
	
	private Double obtenerPuntajePromedioDeRankings(List<Ranking> listaDeRankings){
		if (listaDeRankings.size() == 0){
			return new Double(0);
		}
		return listaDeRankings.stream().mapToDouble((ranking) -> ranking.obtenerPuntaje()).sum() / listaDeRankings.size();
	}

	@Override
	public String tipoDeRanking() {
		return "inmueble";
	}
}


