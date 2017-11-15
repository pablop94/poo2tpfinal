package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Rol {
		

public abstract boolean esInquilino();
public abstract void rankear(Ranking ranking, Usuario usuario);
public abstract void reservar(Reserva reserva, Usuario usuario);
}

	

