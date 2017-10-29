package trabajoFinal;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class AjusteTest {
	private Ajuste ajuste;
	
	@Before
	public void setUp() throws Exception {
		ajuste = new Ajuste(LocalDate.of(2017, 4, 20), LocalDate.of(2017, 4, 20).plusDays(3), new Double(35));
	}

	@Test
	public void test_constructor_Ajuste() {
		assertEquals(ajuste.obtenerPrecio(), new Double(35));
		assertEquals(ajuste.obtenerInicio(), LocalDate.of(2017, 4, 20));
		assertEquals(ajuste.obtenerFin(), LocalDate.of(2017, 4, 20).plusDays(3));
	}
	
	@Test
	public void test_modificar_precio() {
		ajuste.modificarPrecio(new Double(40));
		assertEquals(ajuste.obtenerPrecio(), new Double(40));
	}
	
	@Test
	public void test_el_precio_de_un_ajuste_en_una_fecha_dentro_del_periodo_es_el_precio_guardado() {
		assertEquals(ajuste.obtenerPrecioEn(LocalDate.of(2017, 4, 20)), new Double(35));
		assertEquals(ajuste.obtenerPrecioEn(LocalDate.of(2017, 4, 21)), new Double(35));
		assertEquals(ajuste.obtenerPrecioEn(LocalDate.of(2017, 4, 23)), new Double(35));
	}
	
	@Test
	public void test_el_precio_de_un_ajuste_en_una_fecha_fuera_del_periodo_es_cero() {
		assertEquals(ajuste.obtenerPrecioEn(LocalDate.of(2017, 4, 19)), new Double(0));
		assertEquals(ajuste.obtenerPrecioEn(LocalDate.of(2017, 4, 24)), new Double(0));
	}
}
