package EstructurasDeDatos;

import java.util.Scanner;
import java.util.HashMap;

public class Ej6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//CREAMOS HASHMAP CON LOS VALORES
		HashMap<String, String> userCredentials = new HashMap<String, String>();
		userCredentials.put("admin", "1234");
		userCredentials.put("paulh", "password1");
		
		//CREAMOS PROGRAMA
		boolean correctCredentials = false;
		int cont = 0;
		do {
			//PEDIMOS DATOS
			System.out.println("Log in\n------");
			System.out.print("User: ");
			String user = input.nextLine();
			System.out.print("Password: ");
			String password = input.nextLine();
			
			//COMPROBAMOS DATOS
			if(userCredentials.containsKey(user)) {
				if(password.matches(userCredentials.get(user))) {
					//SI SON CORRECTOS DAMOS ACCESO
					correctCredentials = true;
				}
			}
			
			//SI NO SON CORRECTOS MOSTRAMOS MENSAJE
			if(!correctCredentials) {
				System.err.println("Incorrect user or password.");
			}
			
			System.out.println();
			cont++;
		} 
		//REPETIMOS HASTA QUE EL CONTADOR SEA MAYOR QUE TRES
		//O LO DATOS SEAN CORRECTOS
		while((cont < 3) && !correctCredentials);
		
		//MOSTRAMOS MENSAJE DE ACCESO DENEGADO O CONDEDIDO
		if(correctCredentials) {
			System.out.println("Ha accedido al área restringida");
		}
		else {
			System.out.println("Lo siento, no tiene acceso al área restringida");
		}

		input.close();
	}

}
