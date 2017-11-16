package filtros;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import filtros.FiltroPorCiudad;
import filtros.FiltroPorHorarioCheckIn;
import trabajoFinal.*;

public class FiltroSimpleTest {

	private Publicacion publicacion1;
	private Publicacion publicacion2;
	private Publicacion publicacion3;
	private FiltroPorCiudad filtroPorCiudad;
	private ArrayList<Publicacion> lista;
	private FiltroPorHorarioCheckIn filtroPorHorarioCheckIn;

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
		when(publicacion1.obtenerCiudad()).thenReturn("Avellaneda");
		when(publicacion2.obtenerCiudad()).thenReturn("Rosario");
		when(publicacion3.obtenerCiudad()).thenReturn("Avellaneda");

		List<Publicacion> listaResultado = filtroPorCiudad.filtrar(lista);
		
		assertTrue(listaResultado.contains(publicacion1));
		assertTrue(listaResultado.contains(publicacion3));
		assertEquals(listaResultado.size(), 2);
	}
	
	@Test
	public void test_filtroPorHorarioCheckInDevuelveLasPublicacionesConIgualHorarioCheckIn() {
		filtroPorHorarioCheckIn = new FiltroPorHorarioCheckIn(LocalDate.of(2017, 05, 14));
		when(publicacion1.obtenerHorarioCheckIn()).thenReturn(LocalDate.of(2017, 05, 14));
		when(publicacion2.obtenerHorarioCheckIn()).thenReturn(LocalDate.of(2022, 05, 14));
		when(publicacion3.obtenerHorarioCheckIn()).thenReturn(LocalDate.of(2013, 05, 14));

		List<Publicacion> listaResultado = filtroPorHorarioCheckIn.filtrar(lista);
		
		assertTrue(listaResultado.contains(publicacion1));
		assertEquals(listaResultado.size(), 1);
	}
	
	@Test
	public void test_filtroPorHorarioCheckOutDevuelveLasPublicacionesConIgualHorarioCheckOut() {
		FiltroPorHorarioCheckOut filtroPorHorarioCheckOut = new FiltroPorHorarioCheckOut(LocalDate.of(2017, 05, 14));
		when(publicacion1.obtenerHorarioCheckOut()).thenReturn(LocalDate.of(2017, 05, 14));
		when(publicacion2.obtenerHorarioCheckOut()).thenReturn(LocalDate.of(2022, 05, 14));
		when(publicacion3.obtenerHorarioCheckOut()).thenReturn(LocalDate.of(2013, 05, 14));

		List<Publicacion> listaResultado = filtroPorHorarioCheckOut.filtrar(lista);
		
		assertTrue(listaResultado.contains(publicacion1));
		assertEquals(listaResultado.size(), 1);
	}
	
	@Test
	public void test_filtroPorPrecioMinimoDevuelveLasPublicacionesConIgualOmayorPrecio() {
		FiltroPorPrecioMinimo filtro = new FiltroPorPrecioMinimo(new Double(50), LocalDate.MIN);
		when(publicacion1.obtenerPrecioEn(LocalDate.MIN)).thenReturn(new Double(40));
		when(publicacion2.obtenerPrecioEn(LocalDate.MIN)).thenReturn(new Double(50));
		when(publicacion3.obtenerPrecioEn(LocalDate.MIN)).thenReturn(new Double(60));

		List<Publicacion> listaResultado = filtro.filtrar(lista);

		assertTrue(listaResultado.contains(publicacion2));
		assertTrue(listaResultado.contains(publicacion3));
		assertEquals(listaResultado.size(), 2);
	}

	@Test
	public void test_filtroPorPrecioMaximoDevuelveLasPublicacionesConIgualOmenorPrecio() {
		FiltroPorPrecioMaximo filtro = new FiltroPorPrecioMaximo(new Double(50), LocalDate.MIN);
		when(publicacion1.obtenerPrecioEn(LocalDate.MIN)).thenReturn(new Double(40));
		when(publicacion2.obtenerPrecioEn(LocalDate.MIN)).thenReturn(new Double(50));
		when(publicacion3.obtenerPrecioEn(LocalDate.MIN)).thenReturn(new Double(60));

		List<Publicacion> listaResultado = filtro.filtrar(lista);

		assertTrue(listaResultado.contains(publicacion1));
		assertTrue(listaResultado.contains(publicacion2));
		assertEquals(listaResultado.size(), 2);
	}
	
	@Test
	public void test_filtroPorCantidadDeHuespedesDevuelveLasPublicacionesConIgualOmayorCantidadDeHuespedes() {
		FiltroPorCantidadDeHuespedes filtro = new FiltroPorCantidadDeHuespedes(new Integer(5));
		when(publicacion1.obtenerCantidadDeHuespedes()).thenReturn(new Integer(4));
		when(publicacion2.obtenerCantidadDeHuespedes()).thenReturn(new Integer(5));
		when(publicacion3.obtenerCantidadDeHuespedes()).thenReturn(new Integer(6));

		List<Publicacion> listaResultado = filtro.filtrar(lista);

		assertTrue(listaResultado.contains(publicacion2));
		assertTrue(listaResultado.contains(publicacion3));
		assertEquals(listaResultado.size(), 2);
	}
}
