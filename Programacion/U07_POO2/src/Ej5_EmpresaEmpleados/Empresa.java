package Ej5_EmpresaEmpleados;

import java.util.ArrayList;

public class Empresa extends Persona {
	//ATRIBUTOS
	private ArrayList<Empleado> empleados = new ArrayList<Empleado>();
	
	//CONSTRUCTOR
	public Empresa(String nombre, String cif) {
		super(nombre, cif);
	}
	public Empresa(String nombre, String cif, String telefono, String direccion) {
		super(nombre, cif, telefono, direccion);
	}
	
	//METODOS
	public void mostrarInfo() {
		System.out.printf("Empresa %s con CIF %s%n", super.getNombre(), super.getID());
		if(super.getTelefono() != null) {
			System.out.printf("Tel�fono: %s%n", super.getTelefono());
		}
		if(super.getDireccion() != null) {
			System.out.printf("Direcci�n: %s%n", super.getDireccion());
		}
	}
	public void añadirEmpelado(Empleado e) {
		empleados.add(e);
	}
	public void eliminarEmpleado(int n) {
		empleados.remove(n);
	}
	public void mostrarEmpleados() {
		for(int i = 0; i < empleados.size(); i++) {
			Empleado e = (Empleado) empleados.get(i);
			System.out.printf("Empleado %d%n", i);
			e.mostrarInfo();
			System.out.println();
		}
	}
	public void mostrarSueldos() {
		for(int i = 0; i < empleados.size(); i++) {
			Empleado e = (Empleado) empleados.get(i);
			System.out.printf("Empleado %d con DNI %s%n", i, e.getID());
			System.out.printf("Sueldo bruto: %.2f�%n", e.getSueldo());
			System.out.printf("Sueldo neto: %.2f�%n", e.calcularSueldoNeto());
			System.out.println();
		}
	}
	public double calcularTotalSueldosBrutos() {
		double total = 0;
		for(int i = 0; i < empleados.size(); i++) {
			Empleado e = (Empleado) empleados.get(i);
			total += e.getSueldo();
		}
		return total;
	}
	public double calcularTotalSueldosNetos() {
		double total = 0;
		for(int i = 0; i < empleados.size(); i++) {
			Empleado e = (Empleado) empleados.get(i);
			total += e.calcularSueldoNeto();
		}
		return total;
	}
}
