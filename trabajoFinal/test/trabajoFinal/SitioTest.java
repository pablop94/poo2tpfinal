package trabajoFinal;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
 
import filtros.Filtro;
import usuario.Usuario;

import static org.mockito.Mockito.*;

public class SitioTest {
	Sitio sitio;
	Filtro filtro;
	private Usuario usuario;
	@Before
	public void setUp() throws Exception {
		sitio = new Sitio();
		filtro = mock(Filtro.class);
		usuario = mock(Usuario.class);
	}

	@Test
	public void test_agregarServicioAgregaUnServicioAlSitio() {
		sitio.agregarServicio("WiFi");
		assertTrue(sitio.obtenerServicios().size() == 1);
		assertTrue(sitio.obtenerServicios().contains("WiFi"));
	}

	@Test
	public void test_agregarTipoDeInmuebleAgregaUnTipoDeInmuebleAlSitio() {
		sitio.agregarTipoDeInmueble("Carpa");
		assertTrue(sitio.obtenerTiposDeInmueble().size() == 1);
		assertTrue(sitio.obtenerTiposDeInmueble().contains("Carpa"));
	}
	
	@Test
	public void test_agregarCategoriaDeRankeoAgregaUnaCategoriaDeRankeoAlSitio() {
		sitio.agregarCategoriaDeRankeo("Llega borracho");
		assertTrue(sitio.obtenerCategoriasDeRankeo().size() == 1);
		assertTrue(sitio.obtenerCategoriasDeRankeo().contains("Llega borracho"));
	}
	
	@Test
	public void test_obtenerUsuarios() {
		sitio.agregarUsuario(usuario);

		assertEquals(sitio.obtenerUsuarios().size(), 1);
		assertTrue(sitio.obtenerUsuarios().contains(usuario));
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
