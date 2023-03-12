import java.util.Scanner;
import java.lang.Math;

public class Ejercicio21 {

	public static void main(String[] args) {
		int option = 0;
		double radius = 0;
		
		do {
			option = menu();
			if(option != 5) {
				radius = askRadius();
			}
			
			if(option == 1) {
				System.out.printf("Circunferencia: %.3f%n", circunference(radius));
			}
			else if(option == 2) {
				System.out.printf("�rea: %.3f%n", area(radius));
			}
			else if(option == 3) {
				System.out.printf("Volumen: %.3f%n", volume(radius));
			}
			else if(option == 4) {
				System.out.printf("Circunferencia: %.3f%n", circunference(radius));
				System.out.printf("�rea: %.3f%n", area(radius));
				System.out.printf("Volumen: %.3f%n", volume(radius));
			}
			System.out.println();
		}while(option != 5);
		
		System.out.println("FIN.");
	}

	public static int menu() {
		Scanner sc = new Scanner(System.in);
		int n = 0;
		boolean validSelect = false;
		
		//IMPRIMIMOS MENU
		System.out.println("1. Circunferencia");
		System.out.println("2. �rea");
		System.out.println("3. Volumen");
		System.out.println("4. Todas ellas");
		System.out.println("5. Salir");
		System.out.println();
		
		//OBTENEMOS INFO Y COMPROBAMOS SI ES CORRECTA
		do {
			System.out.print("Seleccione una opci�n introduciendo su n�mero: ");
			n = sc.nextInt();
			if(n == 1 || n == 2 || n == 3 || n == 4 || n == 5) {
				validSelect = true;
			}
			else {
				validSelect = false;
				System.out.println("Opci�n incorrecta.");
			}
		} while(validSelect == false);
		
		sc.close();

		return n;		
	}
	
	public static double askRadius() {
		Scanner sc = new Scanner(System.in);
		double r = 0;
		boolean validR = false;
		
		//OBTENEMOS INFO Y COMPROBAMOS SI ES CORRECTA
		do {
			System.out.print("Introduce el radio: ");
			r = sc.nextDouble();
			if(r >= 0) {
				validR = true;				
			}
			else {
				validR = false;
				System.out.println("El radio no puede ser negativo.");
			}
		} while(validR == false);
		
		sc.close();
		
		return r;
	}
	
	public static double circunference(double radius) {		
		//CALCULAMOS CIRCUNFERENCIA
		double answer = Math.PI * (2 * radius);
		return answer;
	}
	
	public static double area(double radius) {
		//CALCULAMOS AREA
		double answer = Math.PI * Math.pow(radius, 2);
		return answer;
	}
	
	public static double volume(double radius) {
		//CALCULAMOS VOLUMEN
		double answer = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
		return answer;
	}
}
