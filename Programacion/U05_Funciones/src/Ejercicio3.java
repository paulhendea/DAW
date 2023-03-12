import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number1 = 0, number2 = 0, answer = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce el n�mero 1: ");
		number1 = sc.nextInt();
		System.out.print("Introduce el n�mero 2: ");
		number2 = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO
		answer = lower(number1, number2);
		System.out.println("El n�mero menor es "+answer);
		
		sc.close();
	}

	public static int lower(int a, int b) {
		int min = 0;
		
		//COMPROBAMOS Y DEVOLVEMOS EL MENOR
		if(a > b) {
			min = b;
		}
		else {
			min = a;
		}
		return min;
	}
}
