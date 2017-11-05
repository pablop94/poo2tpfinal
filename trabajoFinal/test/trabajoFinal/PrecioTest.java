package trabajoFinal;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class PrecioTest {
	private Precio precio;
	@Before
	public void setUp() throws Exception {
		precio = new Precio(new Double(30));
	}

	@Test
	public void test_precioBase() {
		assertEquals(precio.obtenerPrecioBase(), new Double(30));
	}

	@Test
	public void test_precio_en_fecha_es_igual_al_precio_base_cuando_no_hay_ajustes() {
		assertEquals(precio.obtenerPrecioEn(LocalDate.of(2017, 3, 20)), new Double(30));
	}
	
	@Test
	public void test_precio_en_fecha_es_igual_al_precio_del_ajuste_cuando_hay_ajuste() {
		precio.ingresarAjuste(LocalDate.of(2017, 03, 1), LocalDate.of(2017, 04, 1).plusDays(3), new Double(40));
		assertEquals(precio.obtenerPrecioEn(LocalDate.of(2017, 3, 20)), new Double(40));
		precio.ingresarAjuste(LocalDate.of(2017, 05, 1), LocalDate.of(2017, 06, 1).plusDays(3), new Double(50));
		assertEquals(precio.obtenerPrecioEn(LocalDate.of(2017, 5, 20)), new Double(50));
	}
	
	@Test
	public void test_cuando_se_modifica_el_precio_base_no_se_actualizan_los_ajustes() {
		precio.ingresarAjuste(LocalDate.of(2017, 03, 1), LocalDate.of(2017, 04, 1).plusDays(3), new Double(40));
		precio.modificarPrecioBase(new Double(50));
		assertEquals(precio.obtenerPrecioEn(LocalDate.of(2017, 3, 20)), new Double(40));
	}
}
