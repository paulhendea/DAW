package Ej3_Mascotas;

public abstract class Aves extends Mascotas {
	//ATRIBUTOS
	private String pico; //TIPO
	private boolean vuela;
	
	//CONSTRUCTOR
	public Aves(String nombre, String estado, String fechaNacimiento, 
			String pico, boolean vuela) {
		super(nombre, estado, fechaNacimiento);
		this.pico = pico;
		this.vuela = vuela;
	}
	
	//GETTERS Y SETTERS
	public String getPico() {
		return pico;
	}
	public boolean getVuela() {
		return vuela;
	}
	
	public void setPico(String pico) {
		this.pico = pico;
	}
	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}
	
	//METODOS
	public abstract void volar();
}