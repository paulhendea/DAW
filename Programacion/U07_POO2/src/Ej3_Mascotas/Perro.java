package Ej3_Mascotas;

public class Perro extends Mascotas {
	//ATRIBUTOS
	private String raza;
	private boolean pulgas;
	
	//CONSTRUCTOR
	public Perro(String nombre, String estado, String fechaNacimiento, 
			String raza, boolean pulgas) {
		super(nombre, estado, fechaNacimiento);
		this.raza = raza;
		this.pulgas = pulgas;
	}
	
	//GETTERS Y SETTERS
	public String getRaza() {
		return raza;
	}
	public boolean getPulgas() {
		return pulgas;
	}
	public String getTipo() {
		return "Perro";
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public void setPulgas(boolean pulgas) {
		this.pulgas = pulgas;
	}
	
	//METODO
	public void mostrarInfo() {
		System.out.printf("Perro %s%n", super.getNombre());
		System.out.printf("Raza: %s%n", raza);
		System.out.printf("Fecha de nacimiento: %s%n", super.getFechaNacimiento());
		System.out.printf("Edad: %d%n", super.getEdad());
		if(pulgas == true) {
			System.out.println("Tiene pulgas");
		}
		else {
			System.out.println("No tiene pulgas");
		}
		System.out.printf("Estado: %s%n", super.getEstado());
		System.out.println();
	}
	public void habla(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println("Guau");
		}
	}
}
