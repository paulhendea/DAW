package EstructurasDeDatos.Ej12;

import java.util.HashMap;
import java.util.ArrayList;

public class Ej12 {

	public static void main(String[] args) {
		//GET A HASHMAP FOR THE VALUES
		HashMap<String, Integer> values = new HashMap<String, Integer>();
		values.put("As", 11);
		values.put("Tres", 10);
		values.put("Sota", 2);
		values.put("Caballo", 3);
		values.put("Rey", 4);
		values.put("Comodin", 12); //EXTRA
		
		//SAVE IN ARRAYLIST DECK 5 DIFFERENT CARDS
		ArrayList<Card12> deck = new ArrayList<Card12>();
		for(int i = 0; i < 5; i++) {
			try {
				//CREATE ONE RANDOM CARD
				Card12 card = Card12.randomCard();
				
				//CHEK IF ITS REPEATED
				boolean repetedCard = false;
				for(Card12 c: deck) {
					if(card.equals(c)){
						repetedCard = true;
					}
				}
				//IF ITS NOT SAVE IT
				if(!repetedCard) {
					deck.add(card);
				}// ELSE TRY AGAIN
				else {
					i--;
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				i--;
			}
		}
		
		//PRINT AND CALCULATE THE CARDS VALUES
		int deckValue = 0;
		for(Card12 c: deck) {
			System.out.printf("%s%n", c);
			
			//GET CARD VALUE
			String key = getFirstWord(c.toString());
			if(values.containsKey(key)) {
				deckValue += values.get(key);
			}
		}
		System.out.printf("You have %d points%n", deckValue);
		
		//END
	}
	public static String getFirstWord(String sentence) {
		int position = sentence.indexOf(" ");
		if(position == -1) {
			return sentence;
		}
		else {
			return sentence.substring(0, position);
		}
	}

}
