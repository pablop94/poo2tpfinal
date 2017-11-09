package trabajoFinal;

public class Inmueble {
	private Usuario propietario;
	private String direccion;
	private String servicios;
	private String tipoDeInmueble;
	private String pais;
	private String ciudad;
	private Double superficie;
	private String fotos;
	private Integer capacidad;
	
	public Usuario getUser() {
		return(this.propietario);
	}
	
	public String getDireccion() {
		return(this.direccion);
	}
	
	public String getServicios() {
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


