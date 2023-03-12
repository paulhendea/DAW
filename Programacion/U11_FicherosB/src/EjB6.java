import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EjB6 {
    public static void main(String[] args) {
        // Create File and reader
        File piMillion = new File("Documentos/pi-million.txt");
        Scanner reader = null;
        Scanner input = new Scanner(System.in);

        // Instructions
        System.out.println("I search your number in the first million decimal of PI");

        try {
            // Ask for user input
            System.out.print("Type the number: ");
            String number = input.nextLine();
            input.close();

            // Read the file
            reader = new Scanner(piMillion);
            // Check if the file is empty
            String pi = null;
            if(reader.hasNextLine()) {
                pi = reader.nextLine();
            }
            reader.close();
            // Remove '3.'
            pi = pi.substring(2);

            // Search for the number
            boolean found = false;
            for(int i = 0; i <= pi.length() -number.length(); i++) {
                String tmp = pi.substring(i, i+number.length());
                if(tmp.equals(number)) {
                    found = true;
                    break;
                }
            }

            // Print result
            System.out.printf("Number found: %s%n", found);
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        // Program end
        System.out.println("End");
    }
}