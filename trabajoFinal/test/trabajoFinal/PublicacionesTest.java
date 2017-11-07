package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class PublicacionesTest {
	private Publicacion pub;
	private Usuario user;
	private Precio precio;
	private Ajuste ajuste;
	private Inmueble inmu;
	
	@Before
	public void setUp(){
		user = mock(Usuario.class);
		precio = mock(Precio.class);
		inmu = mock(Inmueble.class);
		ajuste = mock(Ajuste.class);
		pub = new Publicacion(inmu,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
	}
	@Test
	public void testIngresarAjuste() {
		pub.ingresarAjuste(ajuste);
		verify(precio, times(1)).ingresarAjuste(ajuste);
	}
	
	@Test
	public void testReservar() {
	
	}

}


