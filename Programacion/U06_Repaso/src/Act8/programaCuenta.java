package Act8;

import java.util.ArrayList;

public class programaCuenta {

	public static void main(String[] args) {
		//CREAMOS UN ARRAYLIST CON ALGUNAS CUENTAS
		ArrayList<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas.add(new Cuenta("ESetc", 0, 5, 
					new Persona("12345678A", "Alin", "Hendea", "C/ manco n5", "alinos@fbi.com", 
					new Fecha(2005, 06, 26))));
		cuentas.add(new Cuenta("ESetc", 50, 5, 
					new Persona("12345678B", "Paul", "Hendea", "C/ manco n6", "pol@fbi.com", 
					new Fecha(1999, 9, 9))));
		
		//MOSTRAMOS INFO DE LAS CUENTAS
		for(int i = 0; i < cuentas.size(); i++) {
			Cuenta c = (Cuenta) cuentas.get(i);
			Persona p = (Persona) c.getCliente();
			System.out.printf("%s nacido el %s%n", p.toString(), p.getFechaNacimiento());
			System.out.printf("IBAN: %s%n", c.getIban());
			System.out.printf("Saldo: %.2f€%n", c.getSaldo());
			System.out.printf("Tipo de interés: %.0f%%%n", c.getTipoInteres());
			System.out.println();
		}
	}
}
