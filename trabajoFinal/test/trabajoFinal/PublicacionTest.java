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
	private Precio precio;
	private Ajuste ajuste;
	private Inmueble inmueble;
	private ArrayList<String> formaDePago;
	private Observer suscriptor;
	@Before
	public void setUp(){
		usuario = mock(Usuario.class);
		precio = mock(Precio.class);
		inmueble = mock(Inmueble.class);
		ajuste = mock(Ajuste.class);
		when(inmueble.obtenerPropietario()).thenReturn(usuario);
		publicacion = new Publicacion(inmueble,LocalDate.of(2016, 3, 20),LocalDate.of(2015, 3, 20),precio);
		formaDePago = new ArrayList<String>();
		formaDePago.add("Hola");
		suscriptor = mock(Observer.class);
		publicacion.addObserver(suscriptor);
		
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
		when(precio.obtenerPrecioBase()).thenReturn(new Double(60));
		
		publicacion.modificarPrecio(new Double(50));

		verify(suscriptor, times(1)).update(publicacion, "CambioDePrecio");
	} 
	
	@Test
	public void test_cuandoSeCambiaElPrecioDeLaPublicacionNoSeLeInformaALosSuscriptoresSiElPrecioNoBaja() {
		when(precio.obtenerPrecioBase()).thenReturn(new Double(40));
		
		publicacion.modificarPrecio(new Double(50));

		verify(suscriptor, never()).update(publicacion, "CambioDePrecio");
	}
	
	@Test
	public void test_elPropietarioDeLaPublicacionEsElDelInmueble() {
		when(inmueble.obtenerPropietario()).thenReturn(usuario);
		
		assertEquals(publicacion.obtenerPropietario(), usuario);
	}
	
	@Test
	public void test_cuandoSeCreaUnaPublicacionSeAgregaAlPropietario() {
		
		verify(usuario, times(1)).agregarPublicacion(publicacion);
	}
	
	@Test
	public void test_elTipoDeInmuebleDeLaPublicacionEsElTipoDeInmuebleDelInmueble() {
		when(inmueble.obtenerTipoDeInmueble()).thenReturn("carpa");
		
		assertEquals(publicacion.tipoDeInmueble(), "carpa");
	}
	
	@Test
	public void test_reservarLeInformaAlosSuscriptoresConElMensajeNuevaReserva() {
		publicacion.reservar();
		
		verify(suscriptor, times(1)).update(publicacion, "NuevaReserva");
	}
}


