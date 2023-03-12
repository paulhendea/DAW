package EstructurasDeDatos.Ej18;

public class Elemento2 {
	//ATRIBUTTES
	private String producto;
	private double precio;
	private int cantidad;
	
	//CONSTRUCTOR
	public Elemento2(String producto, double precio, int cantidad) {
		this.producto = producto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	//GETTERS
	public String getProducto() {
		return producto;
	}
	public double getPrecio() {
		return precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	
	//SETTERS
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	//METHODS
	public String toString() {
		return String.format("%s: %.2f Unidades: %d Subtotal: %.2f%n", 
				producto, precio, cantidad, precio*cantidad);
	}
}
