package trabajoFinal;

import java.time.LocalDate;
import java.util.Observable;

import usuario.Usuario;

//Falta Implementar "EnviarMailDeConfirmacion"
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
	}
	
	public void aceptarReserva() {
		estaConfirmada=true;
	}

	public void enviarMailDeConfirmacion() {
		
		//this.inquilino.enviarMailConfirmando
	}

	public Boolean estaConfirmada() {
		return estaConfirmada;
	}
	
	public LocalDate tiempoCheckInReservas() {
		return this.publicacion.getHorarioCheckIn();
	}
	
	public Usuario obtenerInquilino() {
		return inquilino;
	}
	
	public Usuario obtenerPropietario() {
		return this.publicacion.obtenerPropietario();
	}

	public String ciudadReserva() {
		return this.publicacion.getCiudad();
	}

}