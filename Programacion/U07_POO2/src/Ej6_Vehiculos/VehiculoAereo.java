package Ej6_Vehiculos;

public class VehiculoAereo extends Vehiculo {
	//ATRIBUTOS
	private final int numAsientos;
	
	//CONSTRUCTOR
	public VehiculoAereo(String matricula, String modelo, int numAsientos) {
		super(matricula, modelo);
		if(valorNoNegativo(numAsientos)) {
			this.numAsientos = numAsientos;
		}
		else {
			this.numAsientos = 0;
			System.err.println("ERROR: El número de asientos no puede ser negativo");
		}
		validarMatricula(matricula);
	}
	
	//GETTERS
	public int getNumAsientos() {
		return numAsientos;
	}
	
	//METODOS PRIVADOS
	private void validarMatricula(String matricula) {
		boolean isValid = matricula.matches("[A-Z]{4}[0-9]{6}");
		super.setIsValid(isValid);
	}
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
		System.out.printf("Vehículo aereo %s con matrícula %s y %d asientos%n%n", 
				super.getModelo(), super.getMatricula(), numAsientos);
	}
}
