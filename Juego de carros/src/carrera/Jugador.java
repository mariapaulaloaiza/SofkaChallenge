package carrera;



public class Jugador {
	
	private int idJugador;
	
	private String nombreJugador;
	
	private int vecesGanadas;
	
	
	public Jugador(int idJugador, String nombreJugador, int vecesGanadas) {
		this.idJugador = idJugador;
		this.nombreJugador = nombreJugador;
		this.vecesGanadas = vecesGanadas;
	}


	public int getIdJugador() {
		return idJugador;
	}


	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}


	public String getNombreJugador() {
		return nombreJugador;
	}


	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}


	public int getVecesGanadas() {
		return vecesGanadas;
	}


	public void setVecesGanadas(int vecesGanadas) {
		this.vecesGanadas = vecesGanadas;
	}
	
	
	
	

	
	
	
	

}
