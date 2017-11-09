package trabajoFinal;

//Falta Implementar "EnviarMailDeConfirmacion"
public class Reserva {
	
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

}