
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjB1 {

	public static void main(String[] args) {
		// Create file, reader and variables
		File numeros = new File("Documentos/numeros.txt");
		Scanner readNum = null;
		int max, min;
		
		try {
			readNum = new Scanner(numeros);	
			
			// Chek if the file is empty
			if(!readNum.hasNext()) throw new Exception("Error: The file is emtpy");
			
			// Set max and min to the firstValue of the file
			int value = readNum.nextInt();
			max = value;
			min = value;
			
			// Read the rest of the file and set min and max
			while(readNum.hasNext()) {
				value = readNum.nextInt();
				max = Math.max(max, value);
				min = Math.min(min, value);
			}
			
			// Show max and min values
			System.out.printf("Max value: %d%nMin value: %d%n", max, min);
		}
		catch(FileNotFoundException e) {
			System.err.println("Error: File not found");
		}
		catch(InputMismatchException e) {
			System.err.println("Error: Must be an int");
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			readNum.close();
		}
		
		// Program end
		System.out.println("End");
	}

}
