package trabajoFinal;

import java.time.LocalDate;

public class Publicacion {

	private String ciudad;
	private LocalDate fechaDeEntrada;;

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
	}

	/*public class Publicaciones {
	private Inmueble inmueble;
	private Double horarioCheckIn; 
	private Double horarioCheckOut;
	private ArrayList<String> formasDePago;
	private Precio precio;
	
	
		public Publicaciones (Inmueble inmu,Double horarioIn,Double horarioOut) {
			this.inmueble=inmu;
			this.horarioCheckIn=horarioIn;
			this.horarioCheckOut=horarioOut;
			this.formasDePago= new ArrayList<String>.add("Efectivo")
		}
		
		public void ingresarAjuste(LocalDate fechaInicial, LocalDate fechaFinal,Precio precio) {
			
				this.precio.ingresarAjuste(fechaInicial,fechaFinal,precio);
			
		}*/
}
