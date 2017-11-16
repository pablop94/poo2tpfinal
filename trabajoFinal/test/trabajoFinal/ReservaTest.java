package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import usuario.Usuario;

public class ReservaTest {
	private Reserva reserva;
	private Publicacion publicacion;
	private Usuario inquilino;
	private String formaDePagar;
	private Usuario propietario;
	@Before
	public void setUp() throws Exception {
		publicacion = mock(Publicacion.class);
		inquilino = mock(Usuario.class);
		propietario = mock(Usuario.class);
		reserva = new Reserva(publicacion, inquilino,formaDePagar);
	}

	@Test
	public void test_unaReservaNuevaNoEstaConfirmada() {
		assertFalse(reserva.estaConfirmada());
	}
	
	@Test
	public void test_cuandoUnaReservaEsAceptadaPasaAestarConfirmada() {
		reserva.aceptarReserva();
		assertTrue(reserva.estaConfirmada());
	}
	
	@Test
	public void test_elPropietarioDeLaReservaEsElDeLaPublicacion() {
		when(publicacion.obtenerPropietario()).thenReturn(propietario);
		
		assertEquals(reserva.obtenerPropietario(), propietario);
	}
	
	@Test
	public void test_cuandoSeCreaUnaReservaElInquilinoYPropietarioSonInformados() {
		Reserva reserva2 = new Reserva(publicacion, inquilino, formaDePagar);
		fail("Not implemented");
	}

}
