package Act8;

public class AvisarHaciendaAndSaldoNegativoException extends AvisarHaciendaException {
	private static final long serialVersionUID = 1L;

	public AvisarHaciendaAndSaldoNegativoException(String titular, String iban, 
													String operacion, double cantidad) {
		super(titular, iban, operacion, cantidad);
	}
	
	//METODOS
	public String toString() {
		return String.format(" Aviso: Saldo negativo%n"
				+ "Aviso a haciendo sobre la siguiente operación: %n"
				+ "Titular: %s%n"
				+ "Iban: %s%n"
				+ "%s de %.2f€",
				super.getTitular(), super.getIban(), 
				super.getOperacion(), super.getCantidad());
	}
}
