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

public class Probar {
	
	static Conectar con = new Conectar();
	
	static Connection cn = null;
	java.sql.Statement stm = null;
	static ResultSet rs = null;
	
	/***public static void insertar (Connection cn, Conectar con, ResultSet rs, int id, String nombre) {
		
		PreparedStatement ps;
		
		try {
			
			cn = con.getConnection();
			ps = (PreparedStatement) cn.prepareStatement("INSERT INTO jugadores (id,nombre) VALUES (?,?)");
			ps.setInt(1, id);
			ps.setString(2, nombre);
			
			int res = ps.executeUpdate();
			System.out.println(res);
			
			if(res > 0) {
				System.out.println("registro guardado");
			} else {
				System.out.println("error al guardar");
			}
			
			cn.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	} 
	*/
	
	/**public static ResultSet buscar (Connection cn, Conectar con, int id) {
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			
			cn = con.getConnection();
			ps = (PreparedStatement) cn.prepareStatement("SELECT * FROM jugadores WHERE id=?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			/***if(rs.next()) {
				String nombre = rs.getString(2);
				
				System.out.println(id + " -" + nombre);
				
			} else {
				System.out.println("no se encontró");
			}
			
			
			cn.close();
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return rs;
	}  */
	
   public static ResultSet consultar (Connection cn, Conectar con) {
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			
			cn = con.getConnection();
			ps = (PreparedStatement) cn.prepareStatement("SELECT * FROM jugadores");
			
			
			rs = ps.executeQuery();
			
			/***if(rs.next()) {
				String nombre = rs.getString(2);
				
				System.out.println(id + " -" + nombre);
				
			} else {
				System.out.println("no se encontró");
			}
			
			
			cn.close();
			*/
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return rs;
	}  
	
	
	
	
	/**public static void actualizar(Connection cn, Conectar con, ResultSet rs, int id, String nombre) {
		
		PreparedStatement ps;
		
		try {
			
			cn = con.getConnection();
			ps = (PreparedStatement) cn.prepareStatement("UPDATE usuario SET nombre=? WHERE id=? ");
			ps.setString(1, nombre);
			ps.setInt(2, id);
			
			int res = ps.executeUpdate();
			System.out.println(res);
			
			if(res > 0) {
				System.out.println("registro modificado");
			} else {
				System.out.println("error al modificar");
			}
			
			cn.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
	} */
	
	public static ArrayList<Jugador> traerJugadores(ResultSet rs) {
		
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		try {
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				int vecesGanadas = rs.getInt(3);
				
				//System.out.println(id + " -" + nombre + "-" + vecesGanadas);
				
				Jugador jugador = new Jugador(id,nombre,vecesGanadas);
				
				jugadores.add(jugador);	
								
					
			}
			
		} catch (Exception e) {
			System.err.println(e);
			
		}
		
		return jugadores;
			
			
		}
	
	public static ArrayList<Conductor> conductores(int numeroDeConductores, ArrayList<Jugador> jugadores){
		
		ArrayList<Conductor> conductores = new ArrayList<Conductor>();
		
		int cont = 0;
		
		while(numeroDeConductores > cont) {
			
			Carro carro = new Carro(cont);
			
			int id = jugadores.get(cont).getIdJugador();
			
			String nombre = jugadores.get(cont).getNombreJugador();
			
			int veces = jugadores.get(cont).getVecesGanadas();
			
			Conductor conductor = new Conductor(id,nombre,veces,carro);
			
			//System.out.println("id: " + conductor.getIdJugador() + " nombre: " + conductor.getNombreJugador() + " veces: " + conductor.getVecesGanadas() + " carro: " + conductor.getCarro().idCarro);
			
			conductores.add(conductor);
			
			//System.out.println(conductor.getIdJugador());
			
			//System.out.println(carro.idCarro); 
			
			cont++;
			
			
			
			
		} 
		return conductores;
		
	} 
	
	public static ArrayList<Conductor> obtenerConductores() {
		rs = consultar(cn,con);
		ArrayList<Conductor> conductores1 = new ArrayList<Conductor>();
		conductores1 = conductores(3,traerJugadores(rs));
		//System.out.println(conductores1);
		
		return conductores1;
		
	}


		
		
	
	
	

	public static void main(String[] args) {
		
		
		//System.out.println(obtenerConductores());
		
		
		
		//insertar(cn,con,rs,14,"andrea");
		
		//actualizar(cn,con,rs,14,"gabi");
		
		
		
		
		//System.out.println(traerJugadores(rs).get(0).getNombreJugador());
		//System.out.println(conductores(3,traerJugadores(rs)));
		
		
		/***
		
		for(Conductor conductor :conductores(3,traerJugadores(rs))) {
			
			conductores1.add(conductor);
			
			
		}
		
		System.out.println(conductores1); */
		
		
		

		
		
		
		/**
		
		try {
			if(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				
				System.out.println(id + " -" + nombre);
				
			} else {
				System.out.println("no se encontró");
			}
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
		
		
		
		
		
		try {
			cn = con.getConnection();
			stm = cn.createStatement();
			rs = stm.executeQuery("SELECT * FROM usuario");
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String nombre = rs.getString(2);
				
				System.out.println(id + " -" + nombre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(stm != null) {
					stm.close();
				}
				if(cn != null) {
					cn.close();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} */
		

	} 

}

