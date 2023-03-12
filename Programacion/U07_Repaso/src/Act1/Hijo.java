package Act1;

public class Hijo extends Padre {
	private int edad;
	public Hijo (int edad) {
		this.edad = edad;
	}
	public String toString() {
		return super.toString() + ",edad:" + edad;
	}

}
