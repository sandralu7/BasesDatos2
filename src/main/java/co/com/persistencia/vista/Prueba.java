package co.com.persistencia.vista;

import co.com.persistencia.modelo.*;
import co.com.persistencia.controlador.*;
import java.util.*;



public class Prueba {

	public static void main(String[] args) {
		
		List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		
		VehiculoDAO vehiculoDAO = new VehiculoDAO();
		
		listaVehiculos = vehiculoDAO.buscarVehiculos();
		
		for (Vehiculo vehiculo : listaVehiculos) {
			System.out.println("Placa: " + vehiculo.getPlaca());
			
		}
		
		Vendedor vendedor = new Vendedor();
		vendedor.setDocumentoVendedor(4789);
		vendedor.setNombres("Paola");
		vendedor.setApellidos("Moreno");
		vendedor.setCiudad("Tunja");
		
		VendedorDAO vendedorDAO = new VendedorDAO();
		vendedorDAO.guardarVendedor(vendedor);
		
		System.out.println("Se guardo el Vendedor");
		

	}

}
