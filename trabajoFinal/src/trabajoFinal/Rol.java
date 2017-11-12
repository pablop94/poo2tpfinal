package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Rol {
		
public abstract void rankear(Ranking rank, Usuario usuario); 
public abstract void reservar(Publicacion p, LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<String> formaDePago, Usuario usuario);
public abstract void agregarReservaPropietario(Reserva reserva, Usuario usuario);
public abstract boolean esInquilino();
}

	

