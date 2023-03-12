package EstructurasDeDatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ej3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//CREAMOS ARRAYLIST Y GUARDAMOS VALORES
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++) {
			try {
				System.out.printf("Introduce el n�mero entero %d: ", i);
				numeros.add(input.nextInt());
			}
			catch (InputMismatchException e) {
				System.err.println("Error: El n�mero debe ser entero");
				e.printStackTrace();
				input.nextLine();
				i--;
			}
		}
		
		//ORDENAMOS VALORES
		Collections.sort(numeros);
		
		//MOSTRAMOS VALORES
		System.out.println("\nLista de n�meros enteros");
		for(int n: numeros) {
			System.out.printf("%d, ", n);
		}
		
		input.close();
	}

}
