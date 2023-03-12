package EstructurasDeDatos;

import java.util.ArrayList;

public class Ej1 {

	public static void main(String[] args) {
		//CREAMOS ARRAYLIST Y GUARDAMOS VALORES
		ArrayList<String> nombres = new ArrayList<String>();
		nombres.add("Santi");
		nombres.add("Alberto");
		nombres.add("Borja");
		nombres.add("Juan Carlos");
		nombres.add("Manel");
		nombres.add("Sandra");
		
		//MOSTRAMOS NOMBRES POR PANTALLA USANDO UN BUCLE
		for(String nombre: nombres) {
			System.out.println(nombre);
		}

	}

}
