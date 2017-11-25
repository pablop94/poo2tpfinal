package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import usuario.Usuario;

public class Publicacion extends Observable{

	private Inmueble inmueble;
	private LocalDate horarioCheckIn; 
	private LocalDate horarioCheckOut;
	private List<String> formasDePago;
	private Precio precio;
	

	public String obtenerCiudad() {
		return this.obtenerInmueble().obtenerCiudad();
	}

	private Inmueble obtenerInmueble() {
		return inmueble;
	}
	
	public LocalDate obtenerHorarioCheckOut() {
		return horarioCheckOut;
	}

	public LocalDate obtenerHorarioCheckIn() {
		return horarioCheckIn;
	}
		
	public Publicacion (Inmueble inmu,LocalDate horarioIn,LocalDate horarioOut, Precio precio) {
		this.inmueble=inmu;
		this.horarioCheckIn=horarioIn;
		this.horarioCheckOut=horarioOut;
		this.precio = precio;
		this.formasDePago= new ArrayList<String>();
		formasDePago.add("Efectivo");
		this.obtenerPropietario().agregarPublicacion(this);
	}
	
	public void ingresarAjuste(Ajuste ajuste) {
		this.precio.ingresarAjuste(ajuste);
	}
	
	public Double obtenerPrecioEn(LocalDate fecha) {
		return this.precio.obtenerPrecioEn(fecha);
	}

	public Integer obtenerCantidadDeHuespedes() {
		return this.obtenerInmueble().obtenerCapacidad();
	}

	public List<String> formasDePago() {
		return this.formasDePago;
	}

	public void modificarPrecio(Double nuevoPrecio) {
		Double precioAnterior = precio.obtenerPrecioBase();
		this.precio.modificarPrecioBase(nuevoPrecio);
		if (precioAnterior > nuevoPrecio) {
			this.setChanged();
			this.notifyObservers("CambioDePrecio");
		}
	}

	public Usuario obtenerPropietario() {
		return this.obtenerInmueble().obtenerPropietario();
	}

	public String tipoDeInmueble() {
		return this.obtenerInmueble().obtenerTipoDeInmueble();
	}
	
	public void reservar(){
		this.setChanged();
		this.notifyObservers("NuevaReserva");
	}
}
