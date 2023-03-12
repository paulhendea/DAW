import java.util.Scanner;
import java.lang.Math;

public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = 0, y = 0, z = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.println("Para la siguiente ecuaci�n de pitagoras 'x^2 + y^2 = z^2'.\n");
		System.out.print("Introduce el valor de x: ");
		x = sc.nextInt();
		System.out.print("Introduce el valor de y: ");
		y = sc.nextInt();
		System.out.print("Introduce el valor de z: ");
		z = sc.nextInt();
		System.out.println();
		
		//LLAMAMOS FUNCION Y MOSTRAMOS RESULTADO
		if(isEquationCorrect(x, y, z) == true) {
			System.out.println("La ecuaci�n es correcta.");
		}
		else {
			System.out.println("La ecuaci�n es incorrecta.");
		}
		
		sc.close();
	}

	public static boolean isEquationCorrect(int x, int y, int z) {
		boolean r = false;
		
		//COMPROBAMOS SI LA ECUACI�N ES CORRECTA
		if(Math.pow(x, 2) + Math.pow(y, 2) == Math.pow(z, 2)) {
			r = true;
		}
		return r;
	}
}
