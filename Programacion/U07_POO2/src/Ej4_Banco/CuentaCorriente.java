package Ej4_Banco;

public class CuentaCorriente extends CuentaBancaria {
	//CONSTRUCTOR
	public CuentaCorriente(String IBAN, double saldo) {
		super(IBAN, saldo);
	}
	public CuentaCorriente(String IBAN) {
		super(IBAN);
	}
	
	//METODOS
	public void calcularIntereses() {
		double cantidad = super.getSaldo() * super.getInteres() / 100;
		super.ingresar(cantidad);
	}
}
