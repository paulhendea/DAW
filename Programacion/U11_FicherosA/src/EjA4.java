
import java.io.File;

public class EjA4 {

	public static void main(String[] args) {
		// Create the files with paths
		File misCosas = new File("Documentos/Mis cosas");
		File alfabeto = new File("Documentos/Alfabeto");
		File fotosOrigin = new File("Documentos/Fotografias");
		File fotosDestination = new File("Documentos/Mis cosas/Fotografias");
		File librosOrigin = new File("Documentos/Libros");
		File librosDestination = new File("Documentos/Mis cosas/Libros");
		
		// Create the directories
		boolean res;
		res = misCosas.mkdir();
		System.out.printf("%s: Create %s%n", res, misCosas);
		
		res = alfabeto.mkdir();
		System.out.printf("%s: Create %s%n", res, alfabeto);
		
		// Move the directories Fotografias and Libros into Mis cosas
		res = fotosOrigin.renameTo(fotosDestination);
		System.out.printf("%s: Move %s into %s%n", res, fotosOrigin, fotosDestination);
		
		res = librosOrigin.renameTo(librosDestination);
		System.out.printf("%s: Move %s into %s%n", res, librosOrigin, librosDestination);
		
		// Create directories into Alfabeto
		// We can create chars by his ASCII code
		// 65 is A, 90 is Z
		for(int i = 65; i <= 91; i++) {
			if(i != 91) {
				char letter = (char) i;
				File tmpFile = new File(alfabeto+"/"+letter);
				
				res = tmpFile.mkdir();
				System.out.printf("%s: Create %s%n", res, tmpFile);
			}
			else {
				// Finally we have to create the Ñ folder
				char letter = 'Ñ';
				File tmpFile = new File(alfabeto+"/"+letter);
				
				res = tmpFile.mkdir();
				System.out.printf("%s: Create %s%n", res, tmpFile);
			}
		}
		
		// Program end
		System.out.println("End");		
	}

}
