package trabajoFinal;

import java.util.ArrayList;

public interface IUsuario {
	public void  agregarInmuble(Inmueble inmu);
	public void  agregarPublicacion(Inmueble inmu,Double horarioIn,Double horarioOut);
	public void  agregarPublicacion(Inmueble inmu,Double horarioIn,Double horarioOut,ArrayList<String> formasDePago,Precio precio);
	public void  reservar(Publicaciones publicacion);
	public void  agregarRankingInquilino(String ranking);
	public void  agregarRankingPropietario(String ranking);
	public void  cambiarRol();
	public void  obtenerAntiguedad();
	public void  obtenerCantidadDeAlquileres();
	public void  obtenerReservasFuturas();
	public void  obtenerReservasDeCiudad(String Ciudad);
	public void  obtenerReservasPorCiudad();

}
