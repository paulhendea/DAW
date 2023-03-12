package Act2;

import java.util.ArrayList;
import java.util.Scanner;

public class programaVehiculo {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		//CREAMOS UNA INSTANCIA DE CADA VEHICULO Y GUARDAMOS EN UNA LISTA
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		vehiculos.add(new Bicicleta("carretera"));
		vehiculos.add(new Coche("Mercedes"));
		
		//MOSTRAMOS MENÚ
		int option = 0;
		do {
			printMenu();
			option = askOption();
			Vehiculo vehiculo;
			switch(option) {
			case 1:
				vehiculo = (Vehiculo) vehiculos.get(0);
				vehiculo.recorrer(askDistancia());
				break;
				
			case 2:
				vehiculo = (Vehiculo) vehiculos.get(0);
				vehiculo.hacerTruco();
				break;
				
			case 3:
				vehiculo = (Vehiculo) vehiculos.get(1);
				vehiculo.recorrer(askDistancia());
				break;
				
			case 4:
				vehiculo = (Vehiculo) vehiculos.get(1);
				vehiculo.hacerTruco();
				break;
				
			case 5:
				vehiculo = (Vehiculo) vehiculos.get(0);
				System.out.printf("Kilómetros recorridos: %.2f%n", 
						vehiculo.getKilometrosRecorridos());
				break;
				
			case 6:
				vehiculo = (Vehiculo) vehiculos.get(1);
				System.out.printf("Kilómetros recorridos: %.2f%n", 
						vehiculo.getKilometrosRecorridos());
				break;
				
			case 7:
				System.out.printf("Kilómetros totales de los vehículos: %.2f%n", 
						Vehiculo.getKilometrosTotales());
				break;
				
			case 8:
				break;
				
			default:
				System.err.println("ERROR: Opción no esperada");
			}
			System.out.println();
			
		} while(option != 8);
		
	}
	
	public static void printMenu() {
		System.out.println("1. Avanza con la bicicleta");
		System.out.println("2. Haz el caballito");
		System.out.println("3. Avanza con el coche");
		System.out.println("4. Quema rueda");
		System.out.println("5. Ver kilometraje bicileta");
		System.out.println("6. Ver kilometraje coche");
		System.out.println("7. Ver kilometraje total");
		System.out.println("8. Salir");
	}
	public static int askOption() {
		int option = 0;
		do {
			System.out.print("Elige una opción: ");
			option = input.nextInt();
			if((option < 1) || (option > 8)) {
				System.err.println("ERROR: Opción incorrecta");
			}
		} while((option < 1) || (option > 8));
		
		return option;
	}
	public static double askDistancia() {
		double distancia;
		System.out.print("¿Cuánta distancia?: ");
		distancia = input.nextDouble();
		return distancia;
	}

}
