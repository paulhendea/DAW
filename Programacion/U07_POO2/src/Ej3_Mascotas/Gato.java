package Ej3_Mascotas;

public class Gato extends Mascotas {
	//ATRIBUTOS
	private String color;
	private boolean peloLargo;
	
	//CONSTRUCTOR
	public Gato(String nombre, String estado, String fechaNacimiento, 
			String color, boolean peloLargo) {
		super(nombre, estado, fechaNacimiento);
		this.color = color;
		this.peloLargo = peloLargo;
	}
	
	//GETTERS Y SETTERS
	public String getColor() {
		return color;
	}
	public boolean getPeloLargo() {
		return peloLargo;
	}
	public String getTipo() {
		return "Gato";
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	public void setPeloLargo(boolean peloLargo) {
		this.peloLargo = peloLargo;
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Gato %s %s%n", color, super.getNombre());
		System.out.printf("Fecha de nacimiento: %s%n", super.getFechaNacimiento());
		System.out.printf("Edad: %d%n", super.getEdad());
		if(peloLargo == true) {
			System.out.println("Tiene el pelo largo");
		}
		else {
			System.out.println("Tiene el pelo corto");
		}
		System.out.printf("Estado: %s%n", super.getEstado());
		System.out.println();
	}
	public void habla(int n) {
		System.out.println("Meow");
	}
}
