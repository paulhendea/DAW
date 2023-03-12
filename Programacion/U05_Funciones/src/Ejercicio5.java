import java.util.Scanner;

public class Ejercicio5 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int miles = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce distancia en millas: ");
		miles = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO
		System.out.printf("%d millas son %.3f kil�metros.", miles, miles_to_kilometers(miles));
		
		sc.close();
	}
	
	public static double miles_to_kilometers(int mi) {
		final double conv = 1.60934;
		
		//CONVERTIMOS Y DEVOLVEMOS VALOR
		double km = mi * conv;
		return km;
	}
}
