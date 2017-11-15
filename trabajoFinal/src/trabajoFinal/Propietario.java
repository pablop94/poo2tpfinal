package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propietario extends Rol {

	

	@Override
	public boolean esInquilino() {
		return false;
	}

	@Override
	public void rankear(Ranking ranking, Usuario usuario) {
		usuario.agregarRanking(ranking);
		
	}

	@Override
	public void reservar(Reserva reserva, Usuario usuario) {
		usuario.agregarReserva(reserva);
		
	};

}
