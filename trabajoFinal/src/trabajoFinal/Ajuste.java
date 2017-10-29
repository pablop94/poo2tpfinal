package trabajoFinal;

import java.time.LocalDate;

public class Ajuste {

	private Double _precio;
	private LocalDate _inicio;
	private LocalDate _fin;


	public Ajuste(LocalDate inicio, LocalDate fin, Double precio) {
		_inicio = inicio;
		_fin = fin;
		_precio = precio;
	}

	public Double obtenerPrecio() {
		return _precio;
	}

	public void modificarPrecio(Double nuevoPrecio) {
		_precio = nuevoPrecio;
	}

	public Double obtenerPrecioEn(LocalDate fecha) {
		if (this.contieneFecha(fecha)){
			return _precio;
		}
		return new Double(0);
	}
	
	public Boolean contieneFecha(LocalDate fecha){
		return fecha.equals(_inicio) || fecha.equals(_fin) || (fecha.isAfter(_inicio) && fecha.isBefore(_fin));
	}

	public LocalDate obtenerInicio() {
		return _inicio;
	}

	public LocalDate obtenerFin() {
		return _fin;
	}
}
