package EstructurasDeDatos;

import java.util.Scanner;
import java.util.HashMap;

public class Ej10 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// Create Spanish-English dictionary HashMap with 20 words
		HashMap<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("vibrar", "vibrate");
		dictionary.put("planeta", "planet");
		dictionary.put("nota", "note");
		dictionary.put("rizos", "curls");
		dictionary.put("queso", "cheese");
		dictionary.put("sello", "seal");
		dictionary.put("fin", "end");
		dictionary.put("moneda", "currency");
		dictionary.put("rima", "rhyme");
		dictionary.put("oficio", "job");
		dictionary.put("conquistar", "conquer");
		dictionary.put("tiza", "chalk");
		dictionary.put("camino", "road");
		dictionary.put("avestruz", "ostrich");
		dictionary.put("prohibido", "forbidden");
		dictionary.put("hora", "hour");
		dictionary.put("rama", "branch");
		dictionary.put("lago", "lake");
		dictionary.put("frio", "cold");
		dictionary.put("azul", "blue");
		
		// Ask for the word to search in dictionary
		String word = ask("Word in Spanish");
		
		// Check if the dictionary contains the word
		if(dictionary.containsKey(word)) {
			System.out.printf("English: %s%n", dictionary.get(word));
		}
		else {
			System.out.println("Word not found");
		}
	}
	
	public static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}

}
