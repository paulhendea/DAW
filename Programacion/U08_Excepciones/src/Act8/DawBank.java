package Act8;

import java.util.Scanner;

public class DawBank {
	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		String nombre = null, apellidos = null;
		int edad = 0, opcion = 0;
		double cantidad = 0;
		CuentaBancaria c1 = null;
		boolean cuentaCreada = false;
		
		//OBTENEMOS DATOS PARA CREAR CUENTA
		do {
			try {
			nombre = ask("Nombre");
			apellidos = ask("Apellidos");
			edad = Integer.parseInt(ask("Edad"));
			System.out.println();
			
			//CREAMOS CUENTAS
			c1 = new CuentaBancaria(nombre, apellidos, edad);
			cuentaCreada = true;
			}
			catch (NumberFormatException e) {
				System.err.println("Error: La edad debe ser un número entero");
				e.printStackTrace();
			}
			catch (CuentaException e) {
				System.err.printf("%s%n", e.getMessage());
				e.printStackTrace();
			}
		} while(!cuentaCreada);
		
		//INICIAMOS BULCE MENU
		do {
			printMenu();
			
			do {
				try {
					opcion = Integer.parseInt(ask("Opción"));
					
					if((opcion < 1) || (opcion > 8)) {
						System.err.println("ERROR: Opción incorrecta");
						System.out.println();
					}
				}
				catch (NumberFormatException e) {
					System.err.println("Error: La opción debe ser un número entero");
					e.printStackTrace();
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
					try {
						cantidad = Double.parseDouble(ask("Cantidad a ingresar"));
						c1.ingresar(cantidad);
					}
					catch (NumberFormatException e) {
						System.out.printf("%s%n", e.getMessage());
						e.printStackTrace();
					}
					catch (AvisarHaciendaException e) {
						System.out.println(e);
					}
					catch (CuentaException e) {
						System.out.printf("%s%n", e.getMessage());
						e.printStackTrace();
					}
					finally {
						System.out.println();
					}
					break;
					
				case 6:
					try {
						cantidad = Double.parseDouble(ask("Cantidad a retirar"));
						c1.retirar(cantidad);
					}
					catch (NumberFormatException e) {
						System.out.printf("%s%n", e.getMessage());
						e.printStackTrace();
					}
					catch (AvisarHaciendaAndSaldoNegativoException e) {
						System.out.println(e);
					}
					catch (AvisarHaciendaException e) {
						System.out.println(e);
					}
					catch (CuentaException e) {
						System.out.printf("%s%n", e.getMessage());
						e.printStackTrace();
					}
					finally {
						System.out.println();
					}
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
		
		System.out.println("FIN DEL PROGRAMA");
	} //FIN MAIN
	
	private static String ask(String question) {
		System.out.printf("%s: ", question);
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
