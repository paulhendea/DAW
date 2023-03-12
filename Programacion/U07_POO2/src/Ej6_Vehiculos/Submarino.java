package Ej6_Vehiculos;

public class Submarino extends VehiculoAcuatico	{
	//ATRIBTOS
	private double profundidadMax; //EN METROS
	
	//CONSTRUCTOR
	public Submarino(String matricula, String modelo, double eslora, double profundidadMax) {
		super(matricula, modelo, eslora);
		if(valorNoNegativo(profundidadMax)) {
			this.profundidadMax = profundidadMax;
		}
		else {
			this.profundidadMax = 0;
			System.err.println("ERROR: La profundidad m�xima no puede ser negativa");
		}
	}
	
	//GETTERS Y SETTERS
	public double getProfundidadMax() {
		return profundidadMax;
	}
	public void setProfundidadMax(double profundidadMax) {
		if(valorNoNegativo(profundidadMax)) {
			this.profundidadMax = profundidadMax;
		}
		else {
			this.profundidadMax = 0;
			System.err.println("ERROR: La profundidad m�xima no puede ser negativa");
		}	}
	
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
		System.out.printf("Veh�culo acu�tico %s con matr�cula %s, %.2fm de eslora, y %.2fm de profundidad m�xima%n%n", 
				super.getModelo(), super.getMatricula(), super.getEslora(), profundidadMax);
	}
}
