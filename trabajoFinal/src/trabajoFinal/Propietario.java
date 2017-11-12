package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propietario extends Rol {

	@Override
	public void rankear(Ranking rank, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reservar(Publicacion p, LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<String> formaDePago,
			Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarReservaPropietario(Reserva reserva, Usuario usuario) {
		usuario.agregarReservaDelPropietario(reserva);
		
	}

	@Override
	public boolean esInquilino() {
		return false;
	};

}
