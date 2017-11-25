package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class ReservaTest {
	private Reserva reserva;
	private Publicacion publicacion;
	private Usuario inquilino;
	private String formaDePagar;
	private Usuario propietario;
	private Observer obs;
	@Before
	public void setUp() throws Exception {
		publicacion = mock(Publicacion.class);
		inquilino = mock(Usuario.class);
		propietario = mock(Usuario.class);
		formaDePagar = "Tarjeta"; 
		when(publicacion.obtenerPropietario()).thenReturn(propietario);
		reserva = new Reserva(publicacion, inquilino,formaDePagar);
		obs = mock(Observer.class);
		reserva.addObserver(obs);
	}

	@Test
	public void test_unaReservaNuevaNoEstaConfirmada() {
		assertFalse(reserva.estaConfirmada());
	}
	
	@Test
	public void test_cuandoUnaReservaEsAceptadaPasaAestarConfirmada() {
		reserva.aceptar();
		assertTrue(reserva.estaConfirmada());
	}
	
	@Test
	public void test_obtenerInquilino() {
		assertEquals(reserva.obtenerInquilino(), inquilino);
	}
	
	@Test
	public void test_obtenerFormaDePago() {
		assertEquals(reserva.obtenerFormaDePago(), "Tarjeta");
	}
	
	@Test
	public void test_elHorarioDeCheckInDeLaReservaEsElDeSuPublicacion() {
		when(publicacion.obtenerHorarioCheckIn()).thenReturn(LocalDate.MAX);
		assertEquals(reserva.obtenerhorarioCheckIn(), LocalDate.MAX);
	}
	
	@Test
	public void test_elPropietarioDeLaReservaEsElDeLaPublicacion() {
		when(publicacion.obtenerPropietario()).thenReturn(propietario);
		
		assertEquals(reserva.obtenerPropietario(), propietario);
	}
	
	@Test
	public void test_laCiudadDeLaReservaEsLaCiudadDeLaPublicacion() {
		when(publicacion.obtenerCiudad()).thenReturn("Catamarca");
		
		assertEquals(reserva.obtenerCiudad(), "Catamarca");
	}
	
	@Test
	public void test_elTipoDeInmuebleDeLaReservaEsElTipoDeInmuebleDeLaPublicacion() {
		when(publicacion.tipoDeInmueble()).thenReturn("carpa");
		
		assertEquals(reserva.tipoDeInmueble(), "carpa");
	}
	
	@Test
	public void test_cuandoSeCreaUnaReservaElInquilinoYPropietarioSonInformados() {
		Reserva reserva2 = new Reserva(publicacion, inquilino, formaDePagar);
		verify(propietario, times(1)).agregarReserva(reserva2);
		verify(propietario, times(1)).notificarPorMailIntentoDeReserva(reserva2);
		verify(inquilino, times(1)).agregarReserva(reserva2);
	}

	@Test
	public void test_cuandoSeCancelaUnaReservaLosSuscriptoresSonInformados() {
		reserva.cancelar();
		
		verify(obs, times(1)).update(reserva, "Cancelacion");		
	}
	
	@Test
	public void test_cuandoSeCreaUnaNuevaReservaSeLeNotificaALosSuscriptoresDeLaPublicacion() {
		verify(publicacion, times(1)).reservar();		
	}
}
