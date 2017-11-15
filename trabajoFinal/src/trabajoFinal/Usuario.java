package trabajoFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Usuario extends Cuenta implements IRankeable {

	private Rol rol;
	private List<Publicacion> publicaciones;
	private List<Inmueble> inmuebles;
	private List<Reserva> reservas;
	private List<Ranking> rankings;
	
	public Usuario(String nombre, String mail, String numeroTelefono, Rol rol) {
		super(nombre, mail, numeroTelefono);
		this.inmuebles= new ArrayList<Inmueble>();
		this.reservas= new ArrayList<Reserva>();
		this.publicaciones= new ArrayList<Publicacion>();
		this.rankings= new ArrayList<Ranking>();
		this.rol= new Inquilino();
	}

	
	public void notificarPorMailIntentoDeReserva(LocalDate fechaInicial, LocalDate fechaFinal,
			ArrayList<String> formaDePago, Usuario inquilino) {
		// TODO Auto-generated method stub
		
	}   
	
	public boolean esInquilino() {
		
		return(this.rol.esInquilino());
	}
	
	public void agregarInmueble(Inmueble inmueble) {
		this.inmuebles.add(inmueble);
		
	}
	public void agregarPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
		
	}
	public void  reservar(Publicacion p, Rol rol, LocalDate fechaInicial, LocalDate fechaFinal, ArrayList<String> formaDePago,
			Usuario usuario) {
		
		rol.reservar(p, fechaInicial, fechaFinal, formaDePago, this);
		
	}
	


	public  void cambiarRol(Rol rol1) {
		this.rol= rol1; 
	}



	public void agregarReserva(Reserva r) {
		this.reservas.add(r);  
		
	}


	public void notificarPorMailIntentoDeReserva(Reserva reserva) {
		this.rol.agregarReservaPropietario(reserva, this);
	}


	public void agregarReservaDelPropietario(Reserva reserva) {
		this.reservas.add(reserva);
		
	}

	public List<Reserva> obtenerAlquileres() {
		return(reservas);
	}
	
	public int obtenerCantidadDeAlquileres() {
		return(reservas.size());
	}

	public List<Reserva> reservasDeCiudad(String ciudad) {
		return(reservas.stream().filter(reserva -> reserva.ciudadReserva() == ciudad) ).collect(Collectors.toList());
	}
	public ArrayList<String> reservasPorCiudad() {
		ArrayList<String> ciudadesReservas = new ArrayList<String>();
		for(Reserva reserva:reservas) {
			if(!(ciudadesReservas.contains(reserva.ciudadReserva()))) {
				ciudadesReservas.add(reserva.ciudadReserva());
		    }
		}
		return(ciudadesReservas);
	}
	
	public List<Reserva> reservasFuturas() {
		return reservas.stream().filter(reserva -> reserva.tiempoCheckInReservas().isAfter(LocalDate.now())).collect(Collectors.toList());
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
		if (rankings.size() == 0){
			return new Double(0);
		}
		return rankings.stream().mapToDouble((ranking) -> ranking.obtenerPuntaje()).sum() / rankings.size();
	}
	
	@Override
	public Double obtenerPuntajePromedioPorCategoria(String categoria) {
		return obtenerPuntajePromedioDeRankings(
				this.obtenerRankings().stream().filter((ranking) -> ranking.obtenerCategoria().equals(categoria)).collect(Collectors.toList()));
	}


	@Override
	public List<Ranking> obtenerRankings() {
		return rankings;
	}


	public void rankear(Ranking ranking) {
		this.rol.rankear(ranking, this);
	}																						
}