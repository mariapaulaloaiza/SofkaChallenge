package baseDeDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import carrera.Carro;
import carrera.Conductor;
import carrera.Jugador;

public class GestionBD {
	
	static Conectar con = new Conectar();
	
	static Connection cn = null;
	
	java.sql.Statement stm = null;
	
	static ResultSet rs = null;
	
	
	//funcion para insertar en la tabla "carreras"
	public static void insertar (Connection cn, Conectar con, ResultSet rs, int idJuego, int conductor, int carro, int pista) {
		
		PreparedStatement ps;
		
		try {
			
			cn = con.getConnection();
			
			ps = (PreparedStatement) cn.prepareStatement("INSERT INTO carreras (idJuego,conductor,carro,pista) VALUES (?,?,?,?)");
			
			ps.setInt(1, idJuego);
			
			ps.setInt(2, conductor);
			
			ps.setInt(2, carro);
			
			ps.setInt(3, pista);
			
			if(ps.executeUpdate() > 0) {
				
				System.out.println("registro guardado");
				
			} else {
				
				System.out.println("error al guardar");
			}
			
			cn.close();
			
		} catch (Exception e) {
			
			System.err.println(e);
	}
} 
	
	
	
	//Trae toda la tabla jugadores
   public static ResultSet consultar (Connection cn, Conectar con) {
		
		PreparedStatement ps;
		
		ResultSet rs = null;
		
		try {
			
			cn = con.getConnection();
			
			ps = (PreparedStatement) cn.prepareStatement("SELECT * FROM jugadores");
			
			rs = ps.executeQuery();
			
			
		} catch (Exception e) {
			
			System.err.println(e);
		}
		
		return rs;
	}  
	
	
	
	//actualiza al ganador de la carrera
	public static void actualizarGanador(Connection cn, Conectar con, ResultSet rs, int id) {
		
		PreparedStatement ps;
		
		try {
			
			cn = con.getConnection();
			
			ps = (PreparedStatement) cn.prepareStatement("UPDATE carreras SET ganador=1 WHERE id=? ");
			
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			
			
			if(res > 0) {
				
				System.out.println("registro modificado");
				
			} else {
				
				System.out.println("error al modificar");
			}
			
			cn.close();
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
	} 
	
	//actualiza las veces ganadas del jugador
	public static void actualizarJugador(Connection cn, Conectar con, ResultSet rs, int id, int vecesGanadas) {
		
		PreparedStatement ps;
		
		try {
			
			cn = con.getConnection();
			
			ps = (PreparedStatement) cn.prepareStatement("UPDATE jugadores SET vecesGanadas=? WHERE id=? ");
			
			ps.setInt(1, id);
			
			ps.setInt(2, vecesGanadas);
			
			int res = ps.executeUpdate();
			
			
			if(res > 0) {
				
				System.out.println("registro modificado");
				
			} else {
				
				System.out.println("error al modificar");
			}
			
			cn.close();
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
	} 
	
	
	
	//inserta los jugadores de la base de datos en una lista para facilitar el manejo
	public static ArrayList<Jugador> traerJugadores(ResultSet rs) {
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		try {
			
			while(rs.next()) {
				
				int id = rs.getInt(1);
				
				String nombre = rs.getString(2);
				
				int vecesGanadas = rs.getInt(3);
				
				Jugador jugador = new Jugador(id,nombre,vecesGanadas);
				
				jugadores.add(jugador);	
								
					
			}
			
		} catch (Exception e) {
			
			System.err.println(e);
			
		}
		
		return jugadores;
			
			
		}
	
	//inserta una lista los jugadores que van a ser conductores en la partida
	public static ArrayList<Conductor> conductores(int numeroDeConductores, ArrayList<Jugador> jugadores){
		
		ArrayList<Conductor> conductores = new ArrayList<Conductor>();
		
		int cont = 0;
		
		while(numeroDeConductores > cont) {
			
			Carro carro = new Carro(cont);
			
			Conductor conductor = new Conductor(jugadores.get(cont).getIdJugador(),jugadores.get(cont).getNombreJugador(),
					jugadores.get(cont).getVecesGanadas(),carro);
			
			conductores.add(conductor);
		
			cont++;	
			
		} 
		
		return conductores;
		
	} 
	
	
	public static ArrayList<Conductor> obtenerConductores(int numeroDeConductores) {
		
		rs = consultar(cn,con);
		
		ArrayList<Conductor> conductores = new ArrayList<Conductor>();
		
		conductores = conductores(numeroDeConductores,traerJugadores(rs));
		
		return conductores;
		
	}


	

}

