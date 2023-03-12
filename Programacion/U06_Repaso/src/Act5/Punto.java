package Act5;

import java.lang.Math;

public class Punto {
	//ATRIBUTOS
	private int x;
	private int y;
	
	//CONSTRUCTOR
	public Punto(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//GETTERS Y SETTERS
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	//METODOS
	public double calcularDistancia(Punto p1) {
		double distancia = Math.sqrt(Math.pow((p1.getX() - x), 2) 
				+ Math.pow((p1.getY() - y), 2));
		return distancia;
	}
	public void mostrarCoordenadas() {
		System.out.printf("(%d, %d)%n", x, y);
	}
}
