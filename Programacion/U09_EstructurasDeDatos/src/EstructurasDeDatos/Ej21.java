package EstructurasDeDatos;

import java.util.Scanner;
import java.util.HashMap;

public class Ej21 {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//CREATE HASHMAP FOR HABITAT
		HashMap<String, String> habitatAnfibio = new HashMap<String, String>();
		habitatAnfibio.put("rana", "En los tr�picos y cerca de las zonas h�medas y acu�ticas.");
		habitatAnfibio.put("salamandra", "Ecosistemas h�medos.");
		habitatAnfibio.put("sapo", "En cualquier sitio salvo el desierto y la Ant�rtida.");
		habitatAnfibio.put("trit�n", "Am�rica y �frica.");
		
		//CREATE HASHMAP FOR NUTRITION
		HashMap<String, String> alimentacionAnfibio = new HashMap<String, String>();
		alimentacionAnfibio.put("rana", "Larvas e insectos.");
		alimentacionAnfibio.put("salamandra", "Peque�os crust�ceos e insectos.");
		alimentacionAnfibio.put("sapo", "Insectos, lombrices, y peque�os roedores.");
		alimentacionAnfibio.put("trit�n", "Insectos.");
		
		//START PROGRAM
		while(true) {
			String answer = ask("Introduce el tipo de anfibio").toLowerCase();
			
			//IF THE USER TYPES SALIR THEN EXIT
			if(answer.matches("salir")) break;
			
			//CHEK IF MATCHES THE KEYWORDS FROM HASHMAPS
			if(habitatAnfibio.containsKey(answer)) {
				System.out.printf("H�bitat: %s%n", habitatAnfibio.get(answer));		
			}
			if(alimentacionAnfibio.containsKey(answer)) {
				System.out.printf("Alimentaci�n: %s%n", alimentacionAnfibio.get(answer));
			}
			
			//IF THERE IS NO INFO PRINT WARNING
			if(!habitatAnfibio.containsKey(answer) && !alimentacionAnfibio.containsKey(answer)) {
				System.out.println("Ese tipo de anfibio no existe.");
			}
			
			System.out.println();			
		}
		
		System.out.println("FIN");
		//END

	}
	
	private static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}

}
