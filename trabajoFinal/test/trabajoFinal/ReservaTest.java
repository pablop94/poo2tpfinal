package trabajoFinal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReservaTest {
	private Reserva reserva;
	private Publicacion publicacion;
	private Usuario inquilino;
	private String formaDePagar;
	@Before
	public void setUp() throws Exception {
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
	public void test_cuandoSeCreaUnaReservaElInquilinoYPropietarioSonInformados() {
		Reserva reserva2 = new Reserva(publicacion, inquilino, formaDePagar);
		fail("Not implemented");
	}

}
