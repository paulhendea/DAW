import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		do {
			System.out.print("Introduce un n�mero entero: ");
			num = sc.nextInt();
			if(isPrimeNumber(num) == true) {
				System.out.println("Es un n�mero primo.");
			}
			else {
				System.out.println("No es n�mero primo.");
			}
			System.out.println();
		} while(num != 0);
		System.out.println("FIN.");

		
		sc.close();
	}
	
	public static boolean isPrimeNumber(int n) {
		boolean sw = true;
		
		//SI N < 2 NO PUEDE SER PRIMO
		if(n < 2) {
			sw = false;
		}
		else {
			//COMPROBAMOS EL RESTO PARA TODOS LOS NUMEROS ENTRE N Y 1
			//EN CASO DE QUE SEA 2 NO ENTRA EN EL BUCLE, PERO NO NOS
			//IMPORTA PORQUE ES PRIMO IGUALMENTE
			for(int i = n-1; i >= 2; i--) {
				if(n%i == 0) {
					sw = false;
				}
			}		
		}
		return sw;		
	}
}
