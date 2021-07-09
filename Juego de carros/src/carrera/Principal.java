package carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import baseDeDatos.Probar;


public class Principal {
	
	public static void menu(){
		
		Scanner sc = new Scanner(System.in);
		
		int distancia = sc.nextInt();
		
		
	}
	
	
	public static void main(String[] args) {
		
		//menu();
		
		int numerodejugadores = 0;
		
		 Scanner teclado=new Scanner(System.in);

	       int op1=0;
	        

	        System.out.println("Bienvenido a la tienda virtual supermercados Exito");
	        System.out.println("seleccione una categoria de su interes.");


	        System.out.println("1 - 2 jugadores");
	        System.out.println("2 - 3 jugadores");
	        

	        op1=Integer.parseInt(teclado.next());


	        switch (op1){
	            case 1:
	            	numerodejugadores = 2;

	               break;
	            case 2:
	            	break;
	        }
	        
	        System.out.println(numerodejugadores);
	        
	        
	        



	                    //break;
		
		
		
		/**Pista pista = new Pista(5000);
		
		int numeroDeCarros = 3;
		
		int cont = 0;
		
		ArrayList<Carro> carros = new ArrayList<Carro>();
		
		while(numeroDeCarros > cont) {
			
			Carro carro = new Carro(cont); 
			
			carros.add(carro);
			
			//System.out.println(carro.idCarro);
			
			cont++;
			
			
		}
		*/
		
		Probar probar = new Probar();
		
		
		
		
		
		Juego juego = new Juego(1,5,true);
		
		int distancia = 1000;
		

		
		
		
		/***while(juego.play) {
				juego.jugar(distancia,probar.obtenerConductores());
				
				
			} */
		
		
	
			
		
		
		
		
		
		
		
		
		
		
		
	}

}
