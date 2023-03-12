import java.util.InputMismatchException;
import java.util.Scanner;

public class Act2 {

	public static void main(String[] args) {
		//CREAMOS EL OBJETO SCANNER Y LAS VARIABLES
		Scanner input = new Scanner(System.in);
		int A = 0, B = 0;
		
		//PEDIMOS EL NUMERO POR TECLADO
		try {
			System.out.print("Introduce el primer número entero: ");
			A = input.nextInt();
			System.out.print("Introduce el segundo número entero: ");
			B = input.nextInt();
			System.out.printf("%d / %d = %d%n", A, B, A/B);
		}
		//GESTIONAMOS LAS EXCEPCIONES
		catch (InputMismatchException e) {
			System.out.println("Error: El valor introducido es incorrecto");
			e.printStackTrace();
		}
		catch(ArithmeticException e) {
			System.out.println("Error: Error en la división");
			e.printStackTrace();
		}
		//LIMPIAMOS EL BUFFER DE ENTRADA
		finally {
			input.nextLine();
		}
		
		input.close();
		System.out.println("Fin del programa");
	}

}
