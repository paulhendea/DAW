package EstructurasDeDatos;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Ej19 {
	//CREATE SPANISH-ENGLISH DICTIONARY WITH HASHMAP
	//HASHMAP IS OUT OF MAIN SO THE FUNCTIONS CAN ACCESS IT
	private static HashMap<String, String> dictionary = new HashMap<String, String>();
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		//FILL DICTIONARY
		dictionary.put("caliente", "hot");
		dictionary.put("abrasador", "hot");
		dictionary.put("ardiente", "hot");
		dictionary.put("candente", "hot");
		dictionary.put("rojo", "red");
		dictionary.put("tinto", "red");
		dictionary.put("verde", "green");
		dictionary.put("agujetas", "stiff");
		dictionary.put("hierro", "iron");
		dictionary.put("grande", "big");
		
		//START PROGRAM
		System.out.println("Diccionario de sinónimos\n------------------------");
		while(true) {
			String word = ask("Introduce una palabra").toLowerCase();
			
			//IF THE USER TYPES SALIR THEN EXIT LOOP
			if(word.matches("salir")) break;
			//ELSE PRINT ANSWER
			else System.out.println(searchSinonims(word));
		}
		
		//END PROGRAM
		System.out.println("FIN");
	}

	private static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}
	private static String searchSinonims(String word) {
		//IF THE WORD DOSENT EXIST IN DICTIONARY
		if(!dictionary.containsKey(word)) {
			return "No conozco esa palabra\n";
		}
		else {
			//SEARCH FOR SINONIMS
			String answer = String.format("Sinónimos de %s: ", word);
			String englishWord = dictionary.get(word);
			boolean hasSinonims = false;
			
			for(Map.Entry<String, String> entry: dictionary.entrySet()) {
				if(entry.getValue().matches(englishWord) && !entry.getKey().matches(word)) {
					//CONCATENATE SINONIMS IN A STRING
					hasSinonims = true;
					answer += String.format("%s, ", entry.getKey());
				}
			}
			
			if(!hasSinonims) {
				return "No conozco sinónimos de esa palabra\n";
			}
			else {
				//REPLACE FINAL COMA WITH A DOT AND RETURN ANSWER
				answer = answer.substring(0, answer.lastIndexOf(",")) + ".\n";
				return answer;
			}
			
		}
	}
}
