package co.com.persistencia.modelo;

// Representa la tabla Vendedor
public class Vendedor {
	
	
	//Representan los atributos de la tabla 
	private int documentoVendedor;
	
	private String nombres;
	
	private String apellidos;
	
	private String ciudad;

	public int getDocumentoVendedor() {
		return documentoVendedor;
	}

	public void setDocumentoVendedor(int documentoVendedor) {
		this.documentoVendedor = documentoVendedor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	
	
	

}
