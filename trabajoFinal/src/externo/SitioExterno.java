package externo;

import java.time.LocalDate;
import java.util.Observable;
import java.util.Observer;

import interfaces.HomePagePublisher;
import trabajoFinal.Publicacion;

public class SitioExterno implements Observer{

	private HomePagePublisher publisher;

	public SitioExterno(HomePagePublisher homePagePublisher) {
		this.publisher = homePagePublisher;
	}

	@Override
	public void update(Observable o, Object arg) {
		Publicacion publicacion = (Publicacion) o;
		if (arg.toString().equals("CambioDePrecio")){
			publisher.publish("No te pierdas esta oferta: Un inmueble "+ publicacion.tipoDeInmueble()+ " a tan sólo " + publicacion.obtenerPrecioEn(LocalDate.now()).toString()+ " pesos");
		}
	}

}
