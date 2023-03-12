package Ej7_Figuras;

import java.util.ArrayList;

public class programaFiguras {

	public static void main(String[] args) {
		//CREAMOS ARRAYLIST
		ArrayList<iFigura2D> figuras = new ArrayList<iFigura2D>();
		
		//INSTANCIAMOS OBJETOS Y LOS GUARDAMOS EN EL ARRAYLIST
		figuras.add(new Cuadrado(5));
		figuras.add(new Rectangulo(4, 8));
		figuras.add(new Triangulo(6, 5));
		figuras.add(new Circulo(3));
		
		//MOSTRAMOS INFO DE LAS FIGURAS
		for(int i = 0; i < figuras.size(); i++) {
			iFigura2D figura = (iFigura2D) figuras.get(i);
			System.out.printf("%d. ", i);
			figura.imprimir();
		}
		System.out.println();
		
		//ESCALAMOS A 2 TODAS LAS FIGURAS Y MOSTRAMOS DE NUEVO
		System.out.println("Escalamos las figuras a 2");
		for(int i = 0; i < figuras.size(); i++) {
			iFigura2D figura = (iFigura2D) figuras.get(i);
			figura.escalar(2);
			System.out.printf("%d. ", i);
			figura.imprimir();
		}
		System.out.println();
		
		//ESCALAMOS A 0.1 TODAS LAS FIGURAS Y VOLVEMOS A MOSTRAR
		System.out.println("Escalamos las figuras a 0.1");
		for(int i = 0; i < figuras.size(); i++) {
			iFigura2D figura = (iFigura2D) figuras.get(i);
			figura.escalar(0.1);
			System.out.printf("%d. ", i);
			figura.imprimir();
		}
	}
}
