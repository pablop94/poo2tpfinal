package usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import trabajoFinal.Ranking;
import trabajoFinal.Reserva;

public class Inquilino extends Rol {
	
	@Override
	public String tipoDeRanking(){
		return "inquilino";
	}

	@Override
	public List<Ranking> obtenerRankingsDe(Usuario usuario) {
		return usuario.obtenerTodosLosRankings().stream()
				.filter((ranking) -> ranking.tipoDeRanking().equals(this.tipoDeRanking()))
				.collect(Collectors.toList());
	}

	@Override
	public List<Reserva> obtenerReservasDe(Usuario usuario) {
		return usuario.obtenerTodasLasReservas().stream()
				.filter((reserva) -> reserva.obtenerInquilino().equals(usuario))
				.collect(Collectors.toList());
	}


}
	