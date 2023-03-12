package Ej2_Astros;

import java.util.ArrayList;

public class Planeta extends Astros {
	//ATRIBUTOS
	private double distanciaSol; //EN KM
	private double orbitaSol; //EN AÑOS
	private int numSatelites;
	private ArrayList<String> sateliteList = new ArrayList<String>();
	
	//CONSTRUCTOR
	public Planeta(String nombre, double radio, double rotacion, String masa,
			double temperatura, double gravedad, double distanciaSol,
			double orbitaSol, int satelites, String satelite[]) {
		super(nombre, radio, rotacion, masa, temperatura, gravedad);
		this.distanciaSol = distanciaSol;
		this.orbitaSol = orbitaSol;
		this.numSatelites = satelites;
		addSatelite(satelite);
	}
	public Planeta(String nombre, double radio, double rotacion, String masa,
			double temperatura, double gravedad, double distanciaSol,
			double orbitaSol, int satelites) {
		super(nombre, radio, rotacion, masa, temperatura, gravedad);
		this.distanciaSol = distanciaSol;
		this.orbitaSol = orbitaSol;
		this.numSatelites = satelites;
	}
	
	//GETTERS Y SETTERS
	public double getDistanciaSol() {
		return distanciaSol;
	}
	public double getOrbitaSol() {
		return orbitaSol;
	}
	public int getSatelites() {
		return numSatelites;
	}
	public ArrayList<String> getSateliteList() {
		return sateliteList;
	}
	
	public void setDistanciaSol(double distancia) {
		distanciaSol = distancia;
	}
	public void setOrbitaSol(double orbita) { 
		orbitaSol = orbita;
	}
	public void setSatelite(int satelites) {
		this.numSatelites = satelites;
	}
	public void setSateliteList(String s[]) {
		addSatelite(s);
	}

	//METODOS
	public void mostrarInfo() {
		System.out.printf("Planeta %s%n", super.getNombre());
		System.out.printf("Masa: %s%n", super.getMasa());
		System.out.printf("Temperatura media: %.2f°C%n", super.getTemperatura());
		System.out.printf("Gravedad: %.2f m/s^2%n", super.getGravedad());
		System.out.printf("Radio ecuatorial: %.2f km%n", super.getRadio());
		System.out.printf("Tiempo rotación sobre su eje: %.2f horas%n", super.getRotacion());
		System.out.printf("Tiempo órbita alrededor del sol: %.2f años%n", orbitaSol);
		System.out.printf("Distancia respecto al sol: %.0f km%n", distanciaSol);
		System.out.printf("Número de satélites: %d%n", numSatelites);
		if(numSatelites > 0) {
			for(int i = 0; i < sateliteList.size(); i++) {
				System.out.printf("-%s%n", sateliteList.get(i));
			}
		}
		System.out.println();
	}
	private void addSatelite(String s[]) {
		for(int i = 0; i < s.length; i++) {
			sateliteList.add(s[i]);
		}
	}
}
