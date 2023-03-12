package Ej6_Vehiculos;

public class VehiculoAcuatico extends Vehiculo {
	//ATRIBUTOS
	private final double eslora; //EN METROS
	
	//CONSTRUCTOR
	public VehiculoAcuatico(String matricula, String modelo, double eslora) {
		super(matricula, modelo);
		if(valorNoNegativo(eslora)) {
			this.eslora = eslora;
		}
		else {
			this.eslora = 0;
			System.err.println("ERROR: La eslora no puede ser negativa");
		}
		validarMatricula(matricula);
	}
	
	//GETTERS
	public double getEslora() {
		return eslora;
	}
	
	//METODOS PRIVADOS
	private void validarMatricula(String matricula) {
		boolean isValid = matricula.matches("[A-Z]{3,10}");
		super.setIsValid(isValid);
	}
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
		System.out.printf("Vehículo acuático %s con matrícula %s y %.2fm de eslora%n%n", 
				super.getModelo(), super.getMatricula(), eslora);
	}
}
