package Act1;

public class Herencia {

	public static void main(String[] args) {	
		Hijo h = new Hijo(1);
		Padre p = new Padre("padre");
		Abuelo a1 = new Abuelo("abuelo");

		Abuelo a2 = new Hijo(2);

		System.out.println("h:" + h); 
		System.out.println("p:" + p); 
		System.out.println("a1:" + a1); 
		System.out.println("a2:" + a2); 
		System.out.println("h:" + (Abuelo)h); 


	}

}
