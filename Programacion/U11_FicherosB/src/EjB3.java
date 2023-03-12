import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EjB3 {

	public static void main(String[] args) {
		// Create files and readers
		File origin = null;
		File destination = null;
		Scanner input = new Scanner(System.in);
		Scanner read = null;
		FileWriter write = null;
		

		// Instructions
		System.out.println("I read data from file A and I write it sorted into file B");

		try {
			// Ask for paths
			System.out.print("File A name: ");
			String fileName = input.nextLine();
			origin = new File("Documentos/"+fileName);
			read = new Scanner(origin);

			System.out.print("File B name: ");
			fileName = input.nextLine();
			destination = new File("Documentos/"+fileName);
			// If file B already exists cancel operation to avoid overwrite
			if(destination.exists()) throw new Exception("Error: File already exists");

			write = new FileWriter(destination);

			// Read and save data
			ArrayList<String> data = new ArrayList<String>();
			while(read.hasNextLine()) {
				data.add(read.nextLine());
			}

			// Sort data
			Collections.sort(data);

			// Write data
			for(String row: data) {
				write.write(row+"\n");
			}

			// Close writer
			write.close();
		}
		catch(FileNotFoundException e) {
			System.err.println("Error: File not found");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			read.close();
			input.close();
		}

		// Program end
		System.out.println("End");
	}

}
