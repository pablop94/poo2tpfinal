package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observer;

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
	public void test_Constructor() {
		assertEquals(pub.getHorarioCheckIn(), LocalDate.of(2016, 3, 20));
		assertEquals(pub.getHorarioCheckOut(), LocalDate.of(2015, 3, 20));
		assertTrue(pub.formasDePago().contains("Efectivo"));
	}
	
	@Test
	public void testIngresarAjuste() {
		pub.ingresarAjuste(ajuste);
		verify(precio, times(1)).ingresarAjuste(ajuste);
	}
	
	@Test
	public void testReservar_notificaAlInquilinoConUnMail() {
		when(inmu.getPropietario()).thenReturn(user); 
		pub.reservar(LocalDate.of(2016, 3, 20), LocalDate.of(2015, 3, 20), formaDePago, user2);
		
		verify(user, times(1)).notificarPorMailIntentoDeReserva(LocalDate.of(2016, 3, 20), LocalDate.of(2015, 3, 20), formaDePago, user2);
		
	}

	@Test
	public void test_elPrecioDeLaPublicacionEnUnaFechaEsElDeSuPrecio() {
		when(precio.obtenerPrecioEn(LocalDate.of(2016, 3, 20))).thenReturn(new Double(45)); 
		
		assertEquals(pub.obtenerPrecioEn(LocalDate.of(2016, 3, 20)), new Double(45));
	}
	
	@Test
	public void test_laCantidadDeHuespedesDeUnaPublicacionEsLaCantidadDeSuInmueble() {
		when(inmu.getCapacidad()).thenReturn(new Integer(15)); 
		
		assertEquals(pub.obtenerCantidadDeHuespedes(), new Integer(15));
	}
	
	@Test
	public void test_laCiudadDeUnaPublicacionEsLaCiudadDeSuInmueble() {
		when(inmu.getCiudad()).thenReturn("Avellaneda"); 
		
		assertEquals(pub.getCiudad(), "Avellaneda");
	}
	
	@Test
	public void test_elPrecioDeLaPublicacionCambiaElPrecioBaseDelPrecio() {
		pub.modificarPrecio(new Double(50));
		
		verify(precio, times(1)).modificarPrecioBase(new Double(50));
	}
	
	@Test
	public void test_cuandoSeCambiaElPrecioDeLaPublicacionSeLeInformaALosSuscriptores() {
		Observer suscriptor = mock(Observer.class);
		pub.addObserver(suscriptor);
		
		pub.modificarPrecio(new Double(50));

		verify(suscriptor, times(1)).update(pub, null);
	}
}


