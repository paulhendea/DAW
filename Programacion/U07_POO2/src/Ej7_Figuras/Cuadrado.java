package Ej7_Figuras;

import java.lang.Math;

public class Cuadrado implements iFigura2D {
	//ATRIBUTOS
	private double lado;
	
	//CONSTRUCTOR
	public Cuadrado(double lado) {
		if(mayorQue0(lado)) {
			this.lado = lado;
		}
	}
	
	//GETTERS Y SETTERS
	public double getLado() {
		return lado;
	}
	public void setLado(double lado) {
		if(mayorQue0(lado)) {
			this.lado = lado;
		}
		else {
			lado = 0;
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
			lado *= escala;
			return true;
		}
		else {
			return false;
		}
	}
	public double perimetro() {
		return lado * 4;
	}
	public double area() {
		return Math.pow(lado, 2);
	}
	public void imprimir() {
		System.out.printf("Cuadrado con lado de %.2f, perímetro de %.2f, y área de %.2f%n", 
				lado, perimetro(), area());
	}
}
