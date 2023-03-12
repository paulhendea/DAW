
public class EjercicioRecursividad {

	public static void main(String[] args) {
		
		System.out.printf("Factorial de forma recursiva de 5: %d%n", factorial(5));
		System.out.printf("Potencia de forma iterativa de 5^3: %.1f%n", potencia(5, 3));
		System.out.printf("Potencia de forma recursiva de -5^3: %.1f%n", potenciaRecursiva(-5, 3));
	
	}
	
	public static long factorial(int n) {
		long resultado;
		
		if(n == 0) {
			resultado = 1;
		}
		else {
			resultado = n * factorial(n-1);
		}
		return resultado;
	}
	
	public static double potencia(double a, int n) {
		double resultado = 1;
		
		for(int i = 1; i <= n; i++) {
			resultado *= a;
		}
		return resultado;
	}
	
	public static double potenciaRecursiva(double a, int n) {
		double resultado;
		
		if(n == 0) {
			resultado = 1;
		}
		else {
			resultado = a * potenciaRecursiva(a, n-1);
		}
		return resultado;
	}
}
