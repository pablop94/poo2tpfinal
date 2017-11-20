package externo;

import java.util.Observable;
import java.util.Observer;
import interfaces.PopUpWindow;
import trabajoFinal.Reserva;

public class AppMovil implements Observer{

	private PopUpWindow popUpWindow;

	public AppMovil(PopUpWindow window) {
		this.popUpWindow = window;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		Reserva reserva = (Reserva) arg0;
		if (arg1.toString().equals("Cancelacion")){
			this.popUpWindow.popUp("El/la " + reserva.tipoDeInmueble() + " que te interesa se ha liberado! Corre a reservarlo!", "rojo", 13);
		}
	}

}
