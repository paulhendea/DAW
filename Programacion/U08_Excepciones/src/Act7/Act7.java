package Act7;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Act7 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//CREAMOS UN ARRAYLIST CON INSTANCIAS DE LA CLASE GATO
		ArrayList<Gato> gatos = new ArrayList<Gato>();
		for(int i = 0; i < 5; i++) {
			Gato gato;
			String nombre = null;
			int edad = 0;
			
			//PEDIMOS DATOS POR TECLADO
			try {
				System.out.printf("Gato %d%n--------%n", i+1);
				System.out.print("Nombre: ");
				nombre = input.nextLine();
				System.out.print("Edad: ");
				edad = input.nextInt();
				gato = new Gato(nombre, edad);
				gatos.add(gato);
			}
			//GESTIONAMOS LA EXCEPCION POR INSERTAR UN VALOR NO ESPERADO
			catch (InputMismatchException e) {
				System.err.println("Error: El valor introducido es incorrecto");
				i--; 
			}
			//GESTIONAMOS LA EXCEPCION POR VALORES INCORRECTOS 
			catch (Exception e) {
				System.out.printf("%s%n", e.getMessage());
				e.printStackTrace();
				i--;
			}
			//LIMPIAMOS EL BUFFER
			finally {
				input.nextLine();
				System.out.println();
			}
		}
		//CERRAMOS SCANNER
		input.close();
		
		//MOSTRAMOS INFO DE LOS GATOS
		for(Gato gato: gatos) {
			System.out.println(gato);
		}		
	}
}
