import java.util.InputMismatchException;
import java.util.Scanner;

public class Act3 {

	public static void main(String[] args) {
		//CREAMOS EL OBJETO SCANNER Y LAS VARIABLES
		Scanner input = new Scanner(System.in);
		double valores[] = new double[5];
		
		//PEDIMOS VALORES POR TECLADO
		for(int i = 0; i < valores.length; i++) {
			try {
				System.out.print("Introduce un número real: ");
				valores[i] = input.nextDouble();
				System.out.printf("Valor introducido: %.2f%n", valores[i]);
			}
			//GESTIONAMOS LA EXCEPCIÓN
			catch (InputMismatchException e) {
				System.out.println("Error: El valor introducido es incorrecto");
				e.printStackTrace();
				input.nextLine();
				i--;
			}
		}
		
		input.close();
		System.out.println("Fin del programa");
	}

}

