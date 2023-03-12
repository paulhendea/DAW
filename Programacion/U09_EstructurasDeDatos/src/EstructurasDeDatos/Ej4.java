package EstructurasDeDatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.lang.String;

public class Ej4 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//CREAMOS ARRAYLIST Y GUARDAMOS VALORES
		ArrayList<String> palabras = new ArrayList<String>();
		for(int i = 0; i < 10; i++) {
			String palabra = null;
			
			System.out.printf("Introduce la palabra %d: ", i);
			palabra = input.nextLine();
			if(palabra.matches("[[a-z][A-Z]ñ]*")) {
				palabras.add(palabra);
			}
			else {
				System.err.println("Debes introducir solo una palabra");
				i--;
			}
			
		}
		
		//ORDENAMOS VALORES
		for(int i = 0; i < palabras.size(); i++) {
			palabras.set(i, palabras.get(i).toLowerCase());
		}
		Collections.sort(palabras);
		
		//MOSTRAMOS VALORES
		System.out.println("\nLista de palabras ordenadas");
		for(int i = 0; i < palabras.size()-1; i++) {
			System.out.printf("%s, ", palabras.get(i));
		} System.out.printf("%s. %n", palabras.get(palabras.size()-1));
		
		input.close();
	}
}
