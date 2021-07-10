package carrera;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseDeDatos.GestionBD;




 public class Principal {
	
	static int numeroDeJugadores = 0;
	static int distancia = 0;
	
	public static void menu(){
		
		 Scanner teclado=new Scanner(System.in);
		 
	       int op2=0;
	       
	       System.out.println("Empieza juego");
	       
	       System.out.println("Ingrese distancia de la pista");
	       
	        
	       distancia=Integer.parseInt(teclado.next());

	        
	        System.out.println("¿cuántos jugadores?, elija una opción 1 a 4");


	        System.out.println("1 - 2 jugadores");
	        System.out.println("2 - 3 jugadores");
	        System.out.println("3 - 4 jugadores");
	        System.out.println("4 - 5 jugadores");
	        

	        op2=Integer.parseInt(teclado.next());
	        


	        switch (op2){
	            case 1:
	            	numeroDeJugadores = 2;

	               break;
	            case 2:
	            	numeroDeJugadores = 3;
	            	break;
	            case 3:
	            	numeroDeJugadores = 4;
	            	break;
	            case 4:
	            	numeroDeJugadores = 5;
	            	break;
          	
	        }
	        
	        System.out.println("distancia de la pista: "+ distancia);
	        System.out.println("numero de jugadores: "+ numeroDeJugadores);
	        
	       
		
		
	}
	
	public static void partida(Podio podio, Juego juego, ArrayList<Carro> carros, ArrayList<Conductor> conductor) {
		
		
		while(juego.isPlay()) {
			
				juego.jugar(podio,distancia,carros,conductor);
						
			}
	}
	
	public static ArrayList<Carro> obtenerCarros(ArrayList<Conductor> conductores){
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		for(Conductor conductor : conductores) {
			
			carros.add(conductor.getCarro());
		} 
		
		return  carros;
		
	}
	
	
	public static void main(String[] args) {
		
		menu();
		
		Pista pista = new Pista(distancia);
		
		GestionBD gestor = new GestionBD();
		
		ArrayList<Conductor> conductores = new ArrayList<Conductor>();
		
		conductores = gestor.obtenerConductores(numeroDeJugadores);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String codigoUnico = dtf.format(LocalDateTime.now());
		
		Juego juego = new Juego(codigoUnico,true);
		
		gestor.insertarJugadoresCarrera(codigoUnico,conductores,distancia);
		
		Podio podio = new Podio();
		
		partida(podio,juego,obtenerCarros(conductores),conductores);
		
		podio.premiación(); 
		

	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
			
		
		
		
		
		
		
		
		
		
		
		
	}

}
