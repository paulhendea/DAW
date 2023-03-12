package Act1;

public class Padre extends Abuelo {
	public Padre() {
	}
	public Padre(String name) {
		super(name);
	}
	public String toString(int i) {
		return "padre" + super.toString();
	}

}
