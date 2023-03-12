package Act8;

public class Persona {
	//ATRIBUTOS
	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String email;
	private Fecha fechaNacimiento;
	
	//CONSTRUCTOR
	public Persona(String dni, String nombre, String email, Fecha fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	public Persona(String dni, String nombre, String apellidos, String direccion, 
			String email, Fecha fechaNacimiento) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//GETTERS Y SETTERS
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getEmail() {
		return email;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento.toString();
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFechaNacimiento(Fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//METODOS
	public String toString() {
		return nombre + " " + apellidos + " con DNI " + dni;
	}
}
