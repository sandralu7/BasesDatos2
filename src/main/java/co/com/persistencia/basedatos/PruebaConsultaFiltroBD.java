package co.com.persistencia.basedatos;

import java.sql.*;

public class PruebaConsultaFiltroBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String placa;
		String marca;
		String modelo;
		int kilometraje;
		
		
		try {
			//Cargar el Driver de MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establecer la conexión con la base de datos
			String url = "jdbc:mysql://localhost:8889/concesionario";
			Connection conexion = DriverManager.getConnection(url, "root", "root");
			
			//Crear la Sentencia
			String sentencia = "SELECT placa, marca, modelo, kilometraje FROM Vehiculos "
					+ "where marca = ?"; 
			PreparedStatement consulta = conexion.prepareStatement(sentencia);
			
			//Pasar el parámetro
			consulta.setString(1, "Renault");
			
			//Ejecutar consulta y obtener los resultados en un ResultSet
			ResultSet resultados = consulta.executeQuery();
			while (resultados.next()) {
				placa = resultados.getString("placa");
				marca = resultados.getString("marca");
				modelo = resultados.getString("modelo");
				kilometraje = resultados.getInt("kilometraje");
				
				System.out.println("Listado de Vehículos");
				System.out.println("Placa: " + placa + ", Marca: " + marca + ", Modelo: "+ modelo 
						+ ", Kilometraje: " + kilometraje);
				
				
			}
			
			//cerrar la conexión
			conexion.close();
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("No fue posible cargar el Driver. ");
		} catch (SQLException e) {
			System.out.println("Hubo un errror al acceder a la base de datos: " + e.getMessage());
		}
		
		

	}

}
