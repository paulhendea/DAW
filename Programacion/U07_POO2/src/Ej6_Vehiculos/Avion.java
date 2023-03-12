package Ej6_Vehiculos;

public class Avion extends VehiculoAereo {
	//ATRIBUTOS
	private double tiempoVueloMax; //EN HORAS
	
	//CONSTRUCTOR
	public Avion(String matricula, String modelo, int numAsientos, double tiempoVueloMax) {
		super(matricula, modelo, numAsientos);
		if(valorNoNegativo(tiempoVueloMax)) {
			this.tiempoVueloMax = tiempoVueloMax;
		}
		else {
			this.tiempoVueloMax = 0;
			System.err.println("ERROR: El tiempo de vuelo máximo no puede ser negativo");
		}
	}
	
	//GETTERS Y SETTERS
	public double getTiempoVueloMax() {
		return tiempoVueloMax;
	}
	public void setTiempoVueloMax(double tiempoVueloMax) {
		if(valorNoNegativo(tiempoVueloMax)) {
			this.tiempoVueloMax = tiempoVueloMax;
		}
		else {
			this.tiempoVueloMax = 0;
			System.err.println("ERROR: El tiempo de vuelo máximo no puede ser negativo");
		}
	}
	
	//METODOS PRIVADOS
	private boolean valorNoNegativo(double n) {
		if(n < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public void printInfo() {
		System.out.printf("Vehículo aereo %s con matrícula %s, %d asientos, y %.2fh máximas de vuelo%n%n", 
				super.getModelo(), super.getMatricula(), super.getNumAsientos(), tiempoVueloMax);
	}
}
