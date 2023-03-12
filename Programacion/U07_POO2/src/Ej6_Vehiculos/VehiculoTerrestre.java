package Ej6_Vehiculos;

public class VehiculoTerrestre extends Vehiculo {
	//ATRIBUTOS
	private final int numRuedas;
	
	//CONSTRUCTOR
	public VehiculoTerrestre(String matricula, String modelo, int numRuedas) {
		super(matricula, modelo);
		if(valorNoNegativo(numRuedas)) {
			this.numRuedas = numRuedas;
		}
		else {
			this.numRuedas = 0;
			System.err.println("ERROR: El número de ruedas no puede ser negativo");
		}
		validarMatricula(matricula);
	}
	
	//GETTER
	public int getNumRuedas() {
		return numRuedas;
	}	
	
	//METODOS PRIVADOS
	private void validarMatricula(String matricula) {
		boolean isValid = matricula.matches("[0-9]{4}[A-Z]{3}");
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
		System.out.printf("Vehículo terrestre %s con matrícula %s y %d ruedas%n%n", 
				super.getModelo(), super.getMatricula(), numRuedas);
	}
}
