package carrera;

import java.util.ArrayList;

public class Juego {
	
	private String idJuego;
	
	private int rondas;
	
	private boolean play;
	
	public ArrayList<Carro> ganadores = new ArrayList<Carro>();
	
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
	
	public void jugar(Podio podio,int distancia, ArrayList<Carro> carros) {
		
		for(int i= 0; carros.size()>i; i++) {
			
			if(carros.size()==0) {
				
				setPlay(false);
				
				System.out.println("hola");
				
				break;
				
			}else {
			
			int dado = tirarDado();
			
			System.out.println("resultado del dado: "+ dado);
			
			carros.get(i).avanzar(dado);
			
			System.out.println("carro:" + carros.get(i).getIdCarro()+ " avance: "+ carros.get(i).getRecorrido());
			
			if(pasoMeta(podio, distancia,carros.get(i))) {
				
				System.out.println("pasó la meta el carro: "+carros.get(i).getIdCarro());
				
				carros.remove(i);
				
			}
			
			}
			
		}
		
		
	}
	
	public  boolean pasoMeta(Podio podio,int distancia,Carro carro) {
		if(carro.getRecorrido()>distancia) {
			podio.getGanadores().add(carro);
			return true;
		}else {
			return false;
		}
		
	}
	
	
}



	
	
		
		
	
	
		
	
		
		
	


