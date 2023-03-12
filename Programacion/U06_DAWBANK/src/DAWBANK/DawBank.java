package DAWBANK;

import java.util.Scanner;

public class DawBank {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String nombre, apellidos;
		int edad, opcion;
		double cantidad = 0;
		
		//OBTENEMOS DATOS PARA CREAR CUENTA
		do {
			nombre = ask("Nombre");
			apellidos = ask("Apellidos");
			edad = Integer.parseInt(ask("Edad"));
			System.out.println();
			
			if(!CuentaBancaria.esMayorEdad(edad)) {
				System.err.println("ERROR: El usuario debe ser mayor de edad");
				System.out.println();
			}
		} while(!CuentaBancaria.esMayorEdad(edad));
		
		//CREAMOS CUENTAS
		CuentaBancaria c1 = new CuentaBancaria(nombre, apellidos);
		
		//INICIAMOS BULCE MENU
		do {
			printMenu();
			
			do {
				opcion = Integer.parseInt(ask("Opción"));
				if((opcion < 1) || (opcion > 8)) {
					System.err.println("ERROR: Opción incorrecta");
					System.out.println();
				}
			} while((opcion < 1) || (opcion > 8));
			
			switch(opcion) {
				case 1: 
					c1.imprimirInfo();
					break;
					
				case 2:
					System.out.printf("IBAN: %s%n", c1.getIBAN());
					System.out.println();
					break;
					
				case 3:
					System.out.printf("Titular: %s%n", c1.getTitular());
					System.out.println();
					break;
					
				case 4:
					System.out.printf("Saldo: %.2f€%n", c1.getSaldo());
					System.out.println();
					break;
					
				case 5:
					cantidad = Double.parseDouble(ask("Cantidad a ingresar"));
					if(!c1.ingresar(cantidad)) {
						System.err.println("ERROR: cantidad incorrecta\n");
					} System.out.println();
					break;
					
				case 6:
					cantidad = Double.parseDouble(ask("Cantidad a retirar"));
					if(!c1.retirar(cantidad)) {
						System.err.println("ERROR: cantidad incorrecta\n");
					} System.out.println();
					break;
					
				case 7: 
					c1.imprimirMovimientos();
					break;
					
				case 8:
					//EN ESTE CASO SE TERMINA EL PROGRAMA
					break;
					
				default:
					System.err.println("ERROR: Opción inesperada\n");
					break;
			}
		} while(opcion != 8);
		
		input.close();
	} //FIN MAIN
	
	private static String ask(String s) {
		System.out.printf("%s: ", s);
		return input.nextLine();
	}
	private static void printMenu() {
		System.out.println("1. Datos de la cuenta");
		System.out.println("2. IBAN");
		System.out.println("3. Titular");
		System.out.println("4. Saldo");
		System.out.println("5. Ingreso");
		System.out.println("6. Retirada");
		System.out.println("7. Movimientos");
		System.out.println("8. Salir");
		System.out.println();
	}
}
