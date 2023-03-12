package Act8;

public class Cuenta {
	//ATRIBUTOS
	private String IBAN;
	private double saldo;
	private double tipoInteres;
	private Persona cliente;
	
	//CONSTRUCTOR
	public Cuenta(String IBAN, double saldo, double tipoInteres, Persona cliente) {
		this.IBAN = IBAN;
		this.saldo = saldo;
		this.tipoInteres = tipoInteres;
		this.cliente = cliente;
	}
	
	//GETTERS Y SETTERS
	public String getIban() {
		return IBAN;
	}
	public double getSaldo() {
		return saldo;
	}
	public double getTipoInteres() {
		return tipoInteres;
	}
	public Persona getCliente() {
		return cliente;
	}
	
	public void setIban(String IBAN) {
		this.IBAN = IBAN;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public void setTipoInteres(double tipoInteres) {
		this.tipoInteres = tipoInteres;
	}
	public void setCliente (Persona cliente) {
		this.cliente = cliente;
	}
	
	//METODOS
	public boolean ingresar(double cantidad) {
		if(cantidad < 0) {
			return false;
		}
		else {
			saldo += cantidad;
			return true;
		}
	}
	public boolean retirar(double cantidad) {
		if(cantidad < 0) {
			return false;
		}
		else {
			saldo -= cantidad;
			return true;
		}
	}
	public boolean transferir(Cuenta destinatario, double cantidad) {
		if(cantidad < 0) {
			return false;
		}
		else {
			saldo -= cantidad;
			destinatario.ingresar(cantidad);
			return true;
		}
	}
}
