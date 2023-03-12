package EstructurasDeDatos;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ej11 {
	private static Scanner input = new Scanner(System.in);
	private static int testWords[] = new int[5];
	
	public static void main (String[] args) {
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
		
		// Create ArrayList to save the keys of the dictionary
		ArrayList<String> dictionaryWords = new ArrayList<String>();
		for(Map.Entry<String, String> entry: dictionary.entrySet()) {
			dictionaryWords.add(entry.getKey());
		}
		
		// Choose 5 random words to include in test
		for(int i = 0; i < testWords.length; i++) {
			int n = (int) Math.round(Math.random()* 19);
			if(isDifferent(n)) {
				testWords[i] = n;
			}
			else {
				i--;
			}
		}
		
		// Ask test questions and save marks
		int correct = 0;
		System.out.println("Test\n------");
		for(int i = 0; i < testWords.length; i++) {
			String question = dictionaryWords.get(testWords[i]);
			String answer = ask(question);
			if(dictionary.get(question).matches(answer)) {
				correct++;
			}
		}
		
		// Show marks
		System.out.printf("\nMark: %s/5%n", correct);
		
		
	}
	private static boolean isDifferent(int n) {
		boolean isDifferent = true;
		for(int i = 0; i < testWords.length; i++) {
			if(testWords[i] == n) {
				isDifferent = false;
			}
		}
		return isDifferent;
	}
	private static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}
}
