package EstructurasDeDatos;

import java.util.ArrayList;
import java.lang.Math;

public class Ej2 {

	public static void main(String[] args) {
		//CREAMOS ARRAYLIST Y GUARDAMOS VALORES
		ArrayList<Integer> num = new ArrayList<Integer>();
		int listaSize = (int) (Math.random() * 10) + 10;
		
		for(int i = 0; i < listaSize; i++) {
			num.add((int) (Math.random() * 100.0));
		}

		//CALCULAMOS LA SUMA, MEDIA, MAX Y MIN
		int suma = 0, max = 0, min = num.get(0);
		for(int n: num) {
			suma += n;
			max = Math.max(max, n);
			min = Math.min(min, n);
		}
		double media = (double) suma / (double) listaSize;
		
		//MOSTRAMOS INFO POR PATNALLA
		System.out.printf("Lista de %d elementos%n", listaSize);
		System.out.println("---------------------");
		for(int i = 0; i < num.size() -1; i++) {
			System.out.printf("%d, ", num.get(i));
		}
		System.out.printf("%d. %n", num.get(listaSize -1));
		System.out.printf("%nSuma: %d%n", suma);
		System.out.printf("Media: %.2f%n", media);
		System.out.printf("Max: %d%n", max);
		System.out.printf("Min: %d%n", min);
	}

}
