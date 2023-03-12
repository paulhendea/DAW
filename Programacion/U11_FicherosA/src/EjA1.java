
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EjA1 {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		File path = null;
		
		while(true) {
			System.out.print("File path: ");
			String tmpPath = input.nextLine();
			
			if(tmpPath.matches("")) break;
			else {
				try {
					path = new File(tmpPath);
					showPathInfo(path);
				}
				catch(FileNotFoundException e) {
					System.err.println("Error: File not found");
				}
			}
			
			//PRINT LINE BREAK AFTER EACH RESULT
			System.out.println();
		}
		
		//END PROGRAM
		System.out.println("END");
	}
	
	private static void showPathInfo(File path) throws FileNotFoundException {
		//IF FILE DOSENT EXIST TRHOW EXCEPTION
		if(!path.exists()) throw new FileNotFoundException();
		
		//IF ITS A FILE PRINT NAME
		if(path.isFile()) System.out.printf("[f]%s%n", path.getName());
		//IF ITS A DIRECTORY PRINT CONTENT
		else if(path.isDirectory()) {
			File[] fileList = path.listFiles();
			if(fileList != null) {
				//SAVE DIRECTORIES AND FILES INTO ARRAYLIST
				ArrayList<String> pathContent = new ArrayList<String>();
				for(File f: fileList) {
					if(f.isDirectory()) pathContent.add(String.format("[*]%s", f.getName()));
					else if(f.isFile()) pathContent.add(String.format("[f]%s", f.getName()));
				}
				//SORT ARRAYLIST
				Collections.sort(pathContent);
				
				//PRINT SORTED CONTENT
				for(String line: pathContent) {
					System.out.println(line);
				}
			}
		}
	}

}
