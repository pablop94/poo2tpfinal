package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;



public class PublicacionesTest {
	private Publicaciones pub;
	private IUsuario user;
	private Precio precio;
	private Inmueble inmu;
	
	@Before
	public void setUp(){
		user = mock(IUsuario.class);
		precio = mock(Precio.class);
		inmu =mock(Inmueble.class);
		pub = new Publicaciones(inmu,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
	}
	@Test
	public void testIngresarAjuste() {
		pub.ingresarAjustes(LocalDate.of(2017, 3, 20), LocalDate.of(2017, 4, 20), precio);
		verify(precio, times(1)).ingresarAjuste(LocalDate.of(2017, 3, 20),LocalDate.of(2017, 4, 20),precio.obtenerPrecioBase());
	}
	
	@Test
	public void testReservar() {
		pub.
	}

}


