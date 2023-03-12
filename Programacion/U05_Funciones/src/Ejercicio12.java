import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double km = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce distancia en kil�metros: ");
		km = sc.nextDouble();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO
		System.out.printf("%.3f kil�metros son %.3f millas.", km, kilometers_to_miles(km));
		
		sc.close();
	}
	
	public static double kilometers_to_miles(double km) {
		final double conv = 1.60934;
		
		//CONVERTIMOS Y DEVOLVEMOS VALOR
		double mi = km / conv;
		return mi;
	}
}

