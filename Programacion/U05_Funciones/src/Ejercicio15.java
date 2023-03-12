
public class Ejercicio15 {

	public static void main(String[] args) {
		int num[] = new int[100];
		for(int i = 0; i < num.length; i++) {
			num[i] = i+1;
		}
		
		//MOSTRAMOS RESULTADOS
		System.out.printf("La suma del array es de: %d%n", addArray(num));
		System.out.printf("La media del array es de: %.1f%n", averageArray(num));
	}
	
	public static int addArray(int n[]) {
		int add = 0;
		
		//CALCULAMOS SUMA
		for(int i = 0; i < n.length; i++) {
			add += n[i];
		}
		return add;
	}
	
	public static double averageArray(int n[]) {
		double average = 0;
		
		//CALCULAMOS MEDIA
		for(int i = 0; i < n.length; i++) {
			average += n[i];
		}
		average = average / n.length;
		return average;
	}
}
