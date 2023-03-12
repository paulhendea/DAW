package Act2;

public class programaCoche {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		coche c1 = new coche("Mercedes", "clase c", 2012, "personal", "blanco", "metálico");
		coche c2 = new coche("BMW", "i3", 2020, "2345GD", "deportivo", "rojo", "mate", "todo riesgo", "Paul Hendea");
		
		c1.mostrarInfo();
		c2.mostrarInfo();
	}

}
