package Eventos;

public class CambioDePrecio extends Evento {
	private String eventoQuePuedeManejar;
	
	public CambioDePrecio () {
		this.eventoQuePuedeManejar = "CambioDePrecio";
	}
	
	@Override
	public boolean puedeManejarEvento(String nombreDeEvento) {
			return (eventoQuePuedeManejar.equals(nombreDeEvento)); 
	}

}