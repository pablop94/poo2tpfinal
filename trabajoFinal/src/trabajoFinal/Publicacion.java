package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {

	private Inmueble inmueble;
	private LocalDate horarioCheckIn; 
	private LocalDate horarioCheckOut;
	private List<String> formasDePago;
	private Precio precio;
	

	public String getCiudad() {
		return this.getInmueble().getCiudad();
	}

	private Inmueble getInmueble() {
		return inmueble;
	}
	
	public LocalDate getHorarioCheckOut() {
		return horarioCheckOut;
	}

	public LocalDate getHorarioCheckIn() {
		return horarioCheckIn;
	}
		
	public Publicacion (Inmueble inmu,LocalDate horarioIn,LocalDate horarioOut, Precio precio) {
		this.inmueble=inmu;
		this.horarioCheckIn=horarioIn;
		this.horarioCheckOut=horarioOut;
		this.precio = precio;
		this.formasDePago= new ArrayList<String>();
		formasDePago.add("Efectivo");
	}
	
	public void ingresarAjuste(Ajuste ajuste) {
		this.precio.ingresarAjuste(ajuste);
	}
	
	public Double obtenerPrecioEn(LocalDate fecha) {
		return this.precio.obtenerPrecioEn(fecha);
	}
	
	public void reservar (LocalDate fechaInicial, LocalDate fechaFinal,ArrayList<String> formaDePago,Usuario inquilino) {
		this.inmueble.getPropietario().notificarPorMailIntentoDeReserva(fechaInicial, fechaFinal, formaDePago, inquilino);
		
	}

	public Integer obtenerCantidadDeHuespedes() {
		return this.getInmueble().getCapacidad();
	}

	public List<String> formasDePago() {
		return this.formasDePago;
	}


}
