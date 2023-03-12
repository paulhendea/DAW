import java.util.Scanner;


public class Ejercicio4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce un n�mero entero: ");
		num = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO 
		if(tellSign(num) == 0) {
			System.out.println("El n�mero es 0.");
		}
		else if(tellSign(num) == -1) {
			System.out.println("El n�mero es negativo.");
		}
		else if(tellSign(num) == 1) {
			System.out.println("El n�mero es positivo.");
		}
		
		sc.close();
	}
	
	public static int tellSign(int a) {
		int r = 0;
		
		//COMPROBAMOS Y DEVOLVEMOS RESULTADO
		if(a == 0) {
			r = 0;
		}
		else if(a < 0) {
			r = -1;
		}
		else {
			r = 1;
		}
		
		return r;
	}
}
