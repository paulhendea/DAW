import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double result = 0, number1 = 0, number2 = 0;
		
		//PEDIMOS DATOS POR TECLADO
		System.out.print("Introduce el número 1: ");
		number1 = sc.nextDouble();
		System.out.print("Introduce el número 2: ");
		number2 = sc.nextDouble();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO
		result = multiply(number1, number2);
		System.out.printf("%,f * %,f = %,f%n", number1, number2, result);

		sc.close();
	}
	
	public static double multiply(double a, double b) {
		double r = 0;
		
		//MULTIPLICAMOS LAS VARIABLES Y DEVOLVEMOS EL VALOR
		r = a * b;
		return r;
	}

}
