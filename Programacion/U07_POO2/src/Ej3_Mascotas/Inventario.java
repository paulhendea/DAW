package Ej3_Mascotas;

import java.util.ArrayList;

public class Inventario {
	//ATRIBUTOS
	private ArrayList<Mascotas> inventario = new ArrayList<Mascotas>();
	
	//GETTER
	public Mascotas getMascota(int n) {
		Mascotas mascota = (Mascotas) inventario.get(n);
		return mascota;
	}
	
	//CONSTRUCTOR
	public Inventario() {}
	
	//METODOS
	public void addMascota(Mascotas mascota) {
		inventario.add(mascota);
	}
	public boolean removeMascota(int n) {
		if((n < 0) || (n > inventario.size()-1)) {
			return false;
		}
		else {
			inventario.remove(n);
			return true;
		}
	}
	public void clearInventario() {
		inventario.clear();
	}
	public void ListaMascotas() {
		for(int i = 0; i < inventario.size(); i++) {
			Mascotas mascota = (Mascotas) inventario.get(i);
			System.out.printf("%d. %s %s%n", i, mascota.getTipo(), 
					mascota.getNombre());
		} System.out.println();
	}
	public void mostrarInfoMascota(int n) {
		Mascotas mascota = (Mascotas) inventario.get(n);
		mascota.mostrarInfo();
	}
	public void mostrarInfoTodos() {
		for(int i = 0; i < inventario.size(); i++) {
			Mascotas mascota = (Mascotas) inventario.get(i);
			mascota.mostrarInfo();
		}
	}
}
