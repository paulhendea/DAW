package Ej6_Vehiculos;

public class Coche extends VehiculoTerrestre {
	//ATRIBUTOS
	private boolean tieneClima;
	
	//CONSTRUCTOR
	public Coche(String matricula, String modelo, int numRuedas, boolean tieneClima) {
		super(matricula, modelo, numRuedas);
		this.tieneClima = tieneClima;
	}
	
	//GETTERS Y SETTERS
	public boolean getTieneClima() {
		return tieneClima;
	}
	public void setTieneClima(boolean tieneClima) {
		this.tieneClima = tieneClima;
	}
	
	//METODOS
	public void printInfo() {
		if(tieneClima) {
			System.out.printf("Vehículo terrestre %s con matrícula %s,  %d ruedas, y aire acondicionado%n%n", 
					super.getModelo(), super.getMatricula(), super.getNumRuedas());
		}
		else {
			System.out.printf("Vehículo terrestre %s con matrícula %s,  %d ruedas, sin aire acondicionado%n%n", 
					super.getModelo(), super.getMatricula(), super.getNumRuedas());
		}
	}
}
