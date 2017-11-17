package usuario;

import java.util.List;
import java.util.stream.Collectors;
import trabajoFinal.Reserva;

public class Inquilino extends Rol {
	
	@Override
	public String tipoDeRanking(){
		return "inquilino";
	}

	@Override
	public List<Reserva> obtenerReservasDe(Usuario usuario) {
		return usuario.obtenerTodasLasReservas().stream()
				.filter((reserva) -> reserva.obtenerInquilino().equals(usuario))
				.collect(Collectors.toList());
	}


}
	