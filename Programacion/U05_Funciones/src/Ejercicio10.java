import java.util.Scanner; 

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int day = 0, month = 0, year = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce el d�a: ");
		day = sc.nextInt();
		System.out.print("Introduce el mes (en n�mero): ");
		month = sc.nextInt();
		System.out.print("Introduce el a�o: ");
		year = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO
		if(validDate(day, month, year) == false) {
			System.out.println("Fecha no v�lida.");
		}
		else {
			System.out.println("Fecha v�lida.");
		}
		
		sc.close();
	}
	
	public static boolean validDate(int day, int month, int year) {
		boolean sw = true;
		
		//COMPROBAMOS Y DEVOLVEMOS RESULTADO
		if(day < 1 || day >30 || month < 1 || month > 12 || year < 0) {
			sw = false;
		}
		return sw;
	}
}
