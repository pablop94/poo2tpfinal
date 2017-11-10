package trabajoFinal;

import java.util.List;

public interface IRankeable {

	public void agregarRanking(Ranking r);
	
	public Double obtenerPuntajePromedio();
	
	public Double obtenerPuntajePromedioPorCategoria(String categoria);
	
	public List<Ranking> obtenerRankings();
	
}
