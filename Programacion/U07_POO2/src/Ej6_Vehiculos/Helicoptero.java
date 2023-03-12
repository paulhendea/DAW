package Ej6_Vehiculos;

public class Helicoptero extends VehiculoAereo {
	//ATRIBUTOS
	private int numHelices;
	
	//CONSTRUCTOR
	public Helicoptero(String matricula, String modelo, int numAsientos, int numHelices) {
		super(matricula, modelo, numAsientos);
		if(valorNoNegativo(numHelices)) {
			this.numHelices = numHelices;
		}
		else {
			this.numHelices = 0;
			System.err.println("ERROR: El n�mero de h�lices no puede ser negativo");
		}
	}
	
	//GETTERS Y SETTERS
	public int getNumHelices() {
		return numHelices;
	}
	public void setNumHelices(int numHelices) {
		if(valorNoNegativo(numHelices)) {
			this.numHelices = numHelices;
		}
		else {
			this.numHelices = 0;
			System.err.println("ERROR: El n�mero de h�lices no puede ser negativo");
		}
	}
	
	//METODOS PRIVADOS
	private boolean valorNoNegativo(int n) {
		if(n < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//METODOS
	public void printInfo() {
		System.out.printf("Veh�culo aereo %s con matr�cula %s, %d asientos, y %d de h�lices%n%n", 
				super.getModelo(), super.getMatricula(), super.getNumAsientos(), numHelices);
	}
}
