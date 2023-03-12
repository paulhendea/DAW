import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double alto = 0, ancho = 0;
		
		//OBTENEMOS DATOS POR TECLADO
		System.out.print("Introduce la altura del rect�ngulo: ");
		alto = sc.nextDouble();
		System.out.print("Introduce el ancho del rect�ngulo: ");
		ancho = sc.nextDouble();
		System.out.println();
		
		//APLICACMOS FUNCION Y MOSTRAMOS RESULTADO
		System.out.printf("Per�metro: %.3f%n", perimetroRectangulo(alto, ancho));
		System.out.printf("�rea: %.3f%n", areaRectangulo(alto, ancho));
		
		sc.close();
	}
	
	public static double perimetroRectangulo(double alto, double ancho) {
		double r = 0;
		
		//CALCULAMOS PERIMETRO
		r = 2*alto + 2*ancho;
		return r;
	}
	
	public static double areaRectangulo(double alto, double ancho) {
		double r = 0;
		
		//CALCULAMOS AREA
		r = alto * ancho;
		return r;
	}
}
