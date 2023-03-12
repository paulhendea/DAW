import java.util.Scanner;

public class Ejercicio13 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double price = 0, priceWithDisc = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce precio inicial: ");
		price = sc.nextDouble();
		System.out.print("Introduce precio con descuento: ");
		priceWithDisc = sc.nextDouble();
		System.out.println();
		
		//APLICAMOS FUNCI�N Y MOSTRAMOS RESULTADO
		System.out.printf("El descuento es del %.2f%% %n", discount(price, priceWithDisc));
		
		sc.close();
	}
	
	public static double discount(double price, double priceWithDisc) {
		double disc = 0; 
		
		//CALCULAMOS DESCUENTO Y DEVOLVEMOS
		disc = (1 - priceWithDisc / price) * 100;
		return disc;
	}
}
