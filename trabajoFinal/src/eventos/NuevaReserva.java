package Eventos;


public class NuevaReserva extends Evento {
	private String eventoQuePuedeManejar;
	
	public NuevaReserva () {
		this.eventoQuePuedeManejar = "NuevaReserva";
	}
	
	@Override
	public boolean puedeManejarEvento(String nombreDeEvento) {
			return (eventoQuePuedeManejar.equals(nombreDeEvento)); 
	}

}
