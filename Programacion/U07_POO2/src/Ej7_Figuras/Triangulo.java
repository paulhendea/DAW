package Ej7_Figuras;

import java.lang.Math;

public class Triangulo implements iFigura2D {
	//YA QUE LAS FORMULAS PARA EL PERIMETRO DIFIEREN 
	//SEGUN LAS CLASES DE TRIANGULOS QUE EXISTEN
	//DAMOS POR HECHO QUE ES RECTANGULO
	
	//ATRIBUTOS
	private double ancho;
	private double alto;
	
	//CONSTRUCTOR
	public Triangulo(double ancho, double alto) {
		if(mayorQue0(ancho) && mayorQue0(alto)) {
			this.ancho = ancho;
			this.alto = alto;
		}
	}
	
	//GETTERS Y SETTERS
	public double getAncho() {
		return ancho;
	}
	public double getAlto() {
		return alto;
	}
	
	public void setAncho(double ancho) {
		if(mayorQue0(ancho)) {
			this.ancho = ancho;
		}
	}
	public void setAlto(double alto) {
		if(mayorQue0(alto)) {
			this.alto = alto;
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
			ancho *= escala;
			alto *= escala;
			return true;
		}
		else {
			return false;
		}
	}
	public double perimetro() {
		double h = Math.sqrt(Math.pow(alto, 2) + Math.pow(ancho, 2));
		 return alto + ancho + h;
	}
	public double area() {
		 return ancho * alto / 2;
	}
	public void imprimir() {
		System.out.printf("Triángulo rectángulo de %.2f de ancho y %.2f de alto, perímetro de %.2f, y área de %.2f%n", 
				ancho, alto, perimetro(), area());
	}
}
