package Ej4_Banco;

public class CuentaAhorro extends CuentaBancaria {
	//ATRIBUTOS
	private static double saldoMin = 500;
	
	//CONSTRUCTOR
	public CuentaAhorro(String IBAN, double saldo) {
		super(IBAN, saldo);
	}
	public CuentaAhorro(String IBAN) {
		super(IBAN);
	}
	
	//METODOS
	public void calcularIntereses() {
		double cantidad;
		if(super.getSaldo() < saldoMin) {
			cantidad = super.getSaldo() * super.getInteres() / 200;
		}
		else if(super.getSaldo() == saldoMin) {
			cantidad = super.getSaldo() * super.getInteres() / 100;
		}
		else {
			cantidad = super.getSaldo() * super.getInteres() / 50;
		}
		super.ingresar(cantidad);
	}
}
