package Ej6_Vehiculos;

public class Barco extends VehiculoAcuatico {
	//ATRIBUROS
	private boolean tieneMotor;
	
	//CONSTRUCTOR
	public Barco(String matricula, String modelo, double eslora, boolean tieneMotor) {
		super(matricula, modelo, eslora);
		this.tieneMotor = tieneMotor;
	}
	
	//GETTERS Y SETTERS
	public boolean getTieneMotor() {
		return tieneMotor;
	}
	public void setTieneMotor(boolean tieneMotor) {
		this.tieneMotor = tieneMotor;
	}
	
	//METODOS
	public void printInfo() {
		if(tieneMotor) {
			System.out.printf("Vehículo acuático %s con matrícula %s, %.2fm de eslora, y motor%n%n", 
					super.getModelo(), super.getMatricula(), super.getEslora());
		}
		else {
			System.out.printf("Vehículo acuático %s con matrícula %s, %.2fm de eslora, sin motor%n%n", 
					super.getModelo(), super.getMatricula(), super.getEslora());
		}
	}
}
