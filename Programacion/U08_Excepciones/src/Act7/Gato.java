package Act7;

public class Gato {
	//ATRIBUTOS
	private String nombre;
	private int edad;
	
	//CONSTRUCTOR
	public Gato(String nombre, int edad) throws Exception {
		if(!validarNombre(nombre) || !noNegativo(edad)) {
			throw new Exception("Valores del constructor incorrectos");
		}
		
		this.nombre = nombre;
		this.edad = edad;		
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	
	public void setNombre(String nombre) throws Exception {
		if(!validarNombre(nombre)) {
			throw new Exception("Nombre de Gato incorrecto");
		}
		
		this.nombre = nombre;
	}
	public void setEdad(int edad) throws Exception {
		if(!noNegativo(edad)) {
			throw new Exception("Edad de gato incorrecta");
		}
		
		this.edad = edad;
	}
	
	//METODOS STATIC
	public static boolean validarNombre(String nombre) {
		return nombre.matches("[A-Z][a-z]{3}.*");
	}
	public static boolean noNegativo(int n) {
		if(n < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public String toString() {
		return String.format("Gato %s de %d años", nombre, edad);
	}
}
