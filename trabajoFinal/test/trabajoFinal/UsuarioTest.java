package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UsuarioTest {

	private Usuario user1;
	private Inquilino inq1;
	private Inmueble inmu;
	
	@Before
	public void setUp(){
		inq1 = mock(Inquilino.class);
		user1 = new Usuario("Tobias", "mail1", "42424", inq1);
		inmu = mock(Inmueble.class);
		pub = new Publicacion(inmu,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
		formaDePago = new ArrayList<String>();
		formaDePago.add("Hola");
	}
	
	
	@Test
	public void testAgregarPublicacion() {

	}
		
	
	@Test
	public void testAgregarInmueble() {
		user1.agregarInmueble(inmu);
		fail("Not yet implemented");
	}

	@Test
	public void testagregarRankingInquilino() {
		fail("Not yet implemented");
	}

	@Test
	public void testagregarRankingPropietario() {
		fail("Not yet implemented");
	}

	@Test
	public void testcambiarRol() {
		fail("Not yet implemented");
	}

	@Test
	public void testobtenerAntiguedad() {
		fail("Not yet implemented");
	}

	@Test
	public void testobtenerCantidadDeAlquileres() {
		fail("Not yet implemented");
	}

	@Test
	public void testobtenerReservasFuturas() {
		fail("Not yet implemented");
	}

	@Test
	public void testobtenerReservasDeCiudad() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testobtenerReservasPorCiudad() {
		fail("Not yet implemented");
	}


}
