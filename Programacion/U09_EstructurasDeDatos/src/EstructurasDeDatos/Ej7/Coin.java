package EstructurasDeDatos.Ej7;

import java.lang.Math;

public class Coin {
	//ATRIBUTOS
	private int value; //INTEGER BETWEEN 0 AND 7
	private boolean position; //TRUE = TOP, FALSE = BOTTOM
	private static final String values[] = new String[] 
			{"1 cent", "2 cent", "5 cent", "10 cent", 
			"25 cent", "50 cent", "1 euro", "2 euro"};

	//CONSTRUCTOR
	public Coin(int value, boolean position) throws Exception {
		if(isCorrect(value)) {
			this.value = value;
			this.position = position;
		}
		else {
			throw new Exception("ERROR: Invalid coin");
		}
	}
	
	//GETTERS
	public int getValue() {
		return value;
	}
	public boolean getPosition() {
		return position;
	}
	
	//SETTERS
	public void setValue(int value) throws Exception {
		if(isCorrect(value)) {
			this.value = value;
		}
		else {
			throw new Exception("ERROR: The value must be between 0 and 7");
		}
	}
	public void setPosition(boolean position) {
		this.position = position;
	}
	
	//METODOS ESTATICOS
	private static boolean isCorrect(int value) {
		if((value < 0) || (value > 7)) {
			return false;
		}
		else {
			return true;
		}
	}
	public static int randomValue() {
		return (int) (Math.random() * 7.0);
	}
	public static boolean randomPosition() {
		return Math.random() < 0.5;
	}
	public static Coin randomCoin() throws Exception {
			return new Coin(randomValue(), randomPosition());
	}
	
	//METODOS
	public String toString() {
		if(position) {
			return values[value] + " - TOP";
		}
		else {
			return values[value] + " - BOTTOM";
		}
	}
}
