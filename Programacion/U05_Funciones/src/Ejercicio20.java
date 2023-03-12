
public class Ejercicio20 {

	public static void main(String[] args) {
		
		//IMPRIMIMOS LAS TABLAS DE 1 AL 10 USANDO LA FUNCION
		for(int i = 1; i <= 10; i++) {
			System.out.printf("Tabla del %d%n", i);
			System.out.println("------------");
			printTimeTable(i);
			System.out.println();
		}
	}

	public static void printTimeTable(int n) {
		//MOSTRAMOS LA TABLA DE MULTIPLICAR DE N
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%d x %d = %d%n", n, i, n*i);
		}
	}
}
