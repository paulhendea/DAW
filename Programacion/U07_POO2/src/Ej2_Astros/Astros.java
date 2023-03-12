package Ej2_Astros;

public abstract class Astros {
	//ATRIBUTOS
	private String nombre;
	private double radioEcuatorial; //EN KM
	private double rotacionEje; //EN HORAS
	private String masa; // LA UNIDAD DE MEDIDA DEBE SER ESPECIFICADA
	private double temperaturaMedia; //EN GRADOS CELSIUS
	private double gravedad; //EN UNIDADES DE ACELERACIÓN (metros/segundo^2)
	
	//CONSTRUCTOR
	public Astros(String nombre, double radioEcuatorial, double rotacionEje, 
			String masa, double temperaturaMedia, double gravedad) {
		this.nombre = nombre;
		this.radioEcuatorial = radioEcuatorial;
		this.rotacionEje = rotacionEje;
		this.masa = masa;
		this.temperaturaMedia = temperaturaMedia;
		this.gravedad = gravedad;
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public double getRadio() {
		return radioEcuatorial;
	}
	public double getRotacion() {
		return rotacionEje;
	}
	public String getMasa() {
		return masa;
	}
	public double getTemperatura() {
		return temperaturaMedia;
	}
	public double getGravedad() {
		return gravedad;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setRadio(double radio) {
		radioEcuatorial = radio;
	}
	public void setToracion(double rotacion) {
		rotacionEje = rotacion;
	}
	public void setMasa(String masa) {
		this.masa = masa;
	}
	public void setTemperatura(double temp) {
		temperaturaMedia = temp;
	}
	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}
	
	//METODOS
	public abstract void mostrarInfo();
}
