package Ej3_Mascotas;

public class programaMascotas {

	public static void main(String[] args) {
		Inventario tienda1 = new Inventario();
		tienda1.addMascota(new Perro("Dani", "vivo", "2020-01-01", "Chihuahua", true));
		tienda1.addMascota(new Gato("Ramón", "vivo", "2020-01-01", "marron claro", false));
		tienda1.addMascota(new Loro("George", "vivo", "2020-01-01", "corto", false, "desconocido", true));
		tienda1.addMascota(new Canario("Vicent", "vivo", "2020-01-01", "mediano", true, "amarillo", true));
		tienda1.addMascota(new Perro("Paco", "vivo", "2020-01-01", "Chihuahua", true));
		tienda1.removeMascota(4);
		
		tienda1.ListaMascotas();
		tienda1.mostrarInfoTodos();
		tienda1.mostrarInfoMascota(0);
		
		Aves mascota = (Aves) tienda1.getMascota(2);
		mascota.habla(2);
		mascota.volar();
		
		tienda1.clearInventario();
	}

}
