package usuario;

import java.util.List;
import java.util.stream.Collectors;

import trabajoFinal.Ranking;
import trabajoFinal.Reserva;

public abstract class Rol {
	public abstract String tipoDeRanking();
	public abstract List<Ranking> obtenerRankingsDe(Usuario usuario);
	public abstract List<Reserva> obtenerReservasDe(Usuario usuario);
	
	public List<Reserva> obtenerAlquileresDe(Usuario usuario){
		return this.obtenerReservasDe(usuario).stream()
				.filter((reserva) -> reserva.estaConfirmada())
				.collect(Collectors.toList());
	}
}

	

