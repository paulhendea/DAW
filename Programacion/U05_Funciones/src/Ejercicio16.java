import java.util.Scanner; 
import java.lang.Math;

public class Ejercicio16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		//OBTENEMOS VALOR POR TECLADO
		System.out.print("Introduce tama�o del array: ");
		num = sc.nextInt();
		System.out.println();
		
		//CREAMOS ARRAY Y LLAMAMOS FUNCIONES
		double n[] = new double[num];
		arrayRandomFill(n);
		arrayPrint(n);
		
		sc.close();
	}

	public static void arrayRandomFill(double n[]) {
		//LLENAMOS ARRAY CON NUMEROS ALEATORIOS ENTRE 0 Y 1
		for(int i = 0; i < n.length; i++) {
			n[i] = Math.random();
		}
	}
	
	public static void arrayPrint(double n[]) {
		for(int i = 0; i < n.length; i++) {
			System.out.printf("%.3f%n", n[i]);
		}
	}
}
