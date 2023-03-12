package Ej4_Banco;

public abstract class CuentaBancaria {
	//ATRIBUTOS
	private final String IBAN;
	private double saldo;
	private static double interesAnualBasico = 5; //%PORCIENTO
	
	//CONSTRUCTOR
	public CuentaBancaria(String IBAN, double saldo) {
		this.IBAN = IBAN;
		this.saldo = saldo;
	}
	public CuentaBancaria(String IBAN) {
		this.IBAN = IBAN;
	}
	
	//GETTERS
	public String getIban() {
		return IBAN;
	}
	public double getSaldo() {
		return saldo;
	}
	public double getInteres() {
		return interesAnualBasico;
	}
	
	//METODOS PRIVADOS
	private void añadir(double cantidad) {
		saldo += cantidad;
	}
	
	//METODOS
	public void ingresar(double cantidad) {
		añadir(cantidad);
	}
	public void retirar(double cantidad) {
		añadir(-cantidad);
	}
	public void transferir(CuentaBancaria cuenta, double cantidad) {
		retirar(cantidad);
		cuenta.ingresar(cantidad);
	}
	public void mostrarInfo() {
		System.out.printf("IBAN: %s%n", IBAN);
		System.out.printf("Saldo: %.2f�%n", saldo);
	}
	public abstract void calcularIntereses();
}
