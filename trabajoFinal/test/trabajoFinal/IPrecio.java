package trabajoFinal;

import java.time.LocalDate;

public interface IPrecio {
	public void  ingresarAjuste(LocalDate fechaInicial,LocalDate fechaFinal,Precio precio);
	public Double obtenerPrecioBase();
	public Double  obtenerPrecioEn(String fecha);
}
