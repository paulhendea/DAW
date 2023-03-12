package EjercicioRectangulo;

public class ProgramaRectangulo {

	public static void main(String[] args) {
		//CREAMOS INSTANCIAS
		Rectangulo r[] = new Rectangulo[4];
		r[0] = new Rectangulo(0, 0, -5, 5);
		r[1] = new Rectangulo(7, 9, 8, 120);
		r[2] = Rectangulo.crearRectanguloRandom();
		r[3] = Rectangulo.crearRectanguloRandom();
		
		//MOSTRAMOS CALCULOS
		for(int i = 0; i < r.length; i ++) {
			System.out.printf("Rectángulo %d%n-----------%n", i+1);
			System.out.print("Coordenadas: ");r[i].imprimir();
			System.out.printf("Perímetro: %d%n", r[i].getPerimetro());
			System.out.printf("Área: %d%n", r[i].getArea());
			System.out.println();
		}
		
		//ASIGNAMOS VALORES DIFERENTES
		r[0].setXY1(2, 0); r[0].setXY2(5, 10);
		r[1].setAll(5, 12, 12, 13);
		
		//MOSTRAMOS CALCULOS NUEVOS
		for(int i = 0; i < r.length; i ++) {
			System.out.printf("Rectángulo %d%n-----------%n", i+1);
			System.out.print("Coordenadas: ");r[i].imprimir();
			System.out.printf("Perímetro: %d%n", r[i].getPerimetro());
			System.out.printf("Área: %d%n", r[i].getArea());
			System.out.println();
		}
	}
}
