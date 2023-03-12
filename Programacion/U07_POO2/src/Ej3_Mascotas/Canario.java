package Ej3_Mascotas;

public class Canario extends Aves {
	//ATRIBUTOS
	private String color;
	private boolean canta;
	
	//CONSTRUCTOR
	public Canario(String nombre, String estado, String fechaNacimiento, 
			String pico, boolean vuela, String color, boolean canta) {
		super(nombre, estado, fechaNacimiento, pico, vuela);
		this.color = color;
		this.canta = canta;
	}
	
	//GETTERS Y SETTERS
	public String getColor() {
		return color;
	}
	public boolean getCanta() {
		return canta;
	}
	public String getTipo() {
		return "Canario";
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setCanta(boolean canta) {
		this.canta = canta;
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Canario %s %s%n", color, super.getNombre());
		System.out.printf("Fecha de nacimiento: %s%n", super.getFechaNacimiento());
		System.out.printf("Edad: %d%n", super.getEdad());
		System.out.printf("Pico %s%n", super.getPico());
		if(super.getVuela()) {
			System.out.println("Puede volar");
		}
		else {
			System.out.println("No puede volar");
		}
		if(canta) {
			System.out.println("Puede cantar");
		}
		else {
			System.out.println("No puede cantar");
		}
		System.out.printf("Estado: %s%n", super.getEstado());
		System.out.println();
	}
	public void habla(int n) {
		System.out.printf("%s %s:%n", getTipo(), super.getNombre());
		if(canta) {
			for(int i = 0; i < n; i++) {
				System.out.println("<Sonata No 16 C major K545 Mozart>");
			}
		}
		else {
			for(int i = 0; i < n; i++) {
				System.out.println("Pio pio");
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
