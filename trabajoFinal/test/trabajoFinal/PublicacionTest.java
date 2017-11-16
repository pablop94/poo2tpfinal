package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class PublicacionTest {
	private Publicacion publicacion;
	private Usuario usuario;
	private Usuario usuario2;
	private Precio precio;
	private Ajuste ajuste;
	private Inmueble inmueble;
	private ArrayList<String> formaDePago;
	@Before
	public void setUp(){
		usuario = mock(Usuario.class);
		usuario2 = mock(Usuario.class);
		precio = mock(Precio.class);
		inmueble = mock(Inmueble.class);
		ajuste = mock(Ajuste.class);
		publicacion = new Publicacion(inmueble,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
		formaDePago = new ArrayList<String>();
		formaDePago.add("Hola");
	}
	
	@Test
	public void test_Constructor() {
		assertEquals(publicacion.obtenerHorarioCheckIn(), LocalDate.of(2016, 3, 20));
		assertEquals(publicacion.obtenerHorarioCheckOut(), LocalDate.of(2015, 3, 20));
		assertTrue(publicacion.formasDePago().contains("Efectivo"));
	}
	
	@Test
	public void testIngresarAjuste() {
		publicacion.ingresarAjuste(ajuste);
		verify(precio, times(1)).ingresarAjuste(ajuste);
	}
	
	@Test
	public void testReservar_notificaAlInquilinoConUnMail() {
		when(inmueble.obtenerPropietario()).thenReturn(usuario); 
		publicacion.reservar(LocalDate.of(2016, 3, 20), LocalDate.of(2015, 3, 20), formaDePago, usuario2);
		
		verify(usuario, times(1)).notificarPorMailIntentoDeReserva(LocalDate.of(2016, 3, 20), LocalDate.of(2015, 3, 20), formaDePago, usuario2);
		
	}

	@Test
	public void test_elPrecioDeLaPublicacionEnUnaFechaEsElDeSuPrecio() {
		when(precio.obtenerPrecioEn(LocalDate.of(2016, 3, 20))).thenReturn(new Double(45)); 
		
		assertEquals(publicacion.obtenerPrecioEn(LocalDate.of(2016, 3, 20)), new Double(45));
	}
	
	@Test
	public void test_laCantidadDeHuespedesDeUnaPublicacionEsLaCantidadDeSuInmueble() {
		when(inmueble.obtenerCapacidad()).thenReturn(new Integer(15)); 
		
		assertEquals(publicacion.obtenerCantidadDeHuespedes(), new Integer(15));
	}
	
	@Test
	public void test_laCiudadDeUnaPublicacionEsLaCiudadDeSuInmueble() {
		when(inmueble.obtenerCiudad()).thenReturn("Avellaneda"); 
		
		assertEquals(publicacion.obtenerCiudad(), "Avellaneda");
	}
	
	@Test
	public void test_elPrecioDeLaPublicacionCambiaElPrecioBaseDelPrecio() {
		publicacion.modificarPrecio(new Double(50));
		
		verify(precio, times(1)).modificarPrecioBase(new Double(50));
	}
	
	@Test
	public void test_cuandoSeCambiaElPrecioDeLaPublicacionSeLeInformaALosSuscriptoresSiElPrecioBaja() {
		Observer suscriptor = mock(Observer.class);
		publicacion.addObserver(suscriptor);
		
		when(precio.obtenerPrecioBase()).thenReturn(new Double(60));
		
		publicacion.modificarPrecio(new Double(50));

		verify(suscriptor, times(1)).update(publicacion, null);
	} 
	
	@Test
	public void test_cuandoSeCambiaElPrecioDeLaPublicacionNoSeLeInformaALosSuscriptoresSiElPrecioNoBaja() {
		Observer suscriptor = mock(Observer.class);
		publicacion.addObserver(suscriptor);
		
		when(precio.obtenerPrecioBase()).thenReturn(new Double(40));
		
		publicacion.modificarPrecio(new Double(50));

		verify(suscriptor, never()).update(publicacion, null);
	}
	
	@Test
	public void test_elPropietarioDeLaPublicacionEsElDelInmueble() {
		when(inmueble.obtenerPropietario()).thenReturn(usuario);
		
		assertEquals(publicacion.obtenerPropietario(), usuario);
	}
}


