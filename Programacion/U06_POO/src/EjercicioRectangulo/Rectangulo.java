package EjercicioRectangulo;

public class Rectangulo {
	//ATRIBUTOS
	private int x1, y1, x2, y2;
	private static final int min = 0, max = 100;
	
	//CONSTRUCTOR
	public Rectangulo(int x1, int y1, int x2, int y2) {
		//COMPROBAMOS VALORES
		if( incorrecto(x1) || incorrecto(y1) || incorrecto(x2) || incorrecto(y2) ) {
			System.err.println("ERROR: Valores incorrectos");
		}
		else {
			if ((x1 < x2) && (y1 < y2)) {
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
		
	
	//GETTERS Y SETTERS
	public int getX1() {
		return x1;
	}
	public int getY1() {
		return y1;
	}
	public int getX2() {
		return x2;
	}
	public int getY2() {
		return y2;
	}
	public void setX1(int x1) {
		if(incorrecto(x1)) {
			System.err.println("ERROR: Valor incorrectos");
		}
		else {
			if ( x1 < this.x2) {
				this.x1 = x1;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	public void setY1(int y1) {
		if(incorrecto(y1)) {
			System.err.println("ERROR: Valor incorrectos");
		}
		else {	
			if ( y1 < this.y2) {
				this.y1 = y1;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	public void setX2(int x2) {
		if(incorrecto(x2)) {
			System.err.println("ERROR: Valor incorrectos");
		}
		else {	
			if ( x2 > this.x1) {
				this.x2 = x2;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	public void setY2(int y2) {
		if(incorrecto(y2)) {
			System.err.println("ERROR: Valor incorrectos");
		}
		else {	
			if ( y2 > this.y2) {
				this.y2 = y2;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	
	//METODOS
	public void imprimir() {
		System.out.printf("a=(%d, %d) b=(%d, %d)%n", x1, y1, x2, y2);
	}
	public void setXY1(int x1, int y1) {
		if(incorrecto(x1) || incorrecto(y1)) {
			System.err.println("ERROR: Valor incorrectos");
		}
		else {	
			if((x1 < this.x2) && (y1 < this.y2)) {
				this.x1 = x1;
				this.y1 = y1;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	public void setXY2(int x2, int y2) {
		if(incorrecto(x2) || incorrecto(y2)) {
			System.err.println("ERROR: Valor incorrectos");
		}
		else {
			if((x2 > this.x1) && (y2 > this.y1)) {
				this.x2 = x2;
				this.y2 = y2;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	public void setAll(int x1, int y1, int x2, int y2) {
		if( incorrecto(x1) || incorrecto(y1) || incorrecto(x2) || incorrecto(y2) ) {
			System.err.println("ERROR: Valores incorrectos");
		}
		else {
			if ((x1 < x2) && (y1 < y2)) {
				this.x1 = x1;
				this.y1 = y1;
				this.x2 = x2;
				this.y2 = y2;
			}
			else {
				System.err.println("ERROR: Orden incorrecto de coordenadas");
			}
		}
	}
	public int getPerimetro() {
		return ( (altura() * 2) + (ancho() * 2) );
	}
	public  int getArea() {
		return ( altura() * ancho() );
	}
	private int altura() {
		int altura = y2 - y1;
		return altura;
	}
	private int ancho() {
		int ancho = x2 - x1 ;
		return ancho;
	}
	private boolean incorrecto(int n) {
		if(n < min || n > max) {
			return true;
		}
		return false;
	}
	
	//STATIC
	public static Rectangulo crearRectanguloRandom() {
		int x1, y1, x2, y2;
		x1 = (int) (Math.random() * (max -1));
		y1 = (int) (Math.random() * (max -1));
		x2 = ((int) (Math.random() * (max - x1))) + x1;
		y2 = ((int) (Math.random() * (max - y1))) + y1;
		
		return new Rectangulo(x1, y1, x2, y2);
	}
}
