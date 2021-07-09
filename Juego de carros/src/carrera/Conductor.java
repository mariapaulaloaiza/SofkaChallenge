package carrera;

public class Conductor extends Jugador {
	
	public int recorrido;
	
	private Carro carro;

	public Conductor(int idJugador, String nombreJugador, int vecesGanadas,Carro carro) {
		super(idJugador, nombreJugador, vecesGanadas);
		this.carro = carro;
		this.recorrido = 0;
		
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
	
	public void avanzar(int valor) {
		this.recorrido += valor;
	}
	
	
	

	
	

	

	
	
	
	
	
	
	

}
