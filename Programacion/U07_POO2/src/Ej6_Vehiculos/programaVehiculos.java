package Ej6_Vehiculos;

import java.util.ArrayList;

public class programaVehiculos {

	public static void main(String[] args) {
		//CREAMOS ARRAYLIST
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		
		//INSTANCIAMOS OBJETOS Y LOS GUARDAMOS EN EL ARRAYLIST
		vehiculos.add(new Coche("3040OKH", "Mercedes", 4, true));
		vehiculos.add(new Moto("5461IYY", "Kawasaki", 2, "negro"));
		vehiculos.add(new Barco("XYXLY", "modeloBarco", 499.9, true));
		vehiculos.add(new Submarino("RROMEIPVGI", "modeloSubmarino", 247.2, 3243.5));
		vehiculos.add(new Avion("LEVU688114", "Ryanair", 200, 8.4));
		vehiculos.add(new Helicoptero("INCD396076", "Apache", 8, 6));
		vehiculos.add(new VehiculoTerrestre("3382MRG", "militar", 5));
		vehiculos.add(new VehiculoAcuatico("LEKQGZ", "moto acuática", 3.2));
		vehiculos.add(new VehiculoAereo("BDVB131586", "reactor", 2));
		
		//IMPRIMIMOS INFO SOBRE TODOS LOS VEHICULOS
		for(int i = 0; i < vehiculos.size(); i++) {
			Vehiculo v = (Vehiculo) vehiculos.get(i);
			if(v.getIsValid()) {
				System.out.print(i+". ");
				v.printInfo();				
			}
		}
	}
}
