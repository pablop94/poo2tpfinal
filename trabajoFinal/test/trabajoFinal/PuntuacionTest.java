package trabajoFinal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PuntuacionTest {
	private Puntuacion puntuacion;
	@Before
	public void setUp() throws Exception {
		puntuacion = new Puntuacion("cercania al centro", new Double(4), "medio lejos");
	}

	@Test
	public void test_constructor_puntuacion() {
		assertEquals(puntuacion.obtenerCategoria(), "cercania al centro");
		assertEquals(puntuacion.obtenerPuntaje(), new Double(4));
		assertEquals(puntuacion.obtenerComentario(), "medio lejos");
	}

}
