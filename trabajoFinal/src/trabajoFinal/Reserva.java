package trabajoFinal;

import java.time.LocalDate;
import java.util.Observable;

import usuario.Usuario;

public class Reserva extends Observable{
	private Publicacion publicacion;
	private Usuario inquilino;
	private String formaDePago;
	private Boolean estaConfirmada;
	
	public Reserva(Publicacion publicacion, Usuario inquilino, String formaDePagar) {
		this.publicacion=publicacion;
		this.inquilino=inquilino;
		this.formaDePago=formaDePagar;
		this.estaConfirmada= false;
		this.obtenerInquilino().agregarReserva(this);
		this.obtenerPropietario().agregarReserva(this);
		this.obtenerPropietario().notificarPorMailIntentoDeReserva(this);
		this.publicacion.notifyObservers("NuevaReserva");
	}
	
	public void aceptar() {
		estaConfirmada=true;
		this.obtenerInquilino().notificarPorMailReservaConfirmada(this);
	}

	public Boolean estaConfirmada() {
		return estaConfirmada;
	}
	
	public LocalDate obtenerhorarioCheckIn() {
		return this.publicacion.obtenerHorarioCheckIn();
	}
	
	public Usuario obtenerInquilino() {
		return inquilino;
	}
	
	public Usuario obtenerPropietario() {
		return this.publicacion.obtenerPropietario();
	}
	
	public String obtenerFormaDePago() {
		return this.formaDePago;
	}

	public String obtenerCiudad() {
		return this.publicacion.obtenerCiudad();
	}

	public void cancelar() {
		this.notifyObservers("Cancelacion");
	}
	
	@Override
	public void notifyObservers(Object arg){
		this.setChanged();
		super.notifyObservers(arg);
	}

	public String tipoDeInmueble() {
		return this.publicacion.tipoDeInmueble();
	}

}