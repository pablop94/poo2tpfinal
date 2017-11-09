package filtros;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trabajoFinal.Publicacion;

public class FiltroCompuestoTest {
	private FiltroPorCiudad filtroSimple;
	private FiltroPorCantidadDeHuespedes filtroSimple2;
	private FiltroAND filtroAND;
	private FiltroOR filtroOR;
	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	private ArrayList<Publicacion> lista;
	@Before
	public void setUp() throws Exception {
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);
		publicacion3 = mock(Publicacion.class);
		
		lista = new ArrayList<Publicacion>();
		lista.add(publicacion1);
		lista.add(publicacion2);
		lista.add(publicacion3);
		
		ArrayList<Publicacion> listaUnoYDos = new ArrayList<Publicacion>();
		listaUnoYDos.add(publicacion1);
		listaUnoYDos.add(publicacion2);

		ArrayList<Publicacion> listaDosYTres = new ArrayList<Publicacion>();
		listaDosYTres.add(publicacion2);
		listaDosYTres.add(publicacion3);
		
		filtroSimple = mock(FiltroPorCiudad.class);
		filtroSimple2 = mock(FiltroPorCantidadDeHuespedes.class);
		
		when(filtroSimple.filtrar(lista)).thenReturn(listaUnoYDos);
		when(filtroSimple2.filtrar(lista)).thenReturn(listaDosYTres);

		filtroAND = new FiltroAND(filtroSimple, filtroSimple2);
		filtroOR = new FiltroOR(filtroSimple, filtroSimple2);
	}

	@Test
	public void test_unFiltroANDDevuelveLasPublicacionesQueCumplenAmbosDeSusFiltros() {
		List<Publicacion> resultados = filtroAND.filtrar(lista);
		assertEquals(resultados.size(), 1);
		assertTrue(resultados.contains(publicacion2));
	}
	
	@Test
	public void test_unFiltroORDevuelveLasPublicacionesQueCumplenAlgunoDeSusFiltrosSinDuplicados() {
		List<Publicacion> resultados = filtroOR.filtrar(lista);
		assertEquals(resultados.size(), 3);
		assertTrue(resultados.contains(publicacion1));
		assertTrue(resultados.contains(publicacion2));
		assertTrue(resultados.contains(publicacion3));
	}

}
