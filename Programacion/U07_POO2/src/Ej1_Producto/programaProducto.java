package Ej1_Producto;

import java.util.ArrayList;
import java.util.Iterator;

public class programaProducto {

	public static void main(String[] args) {
		//CREAMOS ARRAYLIST
		ArrayList<Producto> lista = new ArrayList<Producto>();
				
		//AGRAGAMOS INSTANCIAS
		lista.add(new Producto("Lapiz", 20));
		lista.add(new Producto("Boli", 15));
		lista.add(new Producto("Goma borrar", 5));
		lista.add(new Producto("Hojas A4", 100));
		lista.add(new Producto("Estuche", 10));
		
		//VISUALIZAMOS EL CONTENIDO
		for(Iterator<Producto> it = lista.iterator(); it.hasNext(); ) {
			Producto p = (Producto)it.next();
			System.out.printf("%s: %d%n", p.getNombre(), p.getCantidad());
		} System.out.println();
																																																																																																																									
		//ELIMINAMOS 2 OBJETOS
		lista.remove(0);
		lista.remove(1);
		
		//INSERTAMOS UN ELEMENTO NUEVO EN MEDIO DE LA LISTA
		lista.add(2, new Producto("Tipex", 12));
		
		//VISUALIZAMOS DE NUEVO
		for(Iterator<Producto> it = lista.iterator(); it.hasNext(); ) {
			Producto p = (Producto)it.next();
			System.out.printf("%s: %d%n", p.getNombre(), p.getCantidad());
		} System.out.println();
		
		//BORRAMOS TODOS LOS VALORES DE LA LISTA
		lista.clear();
		System.out.printf("La lista tiene %d elementos %n", lista.size());
	}
}
