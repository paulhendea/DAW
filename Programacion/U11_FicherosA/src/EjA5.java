import java.io.File;
import java.io.FileNotFoundException;

public class EjA5 {

	public static void main(String[] args) {
		// Create File path to delete
		File fotos = new File("Documentos/Fotografias");
		File libros = new File("Documentos/Libros");
		File docs = new File("Documentos");
		
		// Try to delete
		try {
			boolean res;
			
			res = deleteAll(fotos);
			System.out.printf("%s: Delete %s%n", res, fotos);
			
			res = deleteAll(libros);
			System.out.printf("%s: Delete %s%n", res, libros);
			
			res = deleteAll(docs);
			System.out.printf("%s: Delete %s%n", res, docs);
		}
		catch(FileNotFoundException e) {
			System.err.println("Error: File not found");
		}
		
		//Program end
		System.out.println("End");

	}
	private static boolean deleteAll(File file) throws FileNotFoundException {
		boolean res = false;
		
		
		// Chek if the file exists
		if(!file.exists()) {
			throw new FileNotFoundException();
		}
		// If it's a file try to delete
		else if(file.isFile()) res = file.delete();
		// If it's a directory chek content
		else if(file.isDirectory()) {
			File[] fileList = file.listFiles();
			
			// If it's not empty try to delete content
			if(fileList.length != 0) {
				for(File f: fileList) {
					if(!deleteAll(f)) {
						System.err.printf("Deletion failed: %s%n", f);
						return false;
					}
				}
			}
			// Then delete the directory
			res = file.delete();
		}
		
		return res;
	}

}
