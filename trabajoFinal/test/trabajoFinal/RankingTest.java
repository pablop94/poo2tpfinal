package trabajoFinal;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class RankingTest {
	
	Ranking ranking;
	IRankeable inmueble;
	Puntuacion puntuacion;
	Usuario rankeador;
	
	@Before
	public void setUp() throws Exception {
		inmueble = mock(IRankeable.class);
		puntuacion = mock(Puntuacion.class);
		rankeador = mock(Usuario.class);
		ranking = new Ranking(inmueble, puntuacion, rankeador);
	}

	@Test
	public void test_constuctor() {
		assertEquals(ranking.obtenerEntidad(), inmueble);
		assertEquals(ranking.obtenerPuntuacion(), puntuacion);
		assertEquals(ranking.obtenerRankeador(), rankeador);
	}

}
