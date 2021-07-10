package carrera;

import java.util.ArrayList;
import java.util.List;

public class Podio {
	
	private ArrayList<Carro> ganadores = new ArrayList<Carro>();

	public ArrayList<Carro> getGanadores() {
		return ganadores;
	}

	public void setGanadores(ArrayList<Carro> ganadores) {
		this.ganadores = ganadores;
	}
	
	
	
	
	




	public void premiación() {
		System.out.println("primer puesto: " + ganadores.get(0).getIdCarro());
		System.out.println("segundo puesto: " + ganadores.get(1).getIdCarro());
		System.out.println("tercer puesto: " + ganadores.get(2).getIdCarro());
		
		
	} 

}
