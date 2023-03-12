package Act2;

public class Bicicleta extends Vehiculo {
	//ATRIBUTOS
	private String tipo; //CARRETERA O MONTAÑA
	
	//CONSTRUCTOR
	public Bicicleta(String tipo) {
		super();
		this.tipo = tipo;
	}
	public Bicicleta(String tipo, double kilometrosRecorridos) {
		super(kilometrosRecorridos);
		this.tipo = tipo;
	}
	
	//GETTERS Y SETTERS
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//METODOS
	public void hacerTruco() {
		super.recorrer(0.1);
		System.out.println("(caballito)\n"
						+ "    ~~O\r\n"
						+ "  -  /\\,\r\n"
						+ " -  -|~(*)\r\n"
						+ "-  (*)\r\n"
						+ "^^^__________");
	}
	public String info() {
		return "Bicileta de " + tipo;
	}
}
