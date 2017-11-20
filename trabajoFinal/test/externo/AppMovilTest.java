package externo;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import interfaces.PopUpWindow;
import trabajoFinal.Reserva;

public class AppMovilTest {
	private AppMovil appMovil;
	private PopUpWindow window;
	private Reserva observable;
	@Before
	public void setUp() throws Exception {
		observable = mock(Reserva.class);
		window = mock(PopUpWindow.class);
		appMovil = new AppMovil(window);
	}

	@Test
	public void test_cuandoUnaAppMovilRecibeUnaNotificacionDeCancelacionSeMuestraElMensajeCorrectoEnSuPopUpWindow() {
		when(observable.tipoDeInmueble()).thenReturn("carpa");
		appMovil.update(observable, "Cancelacion");
		
		verify(window, times(1)).popUp("El/la carpa que te interesa se ha liberado! Corre a reservarlo!", "rojo", 13);
	}

}
