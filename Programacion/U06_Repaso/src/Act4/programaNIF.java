package Act4;

public class programaNIF {

	public static void main(String[] args) {
		NIF n1 = new NIF(21679882);
		NIF n2 = new NIF(57521770);
		
		System.out.printf("NIF: %s%n", n1.getNIF());
		System.out.printf("NIF: %s%n", n2.getNIF());
	}
}
