package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;



public class PublicacionesTest {
	private Publicacion pub;
	private IUsuario user;
	private Precio precio;
	private Inmueble inmu;
	
	@Before
	public void setUp(){
		user = mock(IUsuario.class);
		precio = mock(Precio.class);
		inmu =mock(Inmueble.class);
		pub = new Publicacion(inmu,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
	}
	@Test
	public void testIngresarAjuste() {
		pub.ingresarAjuste(LocalDate.of(2017, 3, 20), LocalDate.of(2017, 4, 20), 500.0);
		verify(precio, times(1)).ingresarAjuste(new Ajuste(LocalDate.of(2017, 3, 20),LocalDate.of(2017, 4, 20),500.0));
	}
	
	@Test
	public void testReservar() {
	
	}

}


