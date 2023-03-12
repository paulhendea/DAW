package Ej2_Astros;

public class Satelite extends Astros {
	//ATRIBUTOS	
	private double distanciaPlaneta; //EN KM
	private double orbitaPlaneta; //EN DIAS
	private String pertenecePlaneta;
	
	//CONSTRUCTOR
	public Satelite(String nombre, double radio, double rotacion, String masa,
			double temperatura, double gravedad, double distanciaPlaneta, 
			double orbitaPlaneta, String pertenecePlaneta) {
		super(nombre, radio, rotacion, masa, temperatura, gravedad);
		this.distanciaPlaneta = distanciaPlaneta;
		this.orbitaPlaneta = orbitaPlaneta;
		this.pertenecePlaneta = pertenecePlaneta;
	}
	
	//GETTERS Y SETTERS
	public double getDistanciaPlaneta() {
		return distanciaPlaneta;
	}
	public double getOrbitaPlaneta() {
		return orbitaPlaneta;
	}
	public String getPlaneta() {
		return pertenecePlaneta;
	}
	
	public void setDistanciaPlaneta(double distancia) {
		distanciaPlaneta = distancia;
	}
	public void setOrbitaPlaneta(double orbita) {
		orbitaPlaneta = orbita;
	}
	public void setPlaneta(String planeta) {
		pertenecePlaneta = planeta;
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Satélite %s del planeta %s%n", super.getNombre(), pertenecePlaneta);
		System.out.printf("Masa: %s%n", super.getMasa());
		System.out.printf("Temperatura media: %.2f°C%n", super.getTemperatura());
		System.out.printf("Gravedad: %.2f m/s^2%n", super.getGravedad());
		System.out.printf("Radio ecuatorial: %.2f km%n", super.getRadio());
		System.out.printf("Tiempo rotación sobre su eje: %.2f horas%n", super.getRotacion());
		System.out.printf("Tiempo órbita alrededor del planeta: %.2f días%n", orbitaPlaneta);
		System.out.printf("Distancia respecto al planeta: %.2f km%n", distanciaPlaneta);
		System.out.println();
	}
}
