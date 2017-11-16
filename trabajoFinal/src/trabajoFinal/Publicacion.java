package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

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
	}
	
	public void ingresarAjuste(Ajuste ajuste) {
		this.precio.ingresarAjuste(ajuste);
	}
	
	public Double obtenerPrecioEn(LocalDate fecha) {
		return this.precio.obtenerPrecioEn(fecha);
	}
	
	public void reservar (LocalDate fechaInicial, LocalDate fechaFinal,ArrayList<String> formaDePago,Usuario inquilino) {
		this.inmueble.obtenerPropietario().notificarPorMailIntentoDeReserva(fechaInicial, fechaFinal, formaDePago, inquilino);
		
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
			this.notifyObservers();
		}
	}

	public Usuario obtenerPropietario() {
		return this.obtenerInmueble().obtenerPropietario();
	}
}
