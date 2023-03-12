import java.util.InputMismatchException;
import java.util.Scanner;

public class Act1 {

	public static void main(String[] args) {
		//CREAMOS EL OBJETO SCANNER Y LAS VARIABLES
		Scanner input = new Scanner(System.in);
		int A = 0;
		
		//PEDIMOS EL NUMERO POR TECLADO
		try {
			System.out.print("Introduce un número entero: ");
			A = input.nextInt();
			System.out.printf("Valor introducido: %d%n", A);
		}
		//GESTIONAMOS LA EXCEPCIÓN
		catch (InputMismatchException e) {
			System.out.println("Error: El valor introducido es incorrecto");
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
