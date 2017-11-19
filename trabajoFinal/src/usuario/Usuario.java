package usuario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.Collectors;

import trabajoFinal.IRankeable;
import trabajoFinal.Inmueble;
import trabajoFinal.Publicacion;
import trabajoFinal.Ranking;
import trabajoFinal.Reserva;
import trabajoFinal.Sitio;

public class Usuario extends Cuenta implements IRankeable, Observer {

	private Rol rol;
	private List<Publicacion> publicaciones;
	private List<Inmueble> inmuebles;
	private List<Reserva> reservas;
	private List<Ranking> rankings;
	private LocalDate ingresoAlSistema;
	
	public Usuario(String nombre, String mail, String numeroTelefono, Rol rol) {
		super(nombre, mail, numeroTelefono);
		this.inmuebles= new ArrayList<Inmueble>();
		this.reservas= new ArrayList<Reserva>();
		this.publicaciones= new ArrayList<Publicacion>();
		this.rankings= new ArrayList<Ranking>();
		this.rol= rol;
		this.ingresoAlSistema = LocalDate.now();
	}

	public void agregarInmueble(Inmueble inmueble) {
		this.inmuebles.add(inmueble);
		
	}
	public void agregarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
		
	}

	public  void cambiarRol(Rol rol1) {
		this.rol= rol1; 
	}

	public void agregarReserva(Reserva r) {
		this.reservas.add(r);		
	}

	public List<Reserva> obtenerAlquileres() {
		//Se considera alquiler cuando la reserva esta aceptada
		//como pueden ser alquileres que yo hago como inquilino o alquileres de mis propiedades, se le delega al Rol
		return this.rol.obtenerAlquileresDe(this);
	}
	
	public int obtenerCantidadDeAlquileres() {
		return this.obtenerAlquileres().size();
	}

	public List<Reserva> reservasDeCiudad(String ciudad) {
		return(this.obtenerReservas().stream().filter(reserva -> reserva.obtenerCiudad().equals(ciudad)) ).collect(Collectors.toList());
	}
	
	public Map<String, List<Reserva>> reservasPorCiudad() {
		Map<String, List<Reserva>> reservasPorCiudad = new HashMap<String, List<Reserva>>();
		//Obtengo las ciudades sin repetidos
		List<String> ciudadesReservas = this.obtenerReservas().stream().map((reserva) -> reserva.obtenerCiudad()).distinct().collect(Collectors.toList());
		
		//Para cada ciudad, obtengo la lista de reservas		
		for (String ciudad: ciudadesReservas){
			reservasPorCiudad.put(ciudad, reservasDeCiudad(ciudad));
		}
		
		return reservasPorCiudad;
	}
	
	public List<Reserva> reservasFuturas() {
		return this.obtenerReservas().stream().filter(reserva -> reserva.obtenerhorarioCheckIn().isAfter(LocalDate.now())).collect(Collectors.toList());
	}
	
	public List<Reserva> obtenerReservas() {
		return this.rol.obtenerReservasDe(this);
	}

	public List<Reserva> obtenerTodasLasReservas() {
		return this.reservas;
	}	

	@Override
	public void agregarRanking(Ranking r) {
		this.rankings.add(r);		
	}


	@Override
	public Double obtenerPuntajePromedio() {
		return obtenerPuntajePromedioDeRankings(this.obtenerRankings());
	}
	private Double obtenerPuntajePromedioDeRankings(List<Ranking> listaDeRankings){
		if (listaDeRankings.size() == 0){
			return new Double(0);
		}
		return listaDeRankings.stream().mapToDouble((ranking) -> ranking.obtenerPuntaje()).sum() / listaDeRankings.size();
	}
	
	@Override
	public Double obtenerPuntajePromedioPorCategoria(String categoria) {
		return obtenerPuntajePromedioDeRankings(
				this.obtenerRankings().stream().filter((ranking) -> ranking.obtenerCategoria().equals(categoria)).collect(Collectors.toList()));
	}
	
	public List<Ranking> obtenerTodosLosRankings() {
		return rankings;
	}	

	@Override 
	public List<Ranking> obtenerRankings() {
		return this.rol.obtenerRankingsDe(this);
	}

	@Override
	public String tipoDeRanking() {
		return this.rol.tipoDeRanking();
	}


	public List<Inmueble> obtenerInmuebles() {
		return this.inmuebles;
	}
	
	public List<Publicacion> obtenerPublicaciones() {
		return this.publicaciones;
	}


	public Rol obtenerRol() {
		return this.rol;
	}


	public Long obtenerAntiguedad() {
		return ChronoUnit.DAYS.between(this.ingresoAlSistema, LocalDate.now());
	}

	public void notificarPorMailIntentoDeReserva(Reserva reserva) {
		Sitio.getInstance().getMailServer().sendMail(this.obtenerMail(), 
							"Tenes una nueva reserva!", 
							"El usuario " + reserva.obtenerInquilino().obtenerNombre() + 
							" ha realizado una reserva en tu inmueble");
	}


	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	public void notificarPorMailReservaConfirmada(Reserva reserva) {
		Sitio.getInstance().getMailServer().sendMail(this.obtenerMail(), 
				"Tu reserva se confirmo!", 
				"El propietario acepto tu reserva!");
	}
}