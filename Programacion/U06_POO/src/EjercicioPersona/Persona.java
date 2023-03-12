package EjercicioPersona;

public class Persona {
	//ATRIBUTOS
	private final String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private static final int mayoriaEdad = 18;
	
	//CONSTRUCTOR
	public Persona(String dni, String nombre, String apellidos, int edad) {
		if (validarDNI(dni)) {
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.edad = edad;
		}
		else {
			this.dni = null;
			System.err.println("ERROR: DNI incorrecto");
		}
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
	public int getEdad() {
		return edad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	//METODOS
	public void imprime() {
		System.out.printf("DNI: %S%n", dni);
		System.out.printf("Nombre: %s%n", nombre);
		System.out.printf("Apellidos: %s%n", apellidos);
		System.out.printf("Edad: %d%n", edad);
	}
	public boolean esMayorEdad() {
		if( edad < mayoriaEdad) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean esJubilado() { 
		if (edad < 65) {
			return false;
		}
		else {
			return true;
		}
	}
	public int diferenciaEdad(Persona p) {
		return positivo(edad - p.getEdad());
	}
	private int positivo(int n) {
		if (n < 0) {
			n = -n;
		} 
		return n;
	}
	
	//STATIC
	public static boolean validarDNI(String dni) {
		return dni.matches("[0-9]{8}[A-Z]");
	}
}
