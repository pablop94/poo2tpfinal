package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PublicacionTest {
	private Publicacion pub;
	private Usuario user;
	private Usuario user2;
	private Precio precio;
	private Ajuste ajuste;
	private Inmueble inmu;
	private ArrayList<String> formaDePago;
	@Before
	public void setUp(){
		user = mock(Usuario.class);
		user2 = mock(Usuario.class);
		precio = mock(Precio.class);
		inmu = mock(Inmueble.class);
		ajuste = mock(Ajuste.class);
		pub = new Publicacion(inmu,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
		formaDePago = new ArrayList<String>();
		formaDePago.add("Hola");
	}
	@Test
	public void testIngresarAjuste() {
		pub.ingresarAjuste(ajuste);
		verify(precio, times(1)).ingresarAjuste(ajuste);
	}
	
	@Test
	public void testReservar() {
		pub.reservar(LocalDate.of(2016, 3, 20), LocalDate.of(2015, 3, 20), formaDePago, user2);
		verify((verify(inmu,times(1)).getUser()),times(1)).notificarPorMailIntentoDeReserva(LocalDate.of(2016, 3, 20), LocalDate.of(2015, 3, 20), formaDePago, user2);
		
		
	}

}


