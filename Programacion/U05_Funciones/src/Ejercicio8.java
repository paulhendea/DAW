import java.util.Scanner; 

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce un n�mero entero: ");
		num = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCIONES Y MOSTRAMOS RESULTADO
		System.out.printf("Suma desde 1 hasta %d = %d%n", num, add1toN(num));
		System.out.printf("Producto desde 1 hasta %d = %d%n", num, multiply1toN(num));
		System.out.printf("Valor intermedio entre 1 y %d = %.2f%n", num, average1andN(num));
		
		sc.close();
	}
	
	public static int add1toN(int n) {
		int r = 0;
		
		if(n < 1) {
			//CALCULAMOS SUMA DESDE 1 A N SI ES MENOR
			for(int i = 1; i >= n; i--) {
				r += i;
			}
		}
		else {
			//CALCULAMOS SUMA DESDE 1 A N
			for(int i = 1; i <= n; i++) {
				r += i;
			}
		}
		return r;
	}
	
	public static int multiply1toN(int n) {
		int r = 1;
		
		if(n < 1) {
			r = 0;
		}
		else {
			//CALCULAMOS MULT DESDE 1 A N
			for(int i = 1; i <= n; i++) {
				r *= i;
			}
		}
		return r;
	}
	
	public static double average1andN(double n) {		
		//CALCULAMOS MEDIA DE 1 A N
		double r = ( n + 1) / 2;
		return r;
	}
}
