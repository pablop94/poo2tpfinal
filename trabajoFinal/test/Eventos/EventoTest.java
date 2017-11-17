package Eventos;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class EventoTest {
	Evento nuevaReserva;
	Observer usuario1;
	Evento cancelarReserva;
	Evento cambioDePrecio;
	@Before
	public void SetUp() {
		nuevaReserva = new NuevaReserva();
		usuario1 = mock(Usuario.class);
		cancelarReserva = new CancelacionReserva();
		cambioDePrecio = new CambioDePrecio();
	}
	@Test
	public void testAgregado() {
		assertEquals(nuevaReserva.countObservers(), 0);
		nuevaReserva.agregarSuscriptor(usuario1, "NuevaReserva");
		
		assertEquals(nuevaReserva.countObservers(), 1);
	}
	
	@Test
	public void testAgregado_elEventoNoCorresponde() {
		assertEquals(nuevaReserva.countObservers(), 0);
		nuevaReserva.agregarSuscriptor(usuario1, "CancelacionReserva");
		
		assertEquals(nuevaReserva.countObservers(), 0);
	}
	
	@Test
	public void testBorrado() {
		nuevaReserva.agregarSuscriptor(usuario1, "NuevaReserva");
		nuevaReserva.borrarSuscriptor(usuario1, "NuevaReserva");
		assertEquals(nuevaReserva.countObservers(), 0);
	}

	@Test
	public void testBorrado_elEventoNoCorresponde() {
		nuevaReserva.agregarSuscriptor(usuario1, "NuevaReserva");
		nuevaReserva.borrarSuscriptor(usuario1, "CancelacionReserva");
		assertEquals(nuevaReserva.countObservers(), 1);
	}

	@Test
	public void testManejarEventoCancelado() {
		assertTrue(cancelarReserva.puedeManejarEvento("CancelacionReserva"));
	}
	
	@Test
	public void testManejarEventoNuevaReserva() {
		assertTrue(nuevaReserva.puedeManejarEvento("NuevaReserva"));
	}
	
	@Test
	public void testManejarEventoCambioDePrecio() {
		assertTrue(cambioDePrecio.puedeManejarEvento("CambioDePrecio"));
	}
}
