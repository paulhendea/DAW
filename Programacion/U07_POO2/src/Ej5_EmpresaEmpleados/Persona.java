package Ej5_EmpresaEmpleados;

public abstract class Persona {
	//ATRIBUTOS
	private final String NOMBRE;
	private final String IDFiscal; //IDENTIFICACIÓN FISCAL
	private String telefono = null;
	private String direccion = null;
	
	//CONSTRUCTOR
	public Persona(String NOMBRE, String IDFiscal) {
		this.NOMBRE = NOMBRE;
		this.IDFiscal = IDFiscal;
	}
	public Persona(String NOMBRE, String IDFiscal, String telefono, String direccion) {
		this.NOMBRE = NOMBRE;
		this.IDFiscal = IDFiscal;
		this.telefono = telefono;
		this.direccion = direccion;
	}
	
	//GETTERS
	public String getNombre() {
		return NOMBRE;
	}
	public String getID() {
		return IDFiscal;
	}
	public String getTelefono() {
		return telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	
	//SETTERS
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//METODOS
	public abstract void mostrarInfo();
}
