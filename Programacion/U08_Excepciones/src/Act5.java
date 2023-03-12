import java.util.InputMismatchException;
import java.util.Scanner;

public class Act5 {

	public static void main(String[] args) {
		//CREAMOS EL OBJETO SCANNER Y LAS VARIABLES
		Scanner input = new Scanner(System.in);
		int n = 0;
		
		//PEDIMOS EL NUMERO POR TECLADO
		for(int i = 0; i < 3; i++) {
			try {
				System.out.print("Introduce un número positivo: ");
				n = input.nextInt();
				printPositive(n);
				
				System.out.print("Introduce un número negativo: ");
				n = input.nextInt();
				printNegative(n);
			}
			//GESTIONAMOS LA EXCEPCIÓN
			catch (InputMismatchException e) {
				System.out.println("Error: El valor introducido es incorrecto");
				e.printStackTrace();
			}
			catch (Exception e) {
				System.err.printf("%s%n", e.getMessage());
				e.printStackTrace();
			}
			//LIMPIAMOS EL BUFFER DE ENTRADA
			finally {
				input.nextLine();
			}
		}
		
		input.close();
		System.out.println("Fin del programa");
	}

	public static void printPositive(int p) throws Exception {
		if(p < 0) {
			throw new Exception("El valor debe ser positivo");
		}
		
		System.out.println(p);
	}
	public static void printNegative(int n) throws Exception {
		if(n >= 0) {
			throw new Exception("El valor debe ser negativo");
		}
		
		System.out.println(n);
	}
}
