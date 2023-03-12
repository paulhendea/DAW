package EstructurasDeDatos;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ej14 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		//CREATE HASHMAP TO SAVE PRODUCTS
		HashMap<String, Double> products = new HashMap<String, Double>();
		products.put("avena", 2.21);
		products.put("garbanzos", 2.39);
		products.put("tomate", 1.59);
		products.put("jengibre", 3.13);
		products.put("quinoa", 4.50);
		products.put("guisantes", 1.60);
		
		//HASHMAPS FOR SHOP CART AND DISCOUNTS
		HashMap<String, Integer> shopCart = new HashMap<String, Integer>(); //name and amount
		HashMap<String, Integer> discounts = new HashMap<String, Integer>(); //code and valuePercent
		discounts.put("ECODTO", 10); 
		
		//START PROGRAM
		while(true) {
			//GET INFO FROM KEYBOARD
			String product = null;
			int amount;
			
			product = ask("Product").toLowerCase();
			
			//IF THE USER TYPES FIN THE LOOP BREAKS
			if(product.matches("fin")) break;
			//CHEK VALUES FOR PRICES
			else if(products.containsKey(product)) {
				amount = askPositiveInt("Amount");
				if(shopCart.containsKey(product)) {
					shopCart.put(product, shopCart.get(product)+amount);
				}
				else {
					shopCart.put(product, amount);
				}
			}
			else System.out.println("Product not available");
		} 
		System.out.println();
		
		//ASK FOR DISCOUNT
		String discountCode = ask("Discount code (INTRO if none)").toUpperCase();
		System.out.println();
		
		//PRINT RECEIPT
		double total = 0;
		System.out.println("Product\t\tPrice\tAmount\tSubtotal"
						+ "\n-----------------------------------------");
		for(Entry<String, Integer> entry: shopCart.entrySet()) {
			String product = entry.getKey();
			double price = products.get(product);
			int amount = entry.getValue();
			
			//IF THE NAME IS TOO LONG PRINT ONE TAB LESS
			if(product.length() > 6) {
				System.out.printf("%s\t%.2f\t%d\t%.2f%n", 
						product, price, amount, price*amount);
			}
			else {
				System.out.printf("%s\t\t%.2f\t%d\t%.2f%n", 
						product, price, amount, price*amount);
			}
			total += price*amount;
		}
		System.out.println("-----------------------------------------");
		if(discounts.containsKey(discountCode)) {
			//CALCULATE DISCOUNT
			double discount = discounts.get(discountCode)/100.0;
			
			//PRINT DISCOUNT
			System.out.printf("Discount: \t\t\t%.2f%n", discount*total);
			System.out.println("-----------------------------------------");
		}
		//PRINT TOTAL
		System.out.printf("TOTAL: %.2f%n", total);
	}
	
	public static String ask(String question) {
		System.out.printf("%s: ", question);
		return input.nextLine();
	}
	public static int askPositiveInt(String question) {
		int positiveInt = 0;
		do {
			try {
				System.out.printf("%s: ", question);
				positiveInt = input.nextInt();
				
				if(positiveInt < 1) {
					System.out.println("The amount must be a whole positive number");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("The amount must be a whole positive number");
			}
			finally {
				input.nextLine();
			}
		} while(positiveInt <= 0);
		return positiveInt;
	}
}
