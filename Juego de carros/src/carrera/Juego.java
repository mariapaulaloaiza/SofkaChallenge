package carrera;

import java.util.ArrayList;

public class Juego {
	
	private String idJuego;
	
	private int rondas;
	
	private boolean play;
	
	public Juego(String idJuego, int rondas, boolean play) {
		this.idJuego = idJuego;
		this.rondas = rondas;
		this.play = play;
	}
	

	public String getIdJuego() {
		return idJuego;
	}



	public void setIdJuego(String idJuego) {
		this.idJuego = idJuego;
	}


	public int getRondas() {
		return rondas;
	}



	public void setRondas(int rondas) {
		this.rondas = rondas;
	}



	public boolean isPlay() {
		return play;
	}



	public void setPlay(boolean play) {
		this.play = play;
	}



	public static void finDeJuego() {
		
	}
	
	
	
	public static int tirarDado() {
		
		//numero aleatorio de 1 a 6 para simular el lanzamiento de un dado
		
		int resultadoDado = (int)(Math.random()*6+1)*100;
		
		return resultadoDado;
		
		
		
	}
	
	public void jugar(int distancia, ArrayList<Carro> carros) {
		
		for(Carro carrito: carros) {
			
			int dado = tirarDado();
			
			System.out.println("resultado del dado: "+ dado);
			
			carrito.avanzar(dado);
			
			System.out.println("carro:" + carrito.getIdCarro()+ " avance: "+ carrito.getRecorrido());
			
			finaljuego(distancia,carros);
		}
		
	}
	
	public void finaljuego(int distancia, ArrayList<Carro> carros) {
		
		Podio podio = new Podio();
		
		for(int i=0;i < carros.size();i++) {
			
			System.out.println("dentro del 2 for: "+ carros.get(i).getRecorrido());
			
			if(carros.get(i).getRecorrido() > distancia) {
				
				System.out.println("ganó: "+ carros.get(i));
				
				setPlay(false);
				
				break;
			}
			
		}
		
	}
}



	
	
		
		
	
	
		
	
		
		
	


