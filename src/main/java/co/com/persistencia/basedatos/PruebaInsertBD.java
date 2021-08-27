package co.com.persistencia.basedatos;

import java.sql.*;



public class PruebaInsertBD {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establecer conexión con la base de datos
			String url = "jdbc:mysql://localhost:8889/concesionario";
			Connection conexion = DriverManager.getConnection(url, "root", "root");
			
			//Añadir un registro sobre vendedores
			String sentencia = "INSERT INTO Vendedores (documento_vendedor, nombres, apellidos, ciudad)"
					+ " VALUES ('1476', 'Pablo', 'Pérez', 'Cartagena')";
			Statement consulta = conexion.createStatement();
			
			consulta.executeUpdate(sentencia);
			
			//Cerrar la conexión
			conexion.close();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
