package externo;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import interfaces.HomePagePublisher;
import trabajoFinal.Publicacion;

public class SitioExternoTest {
	
	SitioExterno sitio;
	private HomePagePublisher homePagePublisher;
	private Publicacion publicacion;

	@Before
	public void setUp() throws Exception {
		publicacion = mock(Publicacion.class);
		homePagePublisher = mock(HomePagePublisher.class);
		sitio = new SitioExterno(homePagePublisher);
	}

	@Test
	public void test_cuandoSeLlamaAUpdateDeUnSitioExternoSePublicaElMensajeCorrecto() {
		when(publicacion.tipoDeInmueble()).thenReturn("carpa");
		when(publicacion.obtenerPrecioEn(LocalDate.now())).thenReturn(new Double(300));
		
		sitio.update(publicacion, "CambioDePrecio");
		verify(homePagePublisher, times(1)).publish("No te pierdas esta oferta: Un inmueble carpa a tan sólo 300.0 pesos");
	}

}
