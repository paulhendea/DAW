package Ej5_EmpresaEmpleados;

import java.time.LocalDate;
import java.time.Period;

public class Empleado extends Persona {
	//ATRIBUTOS
	private double sueldoBruto; //MENSUAL
	private LocalDate fechaNacimiento = null;
	
	//CONSTRUCTOR
	public Empleado(String nombre, String dni, double sueldoBruto) {
		super(nombre, dni);
		this.sueldoBruto = sueldoBruto;
	}
	public Empleado(String nombre, String dni, double sueldoBruto, String fechaNacimiento, 
			String telefono, String direccion) {
		super(nombre, dni, telefono, direccion);
		this.sueldoBruto = sueldoBruto;
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
	}
	
	//GETTERS Y SETTERS
	public double getSueldo() {
		return sueldoBruto;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public int getEdad() {
		LocalDate now = LocalDate.now();
		int edad = Period.between(fechaNacimiento, now).getYears();
		return edad;
	}
	
	public void setSueldo(double sueldoBruto) {
		this.sueldoBruto = sueldoBruto;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("%s con DNI %s%n", super.getNombre(), super.getID());
		System.out.printf("Sueldo bruto mensual: %.2f€%n", sueldoBruto);
		if(fechaNacimiento != null) {
			System.out.printf("%d años%n", getEdad());
		}
		if(super.getTelefono() != null) {
			System.out.printf("Teléfono: %s%n", super.getTelefono());
		}
		if(super.getDireccion() != null) {
			System.out.printf("Dirección: %s%n", super.getDireccion());
		}
	}
	public double calcularSueldoNeto() {
		if(sueldoBruto * 12 < 12000) {
			return sueldoBruto * 0.8; //DESCONTAMOS 20% IRPF
		}
		else if(sueldoBruto * 12 > 25000) {
			return sueldoBruto * 0.6; //DESCONTAMOS 40% IRPF
		}
		else {
			return sueldoBruto * 0.7; //DESCONTAMOS 30% IRPF
		}
	}
}
