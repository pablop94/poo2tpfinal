package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inquilino extends Rol {

	
	
	
@Override
public void rankear(Ranking ranking, Usuario rankeador) {
		rankeador.agregarRanking(ranking);
		                         
}


@Override
public void reservar(Reserva reserva,Usuario usuario) {
	usuario.agregarReserva(reserva);
	}


@Override
public boolean esInquilino() {
	return true;
}

public List<Ranking> rankingInquilino(Usuario inquilino) {
	return inquilino.obtenerRankings().stream().filter(ranking -> ranking.obtenerRankeador().esInquilino()).collect(Collectors.toList());
}

public List<Reserva> reservaInquilino(Usuario inquilino) {
	return inquilino.obtenerAlquileres().stream().filter(reserva -> reserva.getUsuario().esInquilino()).collect(Collectors.toList());
}

}
	