package Act8;

import java.util.ArrayList;

public class programaFecha {

	public static void main(String[] args) {
		//INSTANCIAMOS VARIAS FECHAS Y LOS GUARDAMOS EN UNA LISTA
		ArrayList<Fecha> fechas = new ArrayList<Fecha>();
		fechas.add(new Fecha(2022, 1, 31));
		fechas.add(new Fecha(2022, 2, 28));
		fechas.add(new Fecha(2022, 3, 31));
		fechas.add(new Fecha(2022, 4, 31));
		fechas.add(new Fecha(2022, 5, 31));
		fechas.add(new Fecha(2022, 6, 31));
		fechas.add(new Fecha(2022, 7, 31));
		fechas.add(new Fecha(2022, 8, 31));
		fechas.add(new Fecha(2022, 9, 31));
		fechas.add(new Fecha(2022, 10, 31));
		fechas.add(new Fecha(2022, 11, 31));
		fechas.add(new Fecha(2022, 12, 31));
		
		//IMPRIMIMOS FECHAS POR PANTALLA PARA COMPROBAR VALIDEZ 
		for(int i = 0; i < fechas.size(); i++) {
			Fecha f = (Fecha) fechas.get(i);
			System.out.println(f.toString());
		}
		System.out.println();
		
		//COMPROBAMOS FUNCION diaSiguiente
		for(int i = 0; i < fechas.size(); i++) {
			Fecha f = (Fecha) fechas.get(i);
			f.diaSiguiente();
			System.out.println(f.toString());
		}
	}
}
