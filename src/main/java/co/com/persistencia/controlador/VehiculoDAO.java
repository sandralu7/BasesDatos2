package co.com.persistencia.controlador;

import java.sql.*;
import co.com.persistencia.modelo.*;
import java.util.*;
import java.text.*;
import javax.swing.*;

public class VehiculoDAO {
	
	public List<Vehiculo> buscarVehiculos(){
		
		Conexion conexion = new Conexion ();
		List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		Vehiculo vehiculo;
		
		
			try {
				Statement statement = conexion.getConnection().createStatement();
				String consulta = "SELECT * FROM Vehiculos";
				ResultSet resultado = statement.executeQuery(consulta);
				
				while (resultado.next()) {
					vehiculo = new Vehiculo();
					vehiculo.setPlaca(resultado.getString("placa"));
					vehiculo.setMarca(resultado.getString("marca"));
					vehiculo.setModelo(resultado.getString("modelo"));
					vehiculo.setKilometraje(resultado.getInt("kilometraje"));
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					if(resultado.getDate("fecha_venta")!= null) {
						vehiculo.setFechaVenta(sdf.format(resultado.getDate("fecha_venta")));
					}
					Vendedor vendedor = new Vendedor();
					vendedor.setDocumentoVendedor(resultado.getInt("documento_vendedor"));
					vehiculo.setVendedor(vendedor);
					
					vehiculos.add(vehiculo);
				}
				
				conexion.desconectar();
				
				
			} catch (SQLException e) {
				System.out.println("Ocurrió un error al consultar " + e.getMessage());
				JOptionPane.showMessageDialog(null, "Error al consultar", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
			return vehiculos;
		
		
		
	}

}
