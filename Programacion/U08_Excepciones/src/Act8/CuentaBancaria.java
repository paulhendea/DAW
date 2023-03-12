package Act8;

import java.lang.Math;
import java.util.ArrayList;

public class CuentaBancaria {
	//ATRIBUTOS
	private static final int mayoriaEdad = 18;
	private static final double saldoMin = -50.0;
	private static final double saldoAvisoHacienda = 3000.0;
	
	private final String IBAN;
	private final String TITULAR;
	
	private double saldo = 0;
	
	private static ArrayList<String> movimientos = new ArrayList<String>();
	private static ArrayList<String> cuentasRegistradas = new ArrayList<String>();
	
	
	
	//CONSTRUCTOR
	public CuentaBancaria(String nombre, String apellidos, int edad) throws CuentaException {
		if((nombre == null) || (nombre == "") || (apellidos == null) || (apellidos == "")) {
			throw new CuentaException("Faltan nombres o apellidos");
		}
		if(!chekName(nombre) || !chekName(apellidos)) {
			throw new CuentaException("Nombre o apellidos incorrectos");
		}
		if(!esMayorEdad(edad)) {
			throw new CuentaException("El usuario debe ser mayor de edad");
		}
		
		IBAN = newIban();
		TITULAR = formatName(nombre, apellidos);
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
	public void ingresar(double n) throws CuentaException, AvisarHaciendaException {
		if(!cantidadCorrecta(n)) {
			throw new CuentaException("La cantidad debe ser superior a 0");
		}
		
			//ACTUALIZAMOS SALDO
			saldo += n;
			
			//REGISTRAMOS MOVIMIENTO
			addMovimiento(String.format("Ingreso: %.2f€", n));
		
		if(n > saldoAvisoHacienda) {
			throw new AvisarHaciendaException(TITULAR, IBAN, "Ingreso", n);
		}
	}
	public void retirar(double n) throws CuentaException, AvisarHaciendaException, 
										AvisarHaciendaAndSaldoNegativoException {
		if(!cantidadCorrecta(n)) {
			throw new CuentaException("La cantidad debe ser superior a 0");
		}
		if((saldo -n) < saldoMin) {
			System.out.println(saldo -n);
			throw new CuentaException("No dispone de saldo suficiente");
		}
		
		//ACTUALIZAMOS SALDO
		saldo -= n;
		
		//REGISTRAMOS MOVIMIENTO
		addMovimiento(String.format("Retirada: %.2f€", n));
				
		if((saldo < 0.0) && (n > saldoAvisoHacienda)) {
			throw new AvisarHaciendaAndSaldoNegativoException(TITULAR, IBAN, "Reitrada", n);
		}
		else if(n > saldoAvisoHacienda) {
			throw new AvisarHaciendaException(TITULAR, IBAN, "Retirada", n);
		}
		else if(saldo < 0.0) {
			throw new CuentaException("Aviso: Saldo negativo");
		}
	}
	private void addMovimiento(String ultimoMovimiento) {
		//AÑADIMOS EL ULTIMO MOVIMIENTO
		movimientos.add(ultimoMovimiento);
	}
	
	//OTROS METODOS UTILES
	public void imprimirInfo() {
		System.out.printf("IBAN: %s%n", IBAN);
		System.out.printf("Titular: %s%n", TITULAR);
		System.out.printf("Saldo: %.2f€%n", saldo);
		System.out.println();
	}
	public void imprimirMovimientos() {
		System.out.println("Últimos movimientos\n----------------");
		for(String movimiento: movimientos) {
			System.out.println(movimiento);
		} System.out.println();
	}
}
