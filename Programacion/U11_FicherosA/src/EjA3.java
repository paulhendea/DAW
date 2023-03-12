
import java.io.File;

public class EjA3 {

	public static void main(String[] args) {
		// Create files with paths
		File docsOrigin = new File("Documentos");
		File docsDestination = new File("DOCS");
		File fotosOrigin = new File("Documentos/Fotografias");
		File fotosDestination = new File("Documentos/FOTOS");
		File lecturaOrigin = new File("Documentos/Libros");
		File lecturaDestination = new File("Documentos/LECTURAS");

		// Change the names from inside to outside
		// Rename files
		File[] fileList = fotosOrigin.listFiles();
		if(fileList == null) System.out.printf("%s not found or empty%n", fotosOrigin);
		else {
			for(File file: fileList) {
				// We only want to change files names
				if(file.isFile()) {
					// Find the extension and remove it
					String name = file.getName();
					int extensionPosition = name.lastIndexOf(".");
					if(extensionPosition != -1) name = name.substring(0, extensionPosition);
					
					// Finally rename the file
					File fileDestination = new File(String.format("%s/%s", file.getParent(), name));
					boolean res = file.renameTo(fileDestination);
					System.out.printf("%s: %s to %s%n", res, file, fileDestination);
				}
			}
		}
		

		// Same for Libros files names
		fileList = lecturaOrigin.listFiles();
		if(fileList == null) System.out.printf("%s not found or empty%n", fotosOrigin);
		else {
			for(File file: fileList) {
				// We only want to change files names
				if(file.isFile()) {
					// Find the extension and remove it
					String name = file.getName();
					int extensionPosition = name.lastIndexOf(".");
					if(extensionPosition != -1) name = name.substring(0, extensionPosition);
					
					// Finally rename the file
					File fileDestination = new File(String.format("%s/%s", file.getParent(), name));
					boolean res = file.renameTo(fileDestination);
					System.out.printf("%s: %s to %s%n", res, file, fileDestination);
				}
			}
		}
		

		// Rename directories
		boolean res;
		res = fotosOrigin.renameTo(fotosDestination);
		System.out.printf("%s: %s to %s%n", res, fotosOrigin, fotosDestination);

		res = lecturaOrigin.renameTo(lecturaDestination);
		System.out.printf("%s: %s to %s%n", res, lecturaOrigin, lecturaDestination);

		res = docsOrigin.renameTo(docsDestination);
		System.out.printf("%s: %s to %s%n", res, docsOrigin, docsDestination);

		// Program end
		System.out.println("END");
	}

}
