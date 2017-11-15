package trabajoFinal;

import java.time.LocalDate;
import java.util.Observable;

//Falta Implementar "EnviarMailDeConfirmacion"
public class Reserva extends Observable{
	private Publicacion publicacion;
	private Usuario inquilino;
	private String formaDePago;
	private Boolean estaConfirmada;
	
	public Reserva(Publicacion pub, Usuario user, String formaDePagar) {
		this.publicacion=pub;
		this.inquilino=user;
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
	
	public Usuario getUsuario() {
		return(inquilino);
	}

	public String ciudadReserva() {
		return this.publicacion.getCiudad();
	}

}