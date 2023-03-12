package Ej2_Astros;

import java.util.ArrayList;
import java.util.Scanner;

public class programaAstros {
	//SCANNER
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//ARRAYS CON SATELITES
		String satelitesTierra[] = new String[] {"Luna"};
		String satelitesMarte[] = new String[] {"Fobos", "Deimos"};
		
		//CREAMOS LISTA DE OBJETOS
		ArrayList<Astros> astros = new ArrayList<Astros>();
		astros.add(new Planeta("Tierra", 6378, 23.93, "5,972 x 10^24 kg", 15, 9.807, 150000000, 365.2163, 1, satelitesTierra));
		astros.add(new Planeta("Marte", 3389.5, 24.616, "6,39 x 10^23 kg", -55, 3.721, 227940000, 16468.8, 2, satelitesMarte));
		astros.add(new Planeta("Venus", 6051.8, 2802, "4,867 × 10^24 kg", 463.85, 8.87, 108000000, 0.616438, 0));
		astros.add(new Satelite("Luna", 1737.4, 655.68, "7,349 × 1022 kg", -55, 1.62, 384400, 27, "Tierra"));
		astros.add(new Satelite("Deimos", 6.2, 30.288, "2,244 × 10^15 kg", -40, 0.003, 23.458, 1.25125, "Marte"));
		
		int option;
		do {
			printMenu(astros);
			option = askOption(astros);
			if(option != astros.size()) {
				Astros a = (Astros) astros.get(option);
				a.mostrarInfo();
			}
		} while(option != astros.size()); //LA ÚLTIMA OPCIÓN ES LA DE SALIR
		
		//CERRAR SCANNER
		input.close();
	}
	
	public static void printMenu(ArrayList<Astros> a) {
		for(int i = 0; i < a.size() +1; i++) {
			if(i == a.size()) {
				System.out.printf("%d. Salir", i);
			}
			else {
				Astros astro = (Astros) a.get(i);
				System.out.printf("%d. %s%n", i, astro.getNombre());
			}
		} System.out.println();
	}
	public static int askOption(ArrayList<Astros> a) {
		int n;
		do {
			System.out.print("Elige una opción: ");
			n = input.nextInt();
			
			if((n < 0) || (n > a.size())) {
				System.err.println("Opción incorrecta.");
			}
		} while((n < 0) || (n > a.size()));
		System.out.println();
		
		return n;
	}
}
