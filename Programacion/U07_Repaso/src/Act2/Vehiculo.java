package Act2;

public abstract class Vehiculo {
	//ATRIBUTOS DE CLASE
	private static int vehiculosCreados = 0;
	private static double kilometrosTotales = 0;
	
	//ATRIBUTOS DE INSTANCIA
	private double kilometrosRecorridos;
	
	//CONSTRUCTOR
	public Vehiculo() {
		kilometrosRecorridos = 0;
		vehiculosCreados++;
	}
	public Vehiculo(double kilometrosRecorridos) {
		this.kilometrosRecorridos = kilometrosRecorridos;
		kilometrosTotales += kilometrosRecorridos;
		vehiculosCreados++;
	}
	
	//GETTERES
	public static int getVehiculosCreados() {
		return vehiculosCreados;
	}
	public static double getKilometrosTotales() {
		return kilometrosTotales;
	}
	public double getKilometrosRecorridos() {
		return kilometrosRecorridos;
	}
	
	
	
	//METODOS
	public void recorrer(double distancia) {
		kilometrosRecorridos += distancia;
		kilometrosTotales += distancia;
	}
	public abstract void hacerTruco();
	public abstract String info();
	
}
