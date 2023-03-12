package EstructurasDeDatos.Ej17;

import java.util.ArrayList;

public class Carrito {
	//ATRIBUTTES
	private ArrayList<Elemento> carrito;
	
	//CONSTRUCTOR
	public Carrito() {
		carrito = new ArrayList<Elemento>();
	}
	
	//GETTERS
	public int numeroDeElementos() {
		return carrito.size();
	}
	public double importeTotal() {
		double total = 0;
		for(Elemento e: carrito) {
			total += e.getPrecio() * e.getCantidad();
		}
		return total;
	}
	
	//SETTERS
	public void agrega(Elemento e) {
		carrito.add(e);
	}
	
	//METHODS
	public String toString() {
		String carrito = "Contenido del carrito\n"
						+ "=====================\n";
		for(Elemento e: this.carrito) {
			carrito += e;
		}
		return carrito;
	}
}
