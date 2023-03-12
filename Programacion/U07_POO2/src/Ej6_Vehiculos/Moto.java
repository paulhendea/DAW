package Ej6_Vehiculos;

public class Moto extends VehiculoTerrestre {
	//ATRIBUTOS
	private String color;
	
	//CONSTRUCTOR	
	public Moto(String matricula, String modelo, int numRuedas, String color) {
		super(matricula, modelo, numRuedas);
		this.color = color;
	}
	
	//GETTERS Y SETTERS
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	//METODOS
	public void printInfo() {
		System.out.printf("Vehículo terrestre %s %s con matrícula %s y  %d ruedas%n%n", 
				color, super.getModelo(), super.getMatricula(), super.getNumRuedas());
	}
}
