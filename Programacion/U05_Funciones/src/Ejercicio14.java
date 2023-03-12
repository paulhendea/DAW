import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		char c;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce el caracter que deseas imprimir: ");
		c = sc.next().charAt(0);
		System.out.print("Introduce el n�mero de filas que deseas imprimir: ");
		num = sc.nextInt();
		System.out.println();
		
		//LLAMAMOS LA  FUNCION
		printPyramid(c, num);
		
		sc.close();
	}

	public static void printPyramid(char c, int n) {
		int space = 0, character = 1;
		
		//REPETIMOS POR CADA CAPA
		for(int i = 1; i <= n; i++) {
			
			//CALCULAMOS ESPACIOS Y CARACTERES
			space = n - i;
			for(int j = 0; j < space + character; j++) {
				
				if(j < space) {
					System.out.print(" ");
				}
				else { 
					System.out.print(c);
				}
			}
			character += 2;
			System.out.println();
		}
	}
}
