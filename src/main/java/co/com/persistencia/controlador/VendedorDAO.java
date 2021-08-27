package co.com.persistencia.controlador;

import java.sql.*;
import co.com.persistencia.modelo.*;
 
public class VendedorDAO {
	
	public void guardarVendedor(Vendedor vendedor) {
		
		Conexion conexion = new Conexion();
		
		//INSERT INTO vendedores (documento_vendedor, nombres) 
		//VALUES ('123','ANDRES', 'TORRES', 'Medellin');
		String sentencia = "INSERT INTO vendedores (documento_vendedor, nombres, apellidos, ciudad)"
				+ " VALUES ('" + vendedor.getDocumentoVendedor() + "', "
						+ "'" + vendedor.getNombres() + "', "
						+ "'" + vendedor.getApellidos() + "', "
						+ "'" + vendedor.getCiudad() + "');";
		
		try {
			Statement consulta = conexion.getConnection().createStatement();
			consulta.executeUpdate(sentencia);
		} catch (SQLException e) {
			System.out.println("No se pudo realizar la insercción " + e.getMessage());
		}
		conexion.desconectar();
		
	}
	
	
	
}
