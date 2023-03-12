package Ej7_Figuras;

import java.lang.Math;

public class Circulo implements iFigura2D {
	//ATRIBUTO
	private double radio;
	
	//CONSTRUCTOR
	public Circulo(double radio) {
		if(mayorQue0(radio)) {
			this.radio = radio;
		}
	}
	
	//GETTERS Y SETTERS
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		if(mayorQue0(radio)) {
			this.radio = radio;
		}
	}
	
	//METODOS PRIVADOS
	private boolean mayorQue0(double valor) {
		if(valor > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//METODOS
	public boolean escalar(double escala) {
		if(mayorQue0(escala)) {
			radio *= escala;
			return true;
		}
		else {
			return false;
		}
	}
	public double perimetro() {
		return radio * 2 * Math.PI;
	}
	public double area() {
		return Math.pow(radio, 2) * Math.PI;
	}
	public void imprimir() {
		System.out.printf("Círculo de radio %.2f , perímetro de %.2f, y área de %.2f%n", 
				radio, perimetro(), area());
	}
}
