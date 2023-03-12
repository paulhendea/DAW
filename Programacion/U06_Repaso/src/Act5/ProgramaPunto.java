package Act5;

public class ProgramaPunto {

	public static void main(String[] args) {
		Punto origen = new Punto(0,0);
		Punto p2 = new Punto(5,3);
		Punto p3 = new Punto(2,-1);
		Punto p4 = new Punto(3,1);
		Punto p5 = new Punto(4,3);
		
		System.out.print("Punto 1: "); origen.mostrarCoordenadas();
		System.out.print("Punto 2: "); p2.mostrarCoordenadas();
		System.out.print("Punto 3: "); p3.mostrarCoordenadas();
		System.out.print("Punto 4: "); p4.mostrarCoordenadas();
		System.out.print("Punto 5: "); p5.mostrarCoordenadas();
		System.out.println();
		
		System.out.printf("Distancia entre Punto 5 y origen: %.2f%n", 
				p5.calcularDistancia(origen));
	}

}
