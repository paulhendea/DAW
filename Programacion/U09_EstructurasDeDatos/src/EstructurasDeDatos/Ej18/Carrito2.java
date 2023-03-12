package EstructurasDeDatos.Ej18;

import java.util.ArrayList;

public class Carrito2 {
	//ATRIBUTTES
	private ArrayList<Elemento2> carrito;
	
	//CONSTRUCTOR
	public Carrito2() {
		carrito = new ArrayList<Elemento2>();
	}
	
	//GETTERS
	public int numeroDeElementos() {
		return carrito.size();
	}
	public double importeTotal() {
		double total = 0;
		for(Elemento2 e: carrito) {
			total += e.getPrecio() * e.getCantidad();
		}
		return total;
	}
	
	//SETTERS
	public void agrega(Elemento2 e2) {
		//SI EL ELEMENTO NO ESTÁ EN EL CARRITO LO AGREGAMOS
		if(getIndexOf(e2) == -1) {
			carrito.add(e2);
		}
		//SI YA EXISTE LO MODIFICAMOS
		else {
			Elemento2 e1 = (Elemento2) carrito.get(getIndexOf(e2));
			e1.setCantidad(e1.getCantidad() + e2.getCantidad());
		}
	}
	
	//PRIVATE METHODS
	private int getIndexOf(Elemento2 e2) {
		//SI NO SE ENCUENTRA SE DEVUELVE -1
		int posicion = -1;
		
		for(int i = 0; i < carrito.size(); i++) {
			Elemento2 e1 = (Elemento2) carrito.get(i);
			
			//SI SE ENCUENTRA DEVUELVE LA POSICION
			if(e1.getProducto().matches(e2.getProducto())) {
				posicion = i;
				break;
			}
		}
		return posicion;
	}
	
	//METHODS
	public String toString() {
		String carrito = "Contenido del carrito\n"
						+ "=====================\n";
		for(Elemento2 e: this.carrito) {
			carrito += e;
		}
		return carrito;
	}
}
