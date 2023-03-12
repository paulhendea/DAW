
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjB2 {

	public static void main(String[] args) {
		// Create file and reader
		File notasAlumnos = new File("Documentos/alumnos_notas.txt");
		Scanner read = null;
		
		// Create ArrayList to save results
		ArrayList<String> studentMarks = new ArrayList<String>();
		
		try {
			read = new Scanner(notasAlumnos);
			
			// Check if file is empty
			if(!read.hasNext()) throw new Exception("Error: The file is empty");
			
			// Read rows and save into HashMap
			int lineNumber = 0;
			while(read.hasNextLine()) {
				lineNumber++;
				String[] words = read.nextLine().split(" ");
				
				// Discard invalid rows
				if(words.length < 2) {
					System.err.printf("Unvalid data in line %d%n", lineNumber);
					continue;
				}
				
				// Get name
				String name = words[0];
				String lastName = words[1];
				
				// Get marks
				int total = 0;
				for(int i = 2; i < words.length; i++) {
					total += Integer.parseInt(words[i]);
				}
				double average = (double) total / (double) (words.length-2);
				
				// Save values
				studentMarks.add(String.format("%.2f - %s %s", average, name, lastName));
			}
			
			// Sort students by marks
			Collections.sort(studentMarks, Collections.reverseOrder());			
			
			// Show students and average mark
			for(String student: studentMarks) {
				System.out.println(student);
			}
			
		}
		catch(FileNotFoundException e) {
			System.err.println("Error: File not found");
		}
		catch(InputMismatchException e) {
			System.err.println("Error: Invalid data type");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			read.close();
		}
		
		// Program end
		System.out.println("End");
	}

}
