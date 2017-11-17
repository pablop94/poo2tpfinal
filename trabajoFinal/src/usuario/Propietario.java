package usuario;

import java.util.List;
import java.util.stream.Collectors;
import trabajoFinal.Reserva;

public class Propietario extends Rol {

	@Override
	public String tipoDeRanking() {
		return "propietario";
	}

	@Override
	public List<Reserva> obtenerReservasDe(Usuario usuario) {
		return usuario.obtenerTodasLasReservas().stream()
				.filter((reserva) -> reserva.obtenerPropietario().equals(usuario))
				.collect(Collectors.toList());
	}

}
