package trabajoFinal;

import java.util.ArrayList;
import java.util.List;

public class Inmueble {
	private Usuario propietario;
	private String direccion;
	private List<String> servicios;
	private String tipoDeInmueble;
	private String pais;
	private String ciudad;
	private Double superficie;
	private String fotos;
	private Integer capacidad;
	
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
	}

	public Usuario getUsuario() {
		return(this.propietario);
	}
	
	public String getDireccion() {
		return(this.direccion);
	}
	
	public List<String> getServicios() {
		return(this.servicios);
	}
	
	public String getTipoDeInmueble() {
		return(this.tipoDeInmueble);
	}
	
	public String getPais() {
		return(this.pais);
	}
	
	public String getCiudad() {
		return(this.ciudad);
	}
	
	public Double getSuperficie() {
		return(this.superficie);
	}

	public String getFotos() {
		return(this.fotos);
	}
	
	public Integer getCapacidad() {
		return(this.capacidad);
	}
}


