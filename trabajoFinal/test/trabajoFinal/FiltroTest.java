package trabajoFinal;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import filtros.FiltroPorCiudad;
import filtros.FiltroPorFechaDeEntrada;

public class FiltroTest {

	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	private FiltroPorCiudad filtroPorCiudad;
	private ArrayList<Publicacion> lista;
	private FiltroPorFechaDeEntrada filtroPorFechaDeEntrada;

	@Before
	public void setUp() throws Exception {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		
		lista = new ArrayList<Publicacion>();
		lista.add(publicacion1);
		lista.add(publicacion2);
		lista.add(publicacion3);
	}

	@Test
	public void test_filtroPorCiudadDevuelveLasPublicacionesConIgualCiudad() {
		filtroPorCiudad = new FiltroPorCiudad("Avellaneda");
		when(publicacion1.getCiudad()).thenReturn("Avellaneda");
		when(publicacion2.getCiudad()).thenReturn("Rosario");
		when(publicacion3.getCiudad()).thenReturn("Avellaneda");

		List<Publicacion> listaResultado = filtroPorCiudad.filtrar(lista);
		
		assertTrue(listaResultado.contains(publicacion1));
		assertTrue(listaResultado.contains(publicacion3));
		assertEquals(listaResultado.size(), 2);
	}
	
	@Test
	public void test_filtroPorFechaDeEntradaDevuelveLasPublicacionesConIgualFechaDeEntrada() {
		filtroPorFechaDeEntrada = new FiltroPorFechaDeEntrada(LocalDate.of(2017, 05, 14));
		when(publicacion1.getFechaDeEntrada()).thenReturn(LocalDate.of(2017, 05, 14));
		when(publicacion2.getFechaDeEntrada()).thenReturn(LocalDate.of(2022, 05, 14));
		when(publicacion3.getFechaDeEntrada()).thenReturn(LocalDate.of(2013, 05, 14));

		List<Publicacion> listaResultado = filtroPorFechaDeEntrada.filtrar(lista);
		
		assertTrue(listaResultado.contains(publicacion1));
		assertEquals(listaResultado.size(), 1);
	}

}
