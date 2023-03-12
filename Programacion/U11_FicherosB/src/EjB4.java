import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EjB4 {
    public static void main(String[] args) {
        // Create files and readers
        File namesFile = new File("Documentos/usa_nombres.txt");
        File lastNamesFile = new File("Documentos/usa_apellidos.txt"); 
        File destination = null;
        Scanner input = new Scanner(System.in);
        Scanner readNames = null;
        Scanner readLastNames = null;
        FileWriter write = null;   

        // Instructions
        System.out.println("I generate random names and I append them to a specified file");

        try {
            // Ask for number of names and destination file
            System.out.print("How many people? ");
            int numOfNames = Integer.parseInt(input.nextLine());
            
            System.out.print("Destination file name? ");
            String fileName = input.nextLine();
            destination = new File("Documentos/"+fileName);
            write = new FileWriter(destination, true);

            // Read names and last names, and save them
            ArrayList<String> names = new ArrayList<String>();
            readNames = new Scanner(namesFile);
            while(readNames.hasNextLine()) {
                names.add(readNames.nextLine());
            }

            ArrayList<String> lastNames = new ArrayList<String>();
            readLastNames = new Scanner(lastNamesFile);
            while(readLastNames.hasNextLine()) {
                lastNames.add(readLastNames.nextLine());
            }

            // Generate random names
            ArrayList<String> fullNames = randomFullNames(numOfNames, names, lastNames);
            
            // Write names into file
            for(String row: fullNames) {
                write.write(row+"\n");
            }

            // Close writer
            write.close();
        }
        catch(NumberFormatException e) {
            e.printStackTrace();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            input.close();
            readNames.close();
            readLastNames.close();
        }

        // Program end
        System.out.println("End");
    }
    
    // Generates a specified amont of random names
    private static ArrayList<String> randomFullNames(int numOfNames, ArrayList<String> names, ArrayList<String> lastNames) {
        ArrayList<String> fullNames = new ArrayList<String>();

        for(int i = 0; i < numOfNames; i++) {
            // Get random name and last name
            int randomName = (int) Math.round(Math.random() * (names.size()-1));
            int randomLastName = (int) Math.round(Math.random() * (lastNames.size()-1));

            // Generate new full name
            String fullName = names.get(randomName) + " " + lastNames.get(randomLastName);

            // Check if already exists
            if(fullNames.contains(fullName)) i--;
            else fullNames.add(fullName);
        }
        return fullNames;
    }

}
