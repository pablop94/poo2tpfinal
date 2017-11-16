package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Ranking;
import trabajoFinal.Reserva;

public class PropietarioTest {
	Propietario propietario;
	private Usuario usuario;
	private Reserva reserva1;
	private Reserva reserva2;
	private Ranking ranking1;
	private Ranking ranking2;
	@Before
	public void setUp() throws Exception {
		propietario = new Propietario();
		usuario = mock(Usuario.class);
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		ranking1 = mock(Ranking.class);
		ranking2 = mock(Ranking.class);
	}

	@Test
	public void test_obtenerReservasDeUsuarioDevuelveLasReservasEnLasQueElPropietarioEsIgualAlUsuario() {
		when(reserva1.obtenerPropietario()).thenReturn(usuario);
		when(reserva2.obtenerPropietario()).thenReturn(mock(Usuario.class));
		List<Reserva> lista = new ArrayList<Reserva>();
		lista.add(reserva1);
		lista.add(reserva2);
		
		when(usuario.obtenerTodasLasReservas()).thenReturn(lista);
		
		assertEquals(propietario.obtenerReservasDe(usuario).size(),1);
		assertTrue(propietario.obtenerReservasDe(usuario).contains(reserva1));
	}
	
	@Test
	public void test_tipoDeRankingDeUsuarioEspropietario() {
		assertEquals(propietario.tipoDeRanking(), "propietario");
	}
	
	@Test
	public void test_obtenerRankingsDeUsuarioDevuelveLosRankingsEnLasQueElTipoDeRankingEsIgualAlDelUsuario() {
		when(ranking1.tipoDeRanking()).thenReturn("propietario");
		when(ranking2.tipoDeRanking()).thenReturn("tipoDeRankingTest");
		List<Ranking> lista = new ArrayList<Ranking>();
		lista.add(ranking1);
		lista.add(ranking2);
		
		when(usuario.obtenerTodosLosRankings()).thenReturn(lista);
		
		assertEquals(propietario.obtenerRankingsDe(usuario).size(),1);
		assertTrue(propietario.obtenerRankingsDe(usuario).contains(ranking1));
	}
	
	@Test
	public void test_obtenerAlquileresDeUsuarioDevuelveLasReservasQueEstanConfirmadas() {
		when(reserva1.estaConfirmada()).thenReturn(true);
		when(reserva2.estaConfirmada()).thenReturn(false);
		when(reserva1.obtenerPropietario()).thenReturn(usuario);
		when(reserva2.obtenerPropietario()).thenReturn(usuario);
		List<Reserva> lista = new ArrayList<Reserva>();
		lista.add(reserva1);
		lista.add(reserva2);
		
		when(usuario.obtenerTodasLasReservas()).thenReturn(lista);
		
		assertEquals(propietario.obtenerAlquileresDe(usuario).size(),1);
		assertTrue(propietario.obtenerReservasDe(usuario).contains(reserva1));
	}

}
