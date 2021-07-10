package carrera;

public class Conductor extends Jugador {
	

	private Carro carro;

	public Conductor(int idJugador, String nombreJugador, int vecesGanadas,Carro carro) {
		super(idJugador, nombreJugador, vecesGanadas);
		this.carro = carro;
		
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	
	
	
	
	
	

	
	

	

	
	
	
	
	
	
	

}
