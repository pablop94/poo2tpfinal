package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;

public class Publicaciones {
	public Inmueble inmueble;
	public LocalDate horarioCheckIn; 
	public LocalDate horarioCheckOut;
	public ArrayList<String> formasDePago;
	public Precio precio;
	
	
		public Publicaciones (Inmueble inmu,LocalDate horarioIn,LocalDate horarioOut,Precio pre) {
			this.inmueble=inmu;
			this.horarioCheckIn=horarioIn;
			this.horarioCheckOut=horarioOut;
			this.formasDePago= new ArrayList<String>();
			formasDePago.add("Efectivo");
			this.precio = pre;
		}
		
		public void ingresarAjustes(LocalDate fechaInicial, LocalDate fechaFinal,Precio precio) {
			
				this.precio.ingresarAjuste(fechaInicial,fechaFinal,precio.obtenerPrecioBase());
			
		}
		public void reservar(LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<String> formaDePago, Usuario inquilino) {
			this.inmueble.getUser().d
		}
}	

