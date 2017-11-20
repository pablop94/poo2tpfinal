package interfaces;

import java.util.List;

import trabajoFinal.Ranking;

public interface Rankeable {

	public void agregarRanking(Ranking r);
	
	public Double obtenerPuntajePromedio();
	
	public Double obtenerPuntajePromedioPorCategoria(String categoria);
	
	public List<Ranking> obtenerRankings();
	
	public String tipoDeRanking();
	
}
