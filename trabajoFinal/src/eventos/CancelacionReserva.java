package Eventos;

public class CancelacionReserva extends Evento {
	private String eventoQuePuedeManejar;
	
	public CancelacionReserva () {
		this.eventoQuePuedeManejar = "CancelacionReserva";
	}
	
	@Override
	public boolean puedeManejarEvento(String nombreDeEvento) {
			return (eventoQuePuedeManejar.equals(nombreDeEvento)); 
	}

}
