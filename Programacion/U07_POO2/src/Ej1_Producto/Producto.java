package Ej1_Producto;

public class Producto {
	//ATRIBUTOS
	private String nombre;
	private int cantidad;
	
	//CONSTRUCTOR
	public Producto(String nombre, int cantidad) {
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
