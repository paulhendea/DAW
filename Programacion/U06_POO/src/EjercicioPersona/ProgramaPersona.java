package EjercicioPersona;

import java.util.Scanner;

public class ProgramaPersona {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//CREAMOS INSTANCIAS
		Persona personas[] = new Persona[3];
		
		//ASIGNAMOS VALORES
		String dni, nombre, apellidos;
		int edad;
		for(int i = 0; i < personas.length; i++) {				
			System.out.println("Persona "+(i+1)+"\n---------------");
			System.out.print("DNI: ");
			dni = sc.nextLine();
			System.out.print("Nombre: ");
			nombre = sc.nextLine();
			System.out.print("Apellidos: ");
			apellidos = sc.nextLine();
			System.out.print("Edad: ");
			edad = sc.nextInt(); 
			sc.nextLine(); //CONSUME NEWLINE LEFT-OVER
			System.out.println();
			
			personas[i] = new Persona(dni, nombre, apellidos, edad);
		}
		
		//DATOS PERSONAS
		for(int i = 0; i < personas.length; i++) {
			System.out.printf("Persona %d%n", i+1);
			personas[i].imprime();
			System.out.println();
		}
			
		//MOSTRAMOS POR PANTALLA
		System.out.println("MAYOR EDAD");
		for(int i = 0; i < personas.length; i++) {
			if(personas[i].esMayorEdad()) {
				System.out.println(personas[i].getNombre()+" "+personas[i].getApellidos()
						+" con DNI "+personas[i].getDni()+" es mayor de edad.");
			}
			else {
				System.out.println(personas[i].getNombre()+" "+personas[i].getApellidos()
						+" con DNI "+personas[i].getDni()+" no es mayor de edad.");
			}
		} System.out.println();
		
		//MODIFICAMOS VALORES Y MOSTRAMOS DE NUEVO
		System.out.println("JUBILADO");
		for(int i = 0; i < personas.length; i++) {
			if(personas[i].esJubilado()) {
				System.out.println(personas[i].getNombre()+" "+personas[i].getApellidos()
						+" con DNI "+personas[i].getDni()+" est� jubilado.");
			}
			else {
				System.out.println(personas[i].getNombre()+" "+personas[i].getApellidos()
						+" con DNI "+personas[i].getDni()+" no est� jubilado.");
			}
		} System.out.println();
		
		//MOSTRAMOS DIFERENCIA EDAD
		System.out.printf("Diferencia edad entre %s %s y %s %s: %d%n", 
				personas[0].getNombre(), personas[0].getApellidos(), 
				personas[1].getNombre(), personas[1].getApellidos(),
				personas[0].diferenciaEdad(personas[1]));

		sc.close();
	}
}
