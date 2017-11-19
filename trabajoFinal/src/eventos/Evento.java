package Eventos;

import java.util.Observable;
import java.util.Observer;

public abstract class Evento extends Observable {
	public void agregarSuscriptor(Observer o, String nombreDeEvento) {
		if(puedeManejarEvento(nombreDeEvento)) {
			this.addObserver(o);
		}
	}
	
	public void borrarSuscriptor(Observer o, String nombreDeEvento) {
		if(puedeManejarEvento(nombreDeEvento)) {
			this.deleteObserver(o);
		}
	}
	
	public abstract boolean puedeManejarEvento(String nombreDeEvento);

}
