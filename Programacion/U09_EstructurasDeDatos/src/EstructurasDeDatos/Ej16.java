package EstructurasDeDatos;

import java.util.HashMap;
import java.util.Scanner;

public class Ej16 {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//CREATE HASHMAP FOR CAPITALS
		HashMap<String, String> capitals = new HashMap<String, String>();
		capitals.put("España", "Madrid");
		capitals.put("Portugal", "Lisboa");
		capitals.put("Francia", "París");

		//START PROGRAM
		String country = null;
		while(true) {
			country = capitalize(ask("Country"));

			//IF THE USER TYPED 'SALIR' THEN QUIT
			if(country.matches("Salir")) break;
			
			//ELSE CHEK IF THE COUNTRY IS SAVED IN THE HASHMAP
			else if(capitals.containsKey(country)) {
				System.out.printf("Capital: %s%n", capitals.get(country));
			}
			
			//ELSE ASK FOR THE CAPITAL
			else {
				String answer = askYesOrNo("Do you know the capital?");
				if(answer.matches("yes")) {
					String capital = capitalize(ask("What is the capital of " + country));
					capitals.put(country, capital);
				}
				else {
					System.out.println("Me neither...");
				}
			}
			System.out.println();
		}
	}

	public static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}
	public static String askYesOrNo(String question) {
		String answer = null;
		do { 
			System.out.printf("%s: ", question);
			answer = input.nextLine().toLowerCase();
			if(!answer.matches("yes") && !answer.matches("no")) {
				System.out.println("Answer with \"yes\" or \"no\"");
			}
		} while(!answer.matches("yes") && !answer.matches("no"));
		return answer;
	}
	public static String capitalize(String word) {
		return word.substring(0,1).toUpperCase() + word.substring(1).toLowerCase();
	}
}
