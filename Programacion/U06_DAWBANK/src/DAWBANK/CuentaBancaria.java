package DAWBANK;

import java.lang.Math;
import java.util.ArrayList;

public class CuentaBancaria {
	//ATRIBUTOS
	private static final int mayoriaEdad = 18;
	private static final double saldoMin = -50.0;
	private static final double saldoAvisoHacienda = 3000.0;
	private static final int maxMovimientos = 100;
	
	private final String IBAN;
	private final String TITULAR;
	
	private double saldo = 0;
	private String movimientos[] = new String[maxMovimientos];
	private int numMovimientos = 0; //NUMERO DE MOVIMIENTOS
	
	private static ArrayList<String> cuentasRegistradas = new ArrayList<String>();
	
	
	
	//CONSTRUCTOR
	public CuentaBancaria(String nombre, String apellidos) {
		if(chekName(nombre) && chekName(apellidos)) {
			IBAN = newIban();
			TITULAR = formatName(nombre, apellidos);
		}
		else {
			System.err.println("Error: Nombre incorrecto");
			IBAN = null;
			TITULAR = null;
		}
	}
	
	//GETTERS
	public String getIBAN() {
		return IBAN;
	}
	public String getTitular() {
		return TITULAR;
	}
	public double getSaldo() {
		return saldo;
	}
	
	//METODOS ESTATICOS
	public static boolean chekName(String name) {
		if(name.matches("([A-Z][a-z]* *)*")) {
			return true;
		}
		else {
			return false;
		}
	}
	private static String newIban() {
		//LAS 2 LETRAS INDICAN EL PAÍS, POR LO TANTO USAREMOS SIEMPRE 'ES'
		String iban = "ES";
		
		//CALCULAMOS UN NÚMERO ALEATORIO DE 22 CIFRAS DIFERENTE A LOS QUE YA EXISTEN
		do {
			//EL PRIMER NÚMERO NUNCA SERÁ 0
			iban += String.format("%d", Math.round( (Math.random()*8)+1 ));
			//LOS DEMÁS NÚMEROS PUEDEN SER ENTRE 0 Y 9
			for(int i = 0; i < 21; i++) {
				iban += String.format("%d", Math.round(Math.random()*9));
			}
		}while(ibanNoDispoible(iban));
		addIbanToDataBase(iban);
		return iban;		
	}
	
	private static boolean ibanNoDispoible(String iban) {
		//COMPROBAMOS SI COINCIDE CON ALGUNA YA EXISTENTE EN EL REGISTRO
		if(cuentasRegistradas.contains(iban)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private static void addIbanToDataBase(String iban) {
		//REGISTRAMOS EL NUEVO IBAN
		cuentasRegistradas.add(iban);
	}	
	private static String formatName(String nombre, String apellidos) {
		String fullname = apellidos + (", ") + nombre;
		return fullname;
	}
	private static boolean cantidadCorrecta(double n) {
		if(n > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean esMayorEdad(int edad) {
		if(edad < mayoriaEdad) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public boolean ingresar(double n) {
		if(n > saldoAvisoHacienda) {
			System.out.println("AVISO: Notificar a hacienda");
		}
		if(cantidadCorrecta(n)) {
			//ACTUALIZAMOS SALDO
			saldo += n;
			
			//REGISTRAMOS MOVIMIENTO
			addMovimiento(String.format("Ingreso: %.2f€", n));
			
			return true;
		}
		else { return false; }
	}
	public boolean retirar(double n) {
		if(cantidadCorrecta(n)) {
			if((saldo -n) >= saldoMin) {
				if((saldo -n) < 0) {
					System.out.println("AVISO: Saldo negativo");
				}
				if(n > saldoAvisoHacienda) {
					System.out.println("AVISO: Notificar a hacienda");
				}
				
				//ACTUALIZAMOS SALDO
				saldo -= n;
				
				//REGISTRAMOS MOVIMIENTO
				addMovimiento(String.format("Retirada: %.2f€", n));
				
				return true;
			} else { return false; }
		} else { return false; }
	}
	private void addMovimiento(String ultimoMovimiento) {
		//MOVEMOS TODOS LOS VALORES UNA POSICION
		for(int i = movimientos.length-1; i > 0; i--) {
			movimientos[i] = movimientos[i-1];
		}
		
		//AÑADIMOS EL ULTIMO MOVIMIENTO AL PRINCIPIO
		movimientos[0] = ultimoMovimiento;
		if(numMovimientos < 100) {
			numMovimientos++;
		}
	}
	
	//OTROS METODOS UTILES
	public void imprimirInfo() {
		System.out.printf("IBAN: %s%n", IBAN);
		System.out.printf("Titular: %s%n", TITULAR);
		System.out.printf("Saldo: %.2f€%n", saldo);
		System.out.println();
	}
	public void imprimirMovimientos() {
		System.out.printf("Últimos %d movimientos%n----------------%n", numMovimientos);
		for(int i = numMovimientos-1; i >= 0; i--) {
			System.out.printf("%s%n", movimientos[i]);
		} System.out.println();
	}
}
