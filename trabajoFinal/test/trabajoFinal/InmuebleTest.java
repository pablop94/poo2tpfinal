package trabajoFinal;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import usuario.Usuario;

public class InmuebleTest {
	Inmueble inmueble;
	Usuario usuario;
	ArrayList<String> servicios;
	Ranking ranking;
	Ranking ranking2;
	Ranking ranking3;
	@Before
	public void setUp() throws Exception {
		ranking = mock(Ranking.class);
		ranking2 = mock(Ranking.class);
		ranking3 = mock(Ranking.class);

		when(ranking.obtenerPuntaje()).thenReturn(new Double(10));
		when(ranking2.obtenerPuntaje()).thenReturn(new Double(20));
		when(ranking3.obtenerPuntaje()).thenReturn(new Double(30));
		
		servicios = new ArrayList<String>();
		servicios.add("Pileta");
		servicios.add("8 baños");
		inmueble = new Inmueble(usuario, "/home", servicios, "Carpa", "Dinamarca", "Tristan Suarez", new Double(5), "Foto fea", new Integer(74));
	}

	@Test
	public void test_constructorInmueble() {
		assertEquals(inmueble.obtenerPropietario(), usuario);
		assertEquals(inmueble.obtenerDireccion(), "/home");
		assertEquals(inmueble.obtenerServicios(), servicios);
		assertEquals(inmueble.obtenerTipoDeInmueble(), "Carpa");
		assertEquals(inmueble.obtenerPais(), "Dinamarca");
		assertEquals(inmueble.obtenerCiudad(), "Tristan Suarez");
		assertEquals(inmueble.obtenerSuperficie(), new Double(5));
		assertEquals(inmueble.obtenerFotos(), "Foto fea");
		assertEquals(inmueble.obtenerCapacidad(), new Integer(74));
		
	}
	
	@Test
	public void test_agregarRankingAgregaElRankingAlaListaDelInmueble() {
		inmueble.agregarRanking(ranking);
		
		assertTrue(inmueble.obtenerRankings().contains(ranking));
	}
	
	@Test
	public void test_elPuntajePromedioConCeroRankingsEsCero() {
		assertTrue(inmueble.obtenerPuntajePromedio().equals(new Double(0)));
	}
	
	@Test
	public void test_elPuntajePromedioPorConMasDeCeroRankingsEsCorrecto() {
		when(ranking.obtenerCategoria()).thenReturn("Categoria1");
		when(ranking2.obtenerCategoria()).thenReturn("Categoria2");
		when(ranking3.obtenerCategoria()).thenReturn("Categoria2");
		
		inmueble.agregarRanking(ranking);
		inmueble.agregarRanking(ranking2);
		inmueble.agregarRanking(ranking3);

		assertTrue(inmueble.obtenerPuntajePromedio().equals(new Double(20)));
	}
	
	@Test
	public void test_elPuntajePromedioPorCategoriaConMasDeCeroRankingsEsCorrecto() {
		when(ranking.obtenerCategoria()).thenReturn("Categoria1");
		when(ranking2.obtenerCategoria()).thenReturn("Categoria2");
		when(ranking3.obtenerCategoria()).thenReturn("Categoria2");
		
		inmueble.agregarRanking(ranking);
		inmueble.agregarRanking(ranking2);
		inmueble.agregarRanking(ranking3);

		assertTrue(inmueble.obtenerPuntajePromedioPorCategoria("Categoria1").equals(new Double(10)));
		assertTrue(inmueble.obtenerPuntajePromedioPorCategoria("Categoria2").equals(new Double(25)));
	}
	
	@Test
	public void test_elPuntajePromedioPorCategoriaConCeroRankingsEsCero() {
		when(ranking.obtenerCategoria()).thenReturn("Categoria1");
		when(ranking2.obtenerCategoria()).thenReturn("Categoria2");
		when(ranking3.obtenerCategoria()).thenReturn("Categoria2");
		
		inmueble.agregarRanking(ranking);
		inmueble.agregarRanking(ranking2);
		inmueble.agregarRanking(ranking3);

		assertTrue(inmueble.obtenerPuntajePromedioPorCategoria("Categoria4").equals(new Double(0)));
	}

	@Test
	public void test_elTipoDeRankingDeUnInmuebleEsinmueble() {
		assertTrue(inmueble.tipoDeRanking().equals("inmueble"));
	}
}
