package trabajoFinal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import filtros.Filtro;
import static org.mockito.Mockito.*;

public class SitioTest {
	Sitio sitio;
	Filtro filtro;
	@Before
	public void setUp() throws Exception {
		sitio = new Sitio();
		filtro = mock(Filtro.class);
	}

	@Test
	public void test_agregarServicioAgregaUnServicioAlSitio() {
		sitio.agregarServicio("WiFi");
		assertTrue(sitio.getServicios().size() == 1);
		assertTrue(sitio.getServicios().contains("WiFi"));
	}

	@Test
	public void test_agregarTipoDeInmuebleAgregaUnTipoDeInmuebleAlSitio() {
		sitio.agregarTipoDeInmueble("Carpa");
		assertTrue(sitio.getTipoDeInmueble().size() == 1);
		assertTrue(sitio.getTipoDeInmueble().contains("Carpa"));
	}
	
	@Test
	public void test_agregarCategoriaDeRankeoAgregaUnaCategoriaDeRankeoAlSitio() {
		sitio.agregarCategoriaDeRankeo("Llega borracho");
		assertTrue(sitio.getCategoriaDeRankeo().size() == 1);
		assertTrue(sitio.getCategoriaDeRankeo().contains("Llega borracho"));
	}
	
	@Test
	public void test_elListadoDeGestionTieneLosUsuarios() {
		Usuario user = mock(Usuario.class);
		List<Usuario> resultado = sitio.obtenerListadoDeGestion();
		assertTrue(resultado.size() == 0);
		sitio.agregarUsuario(user);
		resultado = sitio.obtenerListadoDeGestion();
		
		assertTrue(resultado.size() == 1);
		
		assertTrue(resultado.contains(user));
	}
	
	@Test
	public void test_buscarDevuelveLasPublicacionesQueCoincidenConElFiltro() {
		List<Publicacion> publicaciones = new ArrayList<Publicacion>();
		publicaciones.add(mock(Publicacion.class));
		when(filtro.filtrar(publicaciones)).thenReturn(publicaciones);
		
		List<Publicacion> resultado = sitio.buscar(filtro, publicaciones);
		
		assertEquals(publicaciones, resultado);
		verify(filtro, times(1)).filtrar(publicaciones);
	}
}
