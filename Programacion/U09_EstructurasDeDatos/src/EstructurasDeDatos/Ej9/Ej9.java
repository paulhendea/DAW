package EstructurasDeDatos.Ej9;

import java.util.ArrayList;
import java.util.Collections;

public class Ej9 {

	public static void main(String[] args) {
		//CREATE ARRAYLIST AND SAVE 10 DIFFERENT CARDS
		ArrayList<Card9> deck = new ArrayList<Card9>();
		for(int i = 0; i < 10; i++) {
			try {
				Card9 card = Card9.randomCard();
				boolean repetedCard = false;
				for(Card9 c: deck) {
					if(card.equals(c)){
						repetedCard = true;
					}
				}
				if(!repetedCard) {
					deck.add(card);
				}
				else {
					i--;
				}
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
				i--;
			}
		}
		
		//SORT DECK
		Collections.sort(deck);
		
		//PRINT CARDS
		for(Card9 card: deck) {
			System.out.printf("%s%n", card);
		}
	}
}
