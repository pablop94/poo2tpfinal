package trabajoFinal;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import interfaces.Rankeable;
import usuario.Usuario;

import static org.mockito.Mockito.*;

public class RankingTest {
	
	Ranking ranking;
	Rankeable entidad;
	Puntuacion puntuacion;
	Usuario rankeador;
	
	@Before
	public void setUp() throws Exception {
		entidad = mock(Rankeable.class);
		when(entidad.tipoDeRanking()).thenReturn("tipoDeRankingTest");
		puntuacion = mock(Puntuacion.class);
		rankeador = mock(Usuario.class);
		ranking = new Ranking(entidad, puntuacion, rankeador);
	}

	@Test
	public void test_constuctor() {
		assertEquals(ranking.obtenerEntidad(), entidad);
		assertEquals(ranking.obtenerPuntuacion(), puntuacion);
		assertEquals(ranking.obtenerRankeador(), rankeador);
	}

	@Test
	public void test_elPuntajeDeUnRankingEsElPuntajeDeSuPuntuacion() {
		when(puntuacion.obtenerPuntaje()).thenReturn(new Double(30));
		assertEquals(ranking.obtenerPuntaje(), new Double(30));
	}
	
	@Test
	public void test_laCategoriaDeUnRankingEsLaCategoriaDeSuPuntuacion() {
		when(puntuacion.obtenerCategoria()).thenReturn("Llega Borracho");
		assertEquals(ranking.obtenerCategoria(), "Llega Borracho");
	}
	
	@Test
	public void test_elTipoDeRankingDeLaReservaEsElTipoDeRankingDeLaEntidad() {
		assertEquals(ranking.tipoDeRanking(), "tipoDeRankingTest");
	}
}
