package EstructurasDeDatos.Ej7;

import java.util.ArrayList;
import java.lang.Math;

public class Ej7 {

	public static void main(String[] args) {
		//SAVE 6 COINS INSIDE THE ARRAYLIST
		ArrayList<Coin> coins = new ArrayList<Coin>();
		try {
			coins.add(Coin.randomCoin());
			for(int i = 1; i < 6; i++) {
				coins.add(nextCoin(coins.get(i-1)));
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		//PRINT COINS FROM ARRAYLIST
		for(Coin coin: coins) {
			System.out.println(coin);
		}
	}

	private static Coin nextCoin(Coin lastCoin) throws Exception {
		Coin nextCoin;
		if(Math.random() < 0.5) {
			do {
				nextCoin = new Coin(Coin.randomValue(), lastCoin.getPosition());
			} while(lastCoin.getValue() == nextCoin.getValue());
			return nextCoin;
		}
		else {
			do {
				nextCoin = new Coin(lastCoin.getValue(), Coin.randomPosition());
			} while(lastCoin.getPosition() == nextCoin.getPosition());
			return nextCoin;
		}
	}
}
