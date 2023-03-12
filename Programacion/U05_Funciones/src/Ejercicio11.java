import java.util.Scanner;

public class Ejercicio11 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		//OBTENEMOS N POR TECLADO
		System.out.print("Introduce un n�mero entero: ");
		num = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCION
		printTimeTable(num);
		
		sc.close();
	}
	
	public static void printTimeTable(int n) {
		//MOSTRAMOS LA TABLA DE MULTIPLICAR DE N
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d%n", n, i, n*i);
		}
	}
}
