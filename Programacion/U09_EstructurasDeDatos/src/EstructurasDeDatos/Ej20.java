package EstructurasDeDatos;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Ej20 {
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
			String word = ask("Busca sinónimos para").toLowerCase();
			
			//IF THE USER TYPES SALIR THEN EXIT LOOP
			if(word.matches("salir")) break;
			//IF THE WORD DOSENT EXIST TRY TO LEARN IT
			else if(!dictionary.containsKey(word)) {
				System.out.print("No conozco esa palabra ");
				learnWord(word); 
				System.out.println();
			}
			//IF THERE ARE NO SINONIMS TRY TO LEARN
			else if(numberOfSynonyms(word) == 1) {
				System.out.print("No conozco sinónimos para esa palabra ");
				learnSynonym(word);
				System.out.println();
			}
			else {
				System.out.println(searchSynonyms(word));
			}
		}
		
		//END PROGRAM
		System.out.println("FIN");
	}

	private static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}
	private static String askYesOrNo(String question) {
		String answer = null;
		
		//ASK FOR YES OR NO UNTIL ITS CORRECT
		do { 
			answer = ask(question + " (si/no)").toLowerCase();
			
			if(!answer.matches("si") && !answer.matches("no")) {
				System.out.println("Responde con \"si\" o \"no\"");
			}
		} while(!answer.matches("si") && !answer.matches("no"));
		return answer;
	}
	private static void learnSynonym(String word) {
		//ASK FOR THE SYNONYM
		String yesOrNo = askYesOrNo("¿Quiere añadir sinónimos?");
		if(yesOrNo.matches("si")) {
			String synonym = ask("Introduce un sinónimo").toLowerCase();
			
			//IF THE USER TYPES ONLY ONE WORD
			if(synonym.matches("[[a-z]ñ]+")) {
				String meaning = dictionary.get(word);
				dictionary.put(synonym, meaning);
			}
			else {
				System.out.println("Introduzca una sola palabra");
			}
		}
	}
	private static void learnWord(String word) {
		String yesOrNo = askYesOrNo("¿Quieres añadirla al diccionario?");
		if(yesOrNo.matches("si")) {
			String meaning = ask("Introduce la traducción en inglés").toLowerCase();
			dictionary.put(word, meaning);
		}
	}
	private static String searchSynonyms(String word) {
		//SEARCH FOR SYNONYMS
		String answer = String.format("Sinónimos de %s: ", word);
		String englishWord = dictionary.get(word);
		
		for(Map.Entry<String, String> entry: dictionary.entrySet()) {
			if(entry.getValue().matches(englishWord) && !entry.getKey().matches(word)) {
				//CONCATENATE SYNONYMS IN A STRING
				answer += String.format("%s, ", entry.getKey());
			}
		}
		
		//REPLACE FINAL COMA WITH A DOT AND RETURN ANSWER
		answer = answer.substring(0, answer.lastIndexOf(",")) + ".\n";
		return answer;
	}
	private static int numberOfSynonyms(String word) {
		int counter = 0;
		
		//GET THE ENGLISH VALUE FOR THE WORD
		String englishWord = dictionary.get(word);
		for(Map.Entry<String, String> entry: dictionary.entrySet()) {
			if(entry.getValue().matches(englishWord)) {
				//IF THE ENTRY HAS THE SAME VALUE INCREASE COUNTER
				counter++;
			}
		}
		return counter;
	}
}
