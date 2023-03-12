
package EjercicioPunto;

public class ProgramaPunto {

	public static void main(String[] args) {
		//CREAMOS INSTANCIAS Y ASIGNAMOS VALORES
		Punto p1 = new Punto(5, 0);
		Punto p2 = new Punto(10, 10);
		Punto p3 = new Punto(-3, 7);
		Punto p4 = Punto.creaPuntoRandom();
		Punto p5 = Punto.creaPuntoRandom();
		Punto p6 = Punto.creaPuntoRandom();
		
		//MOSTRAMOS PUNTOS
		System.out.print("Punto 1:");p1.imprime();
		System.out.print("Punto 2:");p2.imprime();
		System.out.print("Punto 3:");p3.imprime();
		System.out.println();
		
		System.out.println("Puntos aleatorios");
		System.out.print("Punto 4:");p4.imprime();
		System.out.print("Punto 5:");p5.imprime();
		System.out.print("Punto 6:");p6.imprime();
		System.out.println();
		
		//MODIFIVAMOS VALORES
		p1.setXY(5-5, 0+5);
		p2.setXY(20, 5);
		p3.setXY(p3.getX() -3, p3.getY() *7);
		
		//MOSTRAMOS DE NUEVO
		System.out.print("Punto 1:");p1.imprime();
		System.out.print("Punto 2:");p2.imprime();
		System.out.print("Punto 3:");p3.imprime();
		System.out.println();
		
		//DESPLAZAMOS PUNTOS
		p1.desplaza(10, 5);
		p2.desplaza(-5, -5);
		p3.desplaza(16, -39);
		
		//MOSTRAMOS DE NUEVO
		System.out.print("Punto 1:");p1.imprime();
		System.out.print("Punto 2:");p2.imprime();
		System.out.print("Punto 3:");p3.imprime();
		System.out.println();
		
		//MOSTRAMOS DISTANCIA
		System.out.printf("Distancia entre puntos 1 y 3: %d", p1.distancia(p3));
	}

}
