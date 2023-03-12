package Act3;

import java.util.ArrayList;

public class programaMultimedia {

	public static void main(String[] args) {
		//CREAMOS UN ARRAYLIST Y GUARDAMOS 3 PELICULAS
		ArrayList<Multimedia> lista = new ArrayList<Multimedia>();
		lista.add(new Pelicula("Kimi no na wa", "Makoto Shinkai", "mp3", 112, 
				"Taki Tachibana" ,"Mitsuha Miyamizu"));
		lista.add(new Pelicula("Kimi no na wa", "Makoto Shinkai", "wav", 112, 
				"Taki Tachibana" ,"Mitsuha Miyamizu"));
		lista.add(new Pelicula("Avatar", "James Cameron", "Blu-ray", 162, 
				"Jake Sully", null));
		
		//IMPRIMIMOS INFO SOBRE LAS PELÍCULAS
		for(int i = 0; i < lista.size(); i++) {
			Multimedia peli = (Multimedia) lista.get(i);
			System.out.println(peli);
		}
		System.out.println();
		
		//COMPROBAMOS SI EL METODO EQUALS FUNCIONA CORRECTAMENTE
		Multimedia peli1 = (Multimedia) lista.get(0);
		Multimedia peli2 = (Multimedia) lista.get(1);
		if(peli1.equals(peli2)) {
			System.out.println("Las películas 1 y 2 son las mismas");
		}
		else {
			System.out.println("Las películas 1 y 2 NO son las mismas");
		}
	}

}
