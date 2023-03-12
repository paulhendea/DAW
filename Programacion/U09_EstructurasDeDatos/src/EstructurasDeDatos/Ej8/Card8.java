package EstructurasDeDatos.Ej8;

public class Card8 {
	//ATTRIBUTES
	private int number; //BETWEEN 1 AND 12
	private String type;
	
	private static String types[] = new String[]
			{"oros", "copas", "espadas", "bastos", "comodin"}; 
	
	//CONSTRUCTORS
	public Card8(int number, String type) throws Exception {
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
	public static Card8 randomCard() throws Exception {
		int number = (int) Math.round(Math.random()*11) +1;
		int type = (int) Math.round(Math.random()*4);
		return new Card8(number, types[type]);
	}
	
	//METHODS
	public String toString() {
		if(type.matches("comodin")) {
			return "comodin";
		}
		else {
			return String.format("%d de %s", number, type);
		}
	}
	public boolean equals(Card8 card) {
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
}
