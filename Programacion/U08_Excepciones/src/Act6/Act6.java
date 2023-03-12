package Act6;

public class Act6 {

	public static void main(String[] args) {
		//CREAMOS INSTANCIAS DE LA CLASE GATO
		try {
			Gato g1 = new Gato("Aldo", 1);
			System.out.println("Gato registrado correctamente");
			g1.print();
			Gato g2 = new Gato("Julio", -2);
			System.out.println("Gato registrado correctamente");
			g2.print();
			Gato g3 = new Gato("g", -1);
			System.out.println("Gato registrado correctamente");
			g3.print();
		}
		catch (Exception e) {
			System.out.printf("%s%n", e.getMessage());
			e.printStackTrace();
		}
		
		try {
			Gato g4 = new Gato("Gato", 4);
			System.out.println("Gato registrado correctamente");
			g4.print();
			g4.setNombre("Mario");
			g4.setEdad(5);
			System.out.println("Datos del gato modificados");
			g4.print();
			g4.setNombre("Al");
			System.out.println("Datos del gato modificados");
			g4.print();
		}
		catch (Exception e) {
			System.out.println("Datos incorrectos para el gato");
			e.getMessage();
			e.printStackTrace();
		}
		
	}
}
