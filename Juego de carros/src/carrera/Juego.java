package carrera;

import java.util.ArrayList;

public class Juego {
	
	private int idJuego;
	
	public int rondas;
	
	public boolean play;
	
	private ArrayList<Conductor> ganadores = new ArrayList<Conductor>();
	
	
	public Juego(int idJuego, int rondas, boolean play) {
		this.idJuego = idJuego;
		this.rondas = rondas;
		this.play = play;
	}
	
	

	public int getIdJuego() {
		return idJuego;
	}



	public void setIdJuego(int idJuego) {
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
	
	public static void tirarDado(Conductor conductor) {
		
		//numero aleatorio de 1 a 6 para simular el lanzamiento de un dado
		
		int resultadoDado = (int)(Math.random()*6+1)*100;
		
		int x = conductor.getRecorrido();
		
		System.out.println("resultado dado: " + resultadoDado);
		
		System.out.println("recorrido antes:" + conductor.getRecorrido());
		
		x += resultadoDado;
		
		conductor.setRecorrido(x);
		
		System.out.println("conductor: "+ conductor.getNombreJugador() + " avance: " + conductor.getRecorrido());
		
		
	}
	
	public void jugar(int distancia, ArrayList<Conductor> conductores) {
		
		for (Conductor conductor: conductores) {
			tirarDado(conductor);
			finaljuego(distancia,conductores);
			
			

			
			//System.out.println("recorrido antes:" + conductor.getRecorrido());
			
			
			
			
		}
	}
		
		public void finaljuego(int distancia, ArrayList<Conductor> conductores) {
			
			for (Conductor conductor: conductores) {
				if(conductor.getRecorrido()> distancia) {
					ganadores.add(conductor);
					conductores.remove(conductor);
					if(conductores.size() == 0) {
						play = false;
						break;
						
					}
				}
				
				
				
				

				
				//System.out.println("recorrido antes:" + conductor.getRecorrido());
				
				
				
				
			}
		
	
		
		
	}

}
