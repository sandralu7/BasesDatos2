package co.com.persistencia.modelo;

import java.sql.*;

public class Conexion {
	
	static String bd = "concesionario";
	static String login = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:8889/" + bd;
	
	Connection conexion = null;
	
	public Conexion() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conexion = DriverManager.getConnection(url, login, password);
			
			if(conexion!=null) {
				System.out.println("Conexión a la base de datos " + bd + "fue satisfactoria");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println("Se presentaron problemas al cargar el Driver");
		} catch (SQLException e) {
			System.out.println("Se presentó un problema al acceder a la base de datos: " + e.getMessage());
		}
		
	}
	
	public Connection getConnection() {
		return conexion;
	}
	
	public void desconectar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("Ocurrio un error cerrando la conexión");
		}
		conexion = null;
	}
	

}
