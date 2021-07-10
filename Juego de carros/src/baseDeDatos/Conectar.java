package baseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
	
	private static Connection conn;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/juegocarros";
	
	public Conectar() {
		conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			if(conn != null) {
				System.out.println("conexion establecida");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("error al conectar" + e);
			
		}
	}
	
	// nos retorna la conexion
	public Connection getConnection() {
		return conn;
	}
	
	
}
