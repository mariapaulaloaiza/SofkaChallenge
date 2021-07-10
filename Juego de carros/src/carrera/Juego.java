package carrera;

import java.util.ArrayList;

public class Juego {
	
	private String idJuego;
	
	private boolean play;
	
	 private ArrayList<String> posicion = new ArrayList<String>();
	
	public Juego(String idJuego, boolean play) {
		this.idJuego = idJuego;
		this.play = play;
		this.posicion.add("Queda en primer puesto");
		this.posicion.add("Queda en segundo puesto");
		this.posicion.add("Queda en tercer puesto");
		this.posicion.add("");
		this.posicion.add("");
	}
	

	public String getIdJuego() {
		return idJuego;
	}



	public void setIdJuego(String idJuego) {
		this.idJuego = idJuego;
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
	
	
	
	public ArrayList<String> getPosicion() {
		return posicion;
	}


	public void setPosicion(ArrayList<String> posicion) {
		this.posicion = posicion;
	}


	public ArrayList<String> primerosPuestos(){
		
		
		
		return posicion;
		
	}
	
	public void jugar(Podio podio,int distancia, ArrayList<Carro> carros, ArrayList<Conductor> conductor) {
		
		for(int i= 0; carros.size()>i; i++) {
			
			if(carros.size()==0) {
				
				setPlay(false);
				
				break;
				
			}else {
				
				jugada(i,podio,distancia,carros,conductor);
				
			}
			
		}
			
	}
		
		
	
	
	public void jugada(int i, Podio podio,int distancia, ArrayList<Carro> carros, ArrayList<Conductor> conductor) {
		
		int dado = tirarDado();
		
		System.out.println("Turno conductor"+ conductor.get(i).getIdJugador()+" "+"resultado del dado: "+ dado);
		
		carros.get(i).avanzar(dado);
		
		System.out.println("conductor" + conductor.get(i).getIdJugador()+ " con carro" + carros.get(i).getIdCarro()+ " avance: "+ carros.get(i).getRecorrido()+"\n");
		
		if(pasoMeta(podio, distancia,carros.get(i))) {
			
			System.out.println("pasó la meta el carro"+carros.get(i).getIdCarro()+" "+getPosicion().get(0)+ "\n");
			
			getPosicion().remove(0);
			
			carros.remove(i);
		
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



	
	
		
		
	
	
		
	
		
		
	


