package usuario;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Inmueble;
import trabajoFinal.MailServer;
import trabajoFinal.Publicacion;
import trabajoFinal.Ranking;
import trabajoFinal.Reserva;

public class UsuarioTest {

	private Usuario usuario;
	private Rol rol;
	private Inmueble inmueble;
	private Publicacion publicacion;
	private Ranking ranking;
	private Ranking ranking2;
	private Ranking ranking3;
	private MailServer mailServer;
	private Reserva reserva1;
	private Reserva reserva2;
	private Reserva reserva3;
	
	
	@Before
	public void setUp(){
		rol = mock(Rol.class);
		mailServer = mock(MailServer.class);
		usuario = new Usuario("Tobias", "mail1", "42424", rol, mailServer);
		inmueble = mock(Inmueble.class);
		publicacion = mock(Publicacion.class);
		ranking = mock(Ranking.class);
		ranking2 = mock(Ranking.class);
		ranking3 = mock(Ranking.class);
		reserva1 = mock(Reserva.class);
		reserva2 = mock(Reserva.class);
		reserva3 = mock(Reserva.class);
		
		when(ranking.obtenerPuntaje()).thenReturn(new Double(10));
		when(ranking2.obtenerPuntaje()).thenReturn(new Double(20));
		when(ranking3.obtenerPuntaje()).thenReturn(new Double(30));
	}
	 
	@Test
	public void test_constructor() {
		assertEquals(usuario.obtenerNombre(), "Tobias");
		assertEquals(usuario.obtenerMail(), "mail1");
		assertEquals(usuario.obtenerTelefono(), "42424");
		assertEquals(usuario.obtenerRol(), rol);
		
	}
	
	@Test
	public void testAgregarPublicacion() {
		assertFalse(usuario.obtenerPublicaciones().contains(publicacion));
		usuario.agregarPublicacion(publicacion);
		assertTrue(usuario.obtenerPublicaciones().contains(publicacion));
	}
		
	
	@Test
	public void testAgregarInmueble() {
		assertFalse(usuario.obtenerInmuebles().contains(inmueble));
		usuario.agregarInmueble(inmueble);
		assertTrue(usuario.obtenerInmuebles().contains(inmueble));
	}

	@Test
	public void testCambiarRol() {
		Rol otroRol = mock(Rol.class);
		usuario.cambiarRol(otroRol);
		assertEquals(usuario.obtenerRol(), otroRol);		
	}

	@Test
	public void test_obtenerAntiguedadDevuelveLaCantidadDeDiasQueElUsuarioEstaActivo() {
		assertEquals(usuario.obtenerAntiguedad(), new Long(0));
	}

	@Test
	public void test_obtenerAlquileresDependeDelRol() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		
		when(rol.obtenerAlquileresDe(usuario)).thenReturn(reservas);
		
		assertEquals(usuario.obtenerAlquileres(),reservas);
		verify(rol, times(1)).obtenerAlquileresDe(usuario);
	}
	
	@Test
	public void test_obtenerCantidadAlquileres() {
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(mock(Reserva.class));
		when(rol.obtenerAlquileresDe(usuario)).thenReturn(reservas);
		
		assertEquals(usuario.obtenerCantidadDeAlquileres(), 1);
	}
	
	@Test
	public void test_reservasDeCiudad() {
		List<Reserva> lista = new ArrayList<Reserva>();
		when(reserva1.obtenerCiudad()).thenReturn("Avellaneda");
		when(reserva2.obtenerCiudad()).thenReturn("Avellaneda");
		when(reserva3.obtenerCiudad()).thenReturn("Quilmes");

		lista.add(reserva1);
		lista.add(reserva2);
		lista.add(reserva3);
		
		when(rol.obtenerReservasDe(usuario)).thenReturn(lista);
		
		assertEquals(usuario.reservasDeCiudad("Avellaneda").size(), 2);				
		assertTrue(usuario.reservasDeCiudad("Avellaneda").contains(reserva1));	
		assertTrue(usuario.reservasDeCiudad("Avellaneda").contains(reserva2));
	}
	
	@Test
	public void test_reservasPorCiudad() {
		List<Reserva> lista = new ArrayList<Reserva>();
		when(reserva1.obtenerCiudad()).thenReturn("Avellaneda");
		when(reserva2.obtenerCiudad()).thenReturn("Avellaneda");
		when(reserva3.obtenerCiudad()).thenReturn("Quilmes");

		lista.add(reserva1);
		lista.add(reserva2);
		lista.add(reserva3);
		
		when(rol.obtenerReservasDe(usuario)).thenReturn(lista);
		Map<String, List<Reserva>> rmap = new HashMap<String, List<Reserva>>();
		
		rmap = usuario.reservasPorCiudad();
		assertEquals(rmap.size(), 2);				
		assertTrue(rmap.containsKey("Avellaneda"));
		assertTrue(rmap.get("Avellaneda").contains(reserva1));
		assertTrue(rmap.get("Avellaneda").contains(reserva2));
		assertTrue(rmap.containsKey("Quilmes"));
		assertTrue(rmap.get("Quilmes").contains(reserva3));	
	}
	
	@Test
	public void test_reservasFuturas() {
		List<Reserva> lista = new ArrayList<Reserva>();
		when(reserva1.obtenerhorarioCheckIn()).thenReturn(LocalDate.now().plusDays(15));
		when(reserva2.obtenerhorarioCheckIn()).thenReturn(LocalDate.now().plusDays(15));
		when(reserva3.obtenerhorarioCheckIn()).thenReturn(LocalDate.now());
		
		lista.add(reserva1);
		lista.add(reserva2);
		lista.add(reserva3);
		
		when(rol.obtenerReservasDe(usuario)).thenReturn(lista);
		assertEquals(usuario.reservasFuturas().size(), 2);				
		assertTrue(usuario.reservasFuturas().contains(reserva1));	
		assertTrue(usuario.reservasFuturas().contains(reserva2));
	}
	
	@Test
	public void test_agregarRanking() {
		usuario.agregarRanking(ranking);
		
		assertEquals(usuario.obtenerTodosLosRankings().size(), 1);				
		assertTrue(usuario.obtenerTodosLosRankings().contains(ranking));
	}
	
	@Test
	public void test_agregarReserva() {
		usuario.agregarReserva(reserva1);
		
		assertEquals(usuario.obtenerTodasLasReservas().size(), 1);				
		assertTrue(usuario.obtenerTodasLasReservas().contains(reserva1));
	}
	
	@Test
	public void test_tipoDeRankingDependeDelRol() {
		when(rol.tipoDeRanking()).thenReturn("inquilino");
		
		assertEquals(usuario.tipoDeRanking(),"inquilino");
		verify(rol, times(1)).tipoDeRanking();
	}
	
	@Test
	public void test_elPuntajePromedioConCeroRankingsEsCero() {
		assertTrue(usuario.obtenerPuntajePromedio().equals(new Double(0)));
	}
	
	@Test
	public void test_elPuntajePromedioPorConMasDeCeroRankingsEsCorrecto() {
		when(ranking.obtenerCategoria()).thenReturn("Categoria1");
		when(ranking2.obtenerCategoria()).thenReturn("Categoria2");
		when(ranking3.obtenerCategoria()).thenReturn("Categoria2");
		when(rol.obtenerRankingsDe(usuario)).thenReturn(usuario.obtenerTodosLosRankings());
		usuario.agregarRanking(ranking);
		usuario.agregarRanking(ranking2);
		usuario.agregarRanking(ranking3);

		assertTrue(usuario.obtenerPuntajePromedio().equals(new Double(20)));
	}
	
	@Test
	public void test_elPuntajePromedioPorCategoriaConMasDeCeroRankingsEsCorrecto() {
		when(ranking.obtenerCategoria()).thenReturn("Categoria1");
		when(ranking2.obtenerCategoria()).thenReturn("Categoria2");
		when(ranking3.obtenerCategoria()).thenReturn("Categoria2");
		when(rol.obtenerRankingsDe(usuario)).thenReturn(usuario.obtenerTodosLosRankings());
		
		usuario.agregarRanking(ranking);
		usuario.agregarRanking(ranking2);
		usuario.agregarRanking(ranking3);

		assertTrue(usuario.obtenerPuntajePromedioPorCategoria("Categoria1").equals(new Double(10)));
		assertTrue(usuario.obtenerPuntajePromedioPorCategoria("Categoria2").equals(new Double(25)));
	}
	
	@Test
	public void test_elPuntajePromedioPorCategoriaConCeroRankingsEsCero() {
		when(ranking.obtenerCategoria()).thenReturn("Categoria1");
		when(ranking2.obtenerCategoria()).thenReturn("Categoria2");
		when(ranking3.obtenerCategoria()).thenReturn("Categoria2");
		
		usuario.agregarRanking(ranking);
		usuario.agregarRanking(ranking2);
		usuario.agregarRanking(ranking3);

		assertTrue(usuario.obtenerPuntajePromedioPorCategoria("Categoria4").equals(new Double(0)));
	}
	
	@Test
	public void test_obtenerRankingsDependeDelRol() {
		List<Ranking> rankings = new ArrayList<Ranking>();
		
		when(rol.obtenerRankingsDe(usuario)).thenReturn(rankings);
		
		assertEquals(usuario.obtenerRankings(),rankings);
		verify(rol, times(1)).obtenerRankingsDe(usuario);
	}
	
	@Test
	public void test_elEnvioDeMailSeHaceAtravesDelMailServer() {
		Usuario inquilino = mock(Usuario.class);
		when(inquilino.obtenerNombre()).thenReturn("nombreDelInquilino");

		Usuario propietario = mock(Usuario.class);
		when(propietario.obtenerMail()).thenReturn("propietario@gmail.com");

		when(reserva1.obtenerInquilino()).thenReturn(inquilino);
		when(reserva1.obtenerPropietario()).thenReturn(propietario);
		usuario.notificarPorMailIntentoDeReserva(reserva1);
		
		verify(mailServer, times(1)).sendMail(usuario.obtenerMail(), 
												"Tenes una nueva reserva!", 
												"El usuario nombreDelInquilino ha realizado una reserva en tu inmueble");
	}
	
	@Test
	public void test_envioDeMailReservaConfirmada() {
		usuario.notificarPorMailReservaConfirmada(reserva1);
		
		verify(mailServer, times(1)).sendMail(usuario.obtenerMail(), 
												"Tu reserva se confirmo!", 
												"El propietario acepto tu reserva!");
	}
	
}
