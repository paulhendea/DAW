package EjercicioPunto;

import java.lang.Math;

public class Punto {
	//ATRIBUTOS
	private int x, y;
	
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
	public void imprime() {
		System.out.printf("(%d, %d)%n", x, y);
	}
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void desplaza(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}
	public int distancia(Punto p) {
		if(p.getX() == x) {
			return positivo(y - p.getY());
		}
		else if (p.getY() == y) {
			return positivo(x - p.getX());
		}
		else {
			return (int) (Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2)));
		}
	}
	private int positivo(int n) {
		if (n < 0) {
			n = -n;
		}
		return n;
	}
	
	//STATIC
	public static Punto creaPuntoRandom() {
		int x, y;
		x = (int) (Math.random() * 200 - 100);
		y = (int) (Math.random() * 200 - 100);
		
		return new Punto(x, y);
	}
}
