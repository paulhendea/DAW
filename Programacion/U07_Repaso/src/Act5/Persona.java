package Act5;

public class Persona implements Cliente, Empleado {
	//ATRIBUTOS
	private final String DNI;
	private String nombre;
	private boolean esCliente = false;
	private boolean esEmpleado = false;
	
	private double saldo;
	private int horasTrabajadas;
	
	//CONSTRUCTOR
	public Persona(String dni, String nombre) {
		if(dniIsValid(dni)) {
			this.DNI = dni;
			this.nombre = nombre;
		}
		else {
			this.DNI = null;
			this.nombre = null;
		}
	}
	
	//GETTERS
	public String getDNI() {
		return DNI;
	}
	public String getNombre() {
		return nombre;
	}
	public boolean getEsCliente() {
		return esCliente;
	}
	public boolean getEsEmpleado() {
		return esEmpleado;
	}
	public double getSaldo() {
		return saldo;
	}
	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}
	
	//SETTERS
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEsCliente(boolean esCliente) {
		this.esCliente = esCliente;
	}
	public void setEsEmpleado(boolean esEmpleado) {
		this.esEmpleado = esEmpleado;
	}
	public void setSaldo(double saldo) {
		if(esCliente) {
			this.saldo = saldo;
		}
	}
	public void setHorasTrabajadas(int horasTrabajadas) {
		if(esEmpleado) {
			this.horasTrabajadas = horasTrabajadas;
		}
	}
	
	//METODOS ESTATICOS
	public static boolean dniIsValid(String dni) {
		return dni.matches("[0-9]{8}[A-Z]");
	}
	
	//METODOS
	public String toString() {
		if(!esCliente) {
			return String.format("DNI: %s%n", DNI) 
					+ String.format("Nombre: %s%n", nombre)
					+ String.format("Número de horas mensuales trabajadas: %d%n", 
							horasTrabajadas);
		}
		else if(!esEmpleado) {
			return String.format("DNI: %s%n", DNI) 
					+ String.format("Nombre: %s%n", nombre)
					+ String.format("Saldo: %.2f€%n", saldo);
		}
		else {
			return String.format("DNI: %s%n", DNI) 
					+ String.format("Nombre: %s%n", nombre)
					+ String.format("Saldo: %.2f€%n", saldo)
					+ String.format("Número de horas mensuales trabajadas: %d%n", 
							horasTrabajadas);		
		}
	}
	
}
