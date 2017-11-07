package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Publicacion {

	private String ciudad;
	private LocalDate fechaDeEntrada;
	private Inmueble inmueble;
	private LocalDate horarioCheckIn; 
	private LocalDate horarioCheckOut;
	private ArrayList<String> formasDePago;
	private Precio precio;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
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
}
