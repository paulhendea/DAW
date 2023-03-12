package Ej3_Mascotas;

public class Loro extends Aves {
	//ATRIBUTOS
	private String origen;
	private boolean habla;
	
	//CONSTRUCTOR
	public Loro(String nombre, String estado, String fechaNacimiento, 
			String pico, boolean vuela, String origen, boolean habla) {
		super(nombre, estado, fechaNacimiento, pico, vuela);
		this.origen = origen;
		this.habla = habla;
	}
	
	//GETTERS Y SETTERS
	public String getOrigen() {
		return origen;
	}
	public boolean getHabla() {
		return habla;
	}
	public String getTipo() {
		return "Loro";
	}
	
	public void setOrgien(String origen) {
		this.origen = origen;
	}
	public void setHabla(boolean habla) {
		this.habla = habla;
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Loro %s%n", super.getNombre());
		System.out.printf("Origen: %s%n", origen);
		System.out.printf("Fecha de nacimiento: %s%n", super.getFechaNacimiento());
		System.out.printf("Edad: %d%n", super.getEdad());
		System.out.printf("Pico %s%n", super.getPico());
		if(super.getVuela()) {
			System.out.println("Puede volar");
		}
		else {
			System.out.println("No puede volar");
		}
		if(habla) {
			System.out.println("Puede hablar");
		}
		else {
			System.out.println("No puede hablar");
		}
		System.out.printf("Estado: %s%n", super.getEstado());
		System.out.println();
	}
	public void habla(int n) {
		System.out.printf("%s %s:%n", getTipo(), super.getNombre());
		if(habla) {
			for(int i = 0; i < n; i++) {
				System.out.println("Hola ¿Cómo estás?");
			}
		}
		else {
			for(int i = 0; i < n; i++) {
				System.out.println("Trua");
			}
		}
		System.out.println();
	}
	public void volar() {
		System.out.printf("%s %s:%n", getTipo(), super.getNombre());
		if(super.getVuela()) {
			System.out.println("¡Fiuuuuuu!");
		}
		else {
			System.out.println("(Intenta volar pero no puede)");
		}
		System.out.println();
	}
}
