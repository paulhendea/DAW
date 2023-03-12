import java.util.Scanner;
import java.lang.Math;
public class Act4 {

	public static void main(String[] args) {
		//CREAMOS EL OBJETO SCANNER Y LAS VARIABLES
		Scanner input = new Scanner(System.in);
		int posicion = 0;
		int n = (int) (Math.random() * 100);
		int numeros[] = new int[n];
		//LLENAMOS EL ARRAY CON NUMEROS RANDOM
		for(int i = 0; i < numeros.length; i++) {
			numeros[i] = (int) (Math.random() * 10);
		}
		
		System.out.printf("Numero de valores del Array: %d%n", n);
		for(int i = 0; i < numeros.length; i++) {
			System.out.printf("%d. %d%n", i, numeros[i]);
		} System.out.println();
		
		//PEDIMOS EL NUMERO POR TECLADO
		do {
			try {
				System.out.print("Qué posición quiere consultar?: ");
				posicion = input.nextInt();
				
				//NO SE IMPRIME NADA SI LA POSICION ES NEGATIVA
				if(posicion >= 0) {
					System.out.printf("Valor en la posición %d: %d%n", 
							posicion, numeros[posicion]);
				}
			}
			//GESTIONAMOS LA EXCEPCIÓN
			catch (IndexOutOfBoundsException e) {
				System.out.println("Error: la posicion no existe");
				e.printStackTrace();
			}
			//LIMPIAMOS EL BUFFER DE ENTRADA
			finally {
				input.nextLine();
			}
		} while (posicion >= 0);
		
		input.close();
		System.out.println("Fin del programa");
	}
		
}
