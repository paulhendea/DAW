package Ej7_Figuras;

import java.lang.Math;

public interface iFigura2D {
	//ATRIBUTOS
	double PI = Math.PI;
	
	//METODOS
	double perimetro();
	double area();
	boolean escalar(double escala);
	void imprimir();
	
}
