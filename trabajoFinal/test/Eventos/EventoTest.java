package Eventos;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class EventoTest {
	Evento nuevaReserva;
	Usuario usuario1;
	Evento cancelarReserva;
	Evento cambioDePrecio;
	@Before
	public void SetUp() {
		nuevaReserva =mock(NuevaReserva.class);
		usuario1 = mock(Usuario.class);
		cancelarReserva = new CancelacionReserva();
		cambioDePrecio = new CambioDePrecio();
	}
	@Test
	public void testAgregado() {
		nuevaReserva.agregarSuscriptor(usuario1, "NuevaReserva");
		verify(nuevaReserva).addObserver(usuario1);
	}
	
	@Test
	public void testBorrado() {
		nuevaReserva.borrarSuscriptor(usuario1, "NuevaReserva");
		verify(nuevaReserva).this.deleteObserver(usuario1);
	}

	@Test
	public void testManejarEventoCancelado() {
		assertTrue(cancelarReserva.puedeManejarEvento("CancelacionReserva"));
	}
	
	@Test
	public void testManejarEventoCambioDePrecio() {
		assertTrue(cambioDePrecio.puedeManejarEvento("CambioDePrecio"));
	}
}
