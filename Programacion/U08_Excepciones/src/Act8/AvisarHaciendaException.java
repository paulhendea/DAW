package Act8;

public class AvisarHaciendaException extends CuentaException {
	//ATRIBUTOS
	private static final long serialVersionUID = 1L;

	private final String TITULAR;
	private final String IBAN;
	private final String OPERACION;
	private final double CANTIDAD;
	
	//CONSTRUCTOR
	public AvisarHaciendaException(String titular, String iban, 
									String operacion, double cantidad) {
		super("Aviso Hacienda");
		this.TITULAR = titular;
		this.IBAN = iban;
		this.OPERACION = operacion;
		this.CANTIDAD = cantidad;
	}
	
	//GETTERS
	public String getTitular() {
		return TITULAR;
	}
	public String getIban() {
		return IBAN;
	}
	public String getOperacion() {
		return OPERACION;
	}
	public double getCantidad() {
		return CANTIDAD;
	}
	
	//METODOS
	public String toString() {
		return String.format("Aviso a haciendo sobre la siguiente operación: %n"
				+ "Titular: %s%n"
				+ "Iban: %s%n"
				+ "%s de %.2f€",
				TITULAR, IBAN, OPERACION, CANTIDAD);
	}
}
