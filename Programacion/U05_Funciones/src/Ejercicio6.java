import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double price[] = new double[5];
		double temp = 0;
		
		//OBTENEMOS DATOS POR TECLADO Y LOS GUARDAMOS EN UN ARRAY
		for(int i = 0; i < 5; i++) {
			System.out.printf("Introduce el precio del art�culo %d: ", i+1);
			price[i] = sc.nextDouble();
		}
		System.out.println();
		
		//APLICAMOS FUNCI�N AYUDANDONOS DE UNA VARIABLE TEMPORAL Y MOSTRAMOS RESULTADO
		for(int i = 0; i < 5; i++) {
			temp = price[i];
			System.out.printf("Art�culo %d = %.2f%n", i+1, withTaxes(temp));
		}
		
		sc.close();
	}
	
	public static double withTaxes(double price) {
		
		//CALCULAMOS RESULTADO CON 21% IVA
		double r = price * 1.21;
		return r;
	}
}