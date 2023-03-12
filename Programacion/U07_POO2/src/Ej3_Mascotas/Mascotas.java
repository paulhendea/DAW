package Ej3_Mascotas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

public abstract class Mascotas {
	//ATRIBUTOS
	private String nombre;
	private String estado = "vivo"; //VIVO O MUERTO
	private LocalDate fechaNacimiento = LocalDate.now();
	private String dateFormat = "dd/MM/yyyy";
	private String birthdayFormat = "MMMMM dd";
	
	//CONSTRUCTOR
	public Mascotas(String nombre, String estado, String fechaNacimiento) {
		this.nombre = nombre;
		this.estado = estado;
		setFechaNacimiento(fechaNacimiento);
	}
	
	//GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return calcularEdad();
	}
	public String getEstado() {
		return estado;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento.format(DateTimeFormatter.ofPattern(dateFormat));
	}
	public abstract String getTipo();
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = LocalDate.parse(fechaNacimiento);
	}
	
	//METODOS
	public abstract void mostrarInfo();
	public abstract void habla(int n);
	

	public String cumpleanos() {
		return fechaNacimiento.format(DateTimeFormatter.ofPattern(birthdayFormat));
	}
	public void morir() {
		estado = "muerto";
	}
	private int calcularEdad() {
		LocalDate now = LocalDate.now();
		int edad = Period.between(fechaNacimiento, now).getYears();
		return edad;
	}
}