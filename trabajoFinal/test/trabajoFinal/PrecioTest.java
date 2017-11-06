package trabajoFinal;

import static org.junit.Assert.*;

import java.time.LocalDate;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

public class PrecioTest {
	private Precio precio;
	private Ajuste ajuste;
	@Before
	public void setUp() throws Exception {
		precio = new Precio(new Double(30));
		ajuste = mock(Ajuste.class);
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
		when(ajuste.obtenerPrecioEn(LocalDate.of(2017, 3, 20))).thenReturn(new Double(40));
		when(ajuste.contieneFecha(LocalDate.of(2017, 3, 20))).thenReturn(true);
		
		precio.ingresarAjuste(ajuste);
		assertEquals(new Double(40), precio.obtenerPrecioEn(LocalDate.of(2017, 3, 20)));
		
		verify(ajuste, times(1)).obtenerPrecioEn(LocalDate.of(2017, 3, 20));
	}
	
	@Test
	public void test_cuando_se_modifica_el_precio_base_no_se_actualizan_los_ajustes() {
		when(ajuste.obtenerPrecioEn(LocalDate.of(2017, 3, 20))).thenReturn(new Double(40));
		when(ajuste.contieneFecha(LocalDate.of(2017, 3, 20))).thenReturn(true);
			
		precio.ingresarAjuste(ajuste);
		precio.modificarPrecioBase(new Double(50));
		assertEquals(new Double(40), precio.obtenerPrecioEn(LocalDate.of(2017, 3, 20)));
		
		verify(ajuste, times(1)).obtenerPrecioEn(LocalDate.of(2017, 3, 20));
	}
}
