package co.com.persistencia.basedatos;

import java.sql.*;

public class PruebaConsultaBD {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			int documentoVendedor;
			String nombres;
			String apellidos;
			String ciudad;
			
			//Se carga el Driver correspondiente a MySQL
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Establecer conexión con la base de datos
			//Tener en cuenta que el puerto y el host pueden cambiar y poner el 
			//usuario y contraseña de cada base de datos
			String url = "jdbc:mysql://localhost:8889/concesionario";
            Connection conexion = DriverManager.getConnection(url, "root", "root");
			
			
			
			//Se crea la consulta con la base de datos
			String sentencia = "SELECT * FROM vendedores";
			Statement consulta = conexion.createStatement();
			
			//Se crea un ResultSet con los resultados de la consulta
			ResultSet resultados = consulta.executeQuery(sentencia);
			
			while (resultados.next()) {
				documentoVendedor = resultados.getInt("documento_vendedor");
				nombres = resultados.getString("nombres");
				apellidos = resultados.getString("apellidos");
				ciudad = resultados.getString("ciudad");
				
				System.out.println("Listado de Vendedores");
				System.out.println("Documento: " + documentoVendedor);
				System.out.println("Nombres: " + nombres);
				System.out.println("Apellidos: " + apellidos);
				System.out.println("Ciudad: " + ciudad);
				
			}
			
			conexion.close();
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("No fue posible cargar el diver.");
		} catch (SQLException e) {
			System.out.println("Hubo un error " + e.getMessage());
		} 
		
		

	}

}
