package Act2;

public class coche {
	//ATRIBUTOS
	private String marca;
	private String modelo;
	private int añoFabricacion;
	private String matricula;
	private String tipoCoche;
	private String color;
	private String tipoPintura;
	private String seguro;
	private String dueño;
	
	//CONSTRUCTORES
	public coche(String marca, String modelo, int añoFabricacion, String tipoCoche, String color, String tipoPintura) {
		this.marca = marca;
		this.modelo = modelo;
		this.añoFabricacion = añoFabricacion;
		this.tipoCoche = tipoCoche;
		this.color = color;
		this.tipoPintura = tipoPintura;
	}
	public coche(String marca, String modelo, int añoFabricacion, String matricula, String tipoCoche, String color, String tipoPintura, String seguro, String dueño) {
		this.marca = marca;
		this.modelo = modelo;
		this.añoFabricacion = añoFabricacion;
		this.tipoCoche = tipoCoche;
		this.color = color;
		this.tipoPintura = tipoPintura;
		this.seguro = seguro;
		this.dueño = dueño;
	}
	
	//GETTERS
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int añoFabricacion() {
		return añoFabricacion;
	}
	public String getMatricula() {
		return matricula;
	}
	public String getTipoCoche() {
		return tipoCoche;
	}
	public String getColor() {
		return color;
	}
	public String getTipoPintura() {
		return tipoPintura;
	}
	public String getSeguro() {
		return seguro;
	}
	public String getDueño() {
		return dueño;
	}
	
	//SETTERS
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public void setTipoCoche(String tipoCoche) {
		this.tipoCoche = tipoCoche;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public void setTipoPintura(String tipoPintura) {
		this.tipoPintura = tipoPintura;
	}
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}
	public void setDueño(String dueño) {
		this.dueño = dueño;
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Marca: %s%n", marca);
		System.out.printf("Modelo: %s%n", modelo);
		System.out.printf("Color: %s%n", color);
		System.out.println();
	}
}