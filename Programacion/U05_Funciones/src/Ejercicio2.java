import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int edad = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce tu edad: ");
		edad = sc.nextInt();
		
		//COMPROBAMOS Y MOSTRAMOS RESULTADO
		if(isAdult(edad) == true) {
			System.out.println("Eres mayor de edad.");
		}
		else {
			System.out.println("Eres menor de edad.");
		}

		sc.close();
	}

	public static boolean isAdult(int a) {
		boolean r = false;
		
		if(a >= 18) {
			//SI ES IGUAL O MAYOR QUE 18 DEVUELVE TRUE, SI NO, FALSE
			r = true;
		}
		return r;
	}
}
