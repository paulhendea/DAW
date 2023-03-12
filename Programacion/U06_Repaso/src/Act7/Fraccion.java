package Act7;

import java.lang.Math;

public class Fraccion {
	//ATRIBUTOS
	private int numerador;
	private int denominador;
	private static char separador = '/';
	
	//CONSTRUCTOR
	public Fraccion(int n, int d) {
		if(d != 0) {
			numerador = n;
			denominador = d;
		}
		else {
			System.err.println("ERROR: El denominador no puede ser 0");
		}
	}
	public Fraccion(int n) {
		numerador = n;
		denominador = 1;
	}
	public Fraccion() {
		numerador = 0;
		denominador = 1;
	}
	
	//GETTERS Y SETTERS
	public int getN() {
		return numerador;
	}
	public int getD() {
		return denominador;
	}
	
	public void setN(int n) {
		numerador = n;
	}
	public void setD(int d) {
		if(d != 0) {
			denominador = d;
		}
		else {
			System.err.println("ERROR: El denominador no puede ser 0");
		}
	}
	
	//METODOS ESTATICOS
	public static Fraccion simplificar(Fraccion f) {
		int num = 0, den = 0;
		num = f.getN() / mcd(f);
		den = f.getD() / mcd(f);
		
		return new Fraccion(num, den);
	}
	private static int mcd(Fraccion f) {
		int a, b, r;
		a = Math.max(f.getN(), f.getD());
		b = Math.min(f.getN(), f.getD());
		r = 0;
	    do {
	        r = b;
	        b = a % b;
	        a = r;
	    } while (b != 0);
	    
	    return r;
	}
	
	//METODOS
	public String toString() {
		return String.format("%s%s%s", numerador, separador, denominador);
	}
	public Fraccion sumar(Fraccion f) {
		if(denominador == f.getD()) {
			return simplificar(new Fraccion(numerador + f.getN(), denominador));
		}
		else {
			return simplificar(new Fraccion((numerador * f.getD()) + (f.getN() * denominador)
					, denominador * f.getD()));
		}
	}
	public Fraccion restar(Fraccion f) {
		if(denominador == f.getD()) {
			return simplificar(new Fraccion(numerador - f.getN(), denominador));
		}
		else {
			return simplificar(new Fraccion((numerador * f.getD()) - (f.getN() * denominador)
					, denominador * f.getD()));
		}
	}
	public Fraccion multiplicar(Fraccion f) {
		return simplificar(new Fraccion(numerador * f.getN(), denominador * f.getD()));
	}
	public Fraccion dividir(Fraccion f) {
		return simplificar(new Fraccion(numerador * f.getD(), denominador * f.getN()));
	}
	
}
