package Ej6_Vehiculos;

public abstract class Vehiculo {
	//ATRIBUTOS
	private final String matricula;
	private final String modelo;
	private boolean isValid = true;
	
	//CONSTRUCTOR
	public Vehiculo(String matricula, String modelo) {
		this.matricula = matricula;
		this.modelo = modelo;
	}
	
	//GETTERS
	public String getMatricula() {
		return matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public boolean getIsValid() {
		return isValid;
	}
	
	//SETTER
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	//METODOS
	public abstract void printInfo();
}
