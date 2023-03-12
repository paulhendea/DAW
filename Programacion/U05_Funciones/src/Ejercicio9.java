import java.util.Scanner; 

public class Ejercicio9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = 0, num2 = 0, num3 = 0, max = 0;
		
		//OBTENEMOS DATOS POR TECLADOJ
		System.out.print("Introduce el n�mero 1: ");
		num1 = sc.nextInt();
		System.out.print("Introduce el n�mero 2: ");
		num2 = sc.nextInt();
		System.out.print("Introduce el n�mero 3: ");
		num3 = sc.nextInt();
		System.out.println();
		
		//APLICAMOS FUNCION Y MOSTRAMOS RESULTADO
		max = maxNum(num1, num2);
		max = maxNum(num3, max);
		System.out.printf("El n�mero mayor es %d%n", max);
		
		sc.close();
	}

	public static int maxNum(int a, int b) {
		int r = 0;
		
		//COMPARAMOS Y GUARDAMOS EL VALOR MAS GRANDE
		if(a < b) {
			r = b;
		}
		else {
			r = a;
		}
		return r;
	}
}
