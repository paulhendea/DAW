package EstructurasDeDatos.Ej17;

public class Elemento {
	//ATRIBUTTES
	private String producto;
	private double precio;
	private int cantidad;
	
	//CONSTRUCTOR
	public Elemento(String producto, double precio, int cantidad) {
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
	
	//METHODS
	public String toString() {
		return String.format("%s: %.2f Unidades: %d Subtotal: %.2f%n", 
				producto, precio, cantidad, precio*cantidad);
	}
}
