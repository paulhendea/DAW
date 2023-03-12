package EstructurasDeDatos.Ej8;

import java.util.ArrayList;

public class Ej8 {

	public static void main(String[] args) {
		//CREATE ARRAYLIST AND SAVE 10 DIFFERENT CARDS
		ArrayList<Card8> deck = new ArrayList<Card8>();
		for(int i = 0; i < 10; i++) {
			try {
				Card8 card = Card8.randomCard();
				boolean repetedCard = false;
				for(Card8 c: deck) {
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
		
		//PRINT CARDS
		for(Card8 card: deck) {
			System.out.printf("%s%n", card);
		}
	}
}
