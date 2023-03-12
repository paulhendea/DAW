package Ej7_Figuras;

public class Rectangulo implements iFigura2D {
	//ATRIBUTOS
	private double ancho;
	private double alto;
	
	//CONSTRUCTOR
	public Rectangulo(double ancho, double alto) {
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
		return 2 * (ancho + alto);
	}
	public double area() {
		return ancho * alto;
	}
	public void imprimir() {
		System.out.printf("Rectángulo de %.2f de ancho y %.2f de alto, perímetro de %.2f, y área de %.2f%n", 
				ancho, alto, perimetro(), area());
	}
}
