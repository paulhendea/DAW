import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dni = 0; 
		boolean validDNI = true;
		
		//PEDIMOS Y COMPROBAMOS QUE EL DNI SEA CORRECTO
		do {
			System.out.print("Introduce DNI: ");
			dni = sc.nextInt();
			
			//COMPROBAMOS QUE TENGA 8 CIFRAS
			if(dni < 10000000 || dni > 99999999) {
				validDNI = false;
				System.out.println("�El DNI introducido es incorrecto!");
				System.out.println();
			}
			else {
				validDNI = true;
			}
		} while (validDNI == false);
		
		//LLAMAMOS FUNCION Y MOSTRAMOS LETRA 
		System.out.printf("La letra es %c.%n", letraDNI(dni));
		
		sc.close();
	}

	public static char letraDNI(int n) {
		char letra[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
		//DEVOLVEMOS LA LETRA QUE CORRESPONDE RESTO DEL DNI ENTRE 23
		return letra[n%23];
	}
}
