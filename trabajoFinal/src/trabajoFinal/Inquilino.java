package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inquilino extends Rol {

	
	
	
@Override
public void rankear(Ranking rank, Usuario usuario) {
		usuario.agregarRanking();
		
}

@Override
public void reservar(Publicacion p, LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<String> formaDePago,Usuario usuario) {
		
	usuario.agregarReservaDeInquilino(p.reservar(fechaInicial, fechaFinal, formaDePago, usuario));
		
}

@Override
public void agregarReservaPropietario(Reserva reserva, Usuario usuario) {
		
}

@Override
public boolean esInquilino() {
	return true;
}

}
	