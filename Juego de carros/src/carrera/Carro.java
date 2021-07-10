package carrera;

public class Carro {

	private int idCarro;
	
	private int recorrido;

	private Carril carril = new Carril();

	public Carro(int idCarro) {
		this.idCarro = idCarro;
		this.recorrido = 0;
	}

	public int getIdCarro() {
		return idCarro;
	}


	public void setIdCarro(int idCarro) {
		this.idCarro = idCarro;
	}
	
	public void avanzar(int valor) {
		this.recorrido += valor;
	}

	public int getRecorrido() {
		return recorrido;
	}

	public void setRecorrido(int recorrido) {
		this.recorrido = recorrido;
	}
	
	


	
	
	
}
