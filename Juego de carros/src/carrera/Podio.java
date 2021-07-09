package carrera;

import java.util.ArrayList;
import java.util.List;

public class Podio {
	
	public List<Carro> primerosPuestos = new ArrayList<Carro>();
	
	
	public void premiación() {
		System.out.println("primer puesto: " + primerosPuestos.get(0).idCarro);
		System.out.println("primer puesto: " + primerosPuestos.get(1).idCarro);
		System.out.println("primer puesto: " + primerosPuestos.get(2).idCarro);
		
		
	}

}
