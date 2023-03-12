package Act2;

public class Coche extends Vehiculo {
	//ATRIBUTOS
	private String marca;
	
	//CONSTRUCTOR
	public Coche(String marca) {
		super();
		this.marca = marca;
	}
	public Coche(String marca, double kilometrosRecorridos) {
		super(kilometrosRecorridos);
		this.marca = marca;
	}
	
	//GETTERS Y SETTERS
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	//METODOS
	public void hacerTruco() {
		super.recorrer(0.1);
		System.out.println("(derrapa)\n"
						+ "              ____\r\n"
						+ "           __/  |_\\_\r\n"
						+ "          |  _     _``-.\r\n"
						+ "_..___..._'-(_)---(_)--'");
	}
	public String info() {
		return "Coche " + marca;
	}
}
