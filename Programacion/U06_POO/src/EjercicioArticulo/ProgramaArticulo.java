package EjercicioArticulo;

import java.util.Scanner;

public class ProgramaArticulo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//CREAMOS INSTANCIA
		Articulo a1 = new Articulo("Taza", 4.99f, 1, 4);
		
		//MOSTRAMOS VALORES
		a1.imprimir();
		System.out.printf("PVP: %.2f�%n", a1.getPVP());
		System.out.printf("PVP con 50%% de descuento: %.2f�%n", a1.getPVPDescuento(50));
		System.out.println();
		
		//USANDO METODOS
		System.out.print("Introduce cantidad a VENDER: ");
		if(a1.vender(sc.nextInt())) {
			System.out.println("Operaci�n realizada con �xito");
		}
		else {
			System.err.println("Art�culos insuficientes");
		} System.out.println();
		
		System.out.print("Introduce cantidad a ALMACENAR: ");
		if(a1.almacenar(sc.nextInt())) {
			System.out.println("Operaci�n realizada con �xito");
		}
		else {
			System.err.println("Cantidad incorrecta");
		} System.out.println();
		
		//MOSTRAMOS DE NUEVO
		a1.imprimir();

		sc.close();
	}
}
