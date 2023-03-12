package EstructurasDeDatos.Ej9;

import java.lang.Comparable;

public class Card9 implements Comparable<Card9> {
	//ATTRIBUTES
	private int number; //BETWEEN 1 AND 12
	private String type;
	
	private static String names[] = new String[]
			{"As", "Dos", "Tres", "Cuatro", "Cinco", "Seis", 
			"Siete", "Ocho", "Nueve", "Sota", "Caballo", "Rey"};
	private static String types[] = new String[]
			{"oros", "copas", "espadas", "bastos", "comodin"}; 
	
	//CONSTRUCTORS
	public Card9(int number, String type) throws Exception {
		if(validType(type) && validNumber(number)) {
				this.type = type;
				this.number = number;
		}
		else {
			throw new Exception("Error: Invalid card");
		}
	}
	
	//GETTERS
	public int getNumber() {
		return number;
	}
	public String getType() {
		return type;
	}
	
	//SETTERS
	public void setNumber(int number) throws Exception {
		if(validNumber(number)) {
				this.number = number;
		}
		else {
			throw new Exception("Error: Number must be between 1 and 13");
		}
	}
	public void setType(String type) throws Exception {
		if(validType(type)) {
				this.type = type;
		}
		else {
			throw new Exception("Error: Invalid type");
		}
	}
	
	//STATIC METHODS
	private static boolean validNumber(int number) {
		if((number < 1) || (number > 12)) {
			return false;
		}
		else {
			return true;
		}
	}
	private static boolean validType(String type) {
		boolean validType = false;
		for(int i = 0; i < types.length; i++) {
			if(types[i].matches(type)) {
				validType = true;
			}
		}
		return validType;
	}
	public static Card9 randomCard() throws Exception {
		int number = (int) Math.round(Math.random()*11) +1;
		int type = (int) Math.round(Math.random()*4);
		return new Card9(number, types[type]);
	}
	
	//METHODS
	public String toString() {
		if(type.matches(types[4])) {
			return types[4].substring(0, 1).toUpperCase() 
					+ types[4].substring(1);
		}
		else {
			return String.format("%s de %s", names[number-1], type);
		}
	}
	public boolean equals(Card9 card) {
		if(card.getType() == this.type) {
			if(type == types[4]) {
				return true;
			}
			else if (card.getNumber() == this.number){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
	public int compareTo(Card9 c) {
		//IF BOTH ARE JOKERS THEN ARE EQUAL
		if((type.matches(types[4])) && (c.getType().matches(types[4]))) {
			return 0;
		}
		//IF THE FIRST IS JOKER THEN IS GRATER
		else if(type.matches(types[4])) {
			return 1;
		}
		//IF THE SECOND IS JOKER THEN IS LOWER
		else if(c.getType().matches(types[4])) {
			return -1;
		}
		//ELSE ORDER BY CARD TYPE
		else if(type.compareTo(c.getType()) == 0) {
			Integer a = getNumber(), b = c.getNumber();
			return a.compareTo(b);
		}
		//ELSE ORDER BY NUMBER
		else {
			return type.compareTo(c.getType());
		}
	}
}
