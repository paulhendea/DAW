package Ej4_Banco;

import java.util.ArrayList;

public class programaBanco {

	public static void main(String[] args) {
		ArrayList<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
		cuentas.add(new CuentaCorriente("ES0000000000000000000001"));
		cuentas.add(new CuentaAhorro("ES0000000000000000000002"));
		cuentas.add(new CuentaAhorro("ES0000000000000000000003", 500));
		cuentas.add(new CuentaAhorro("ES0000000000000000000004"));
		
		//INGRESAMOS 50€ EN LA CUENTA TERMINADA EN 1
		CuentaBancaria cuenta = (CuentaBancaria) cuentas.get(0);
		cuenta.ingresar(50);
		
		//RETIRAMOS 50€ DE LA CUENTA TERMINADA EN 2
		cuenta = (CuentaBancaria) cuentas.get(1);
		cuenta.retirar(50);
		
		//TRANSFERIMOS 500€ DE LA CUENTA TERMINADA EN 3 A LA TERMINADA EN 4
		cuenta = (CuentaBancaria) cuentas.get(2);
		cuenta.transferir(cuentas.get(3), 500);
		
		//INGRESAMOS 600€ EN LA CUENTA TERMINADA EN 3
		cuenta.ingresar(600);
		
		for(int i = 0; i < cuentas.size(); i++) {
			cuenta = (CuentaBancaria) cuentas.get(i);
			cuenta.mostrarInfo();
			cuenta.calcularIntereses();
			System.out.printf("Después de aplicar intereses: %.2f€%n", cuenta.getSaldo());
			System.out.println();
		}
	}

}
