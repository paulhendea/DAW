import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EjB5 {
    public static void main(String[] args) {
        // Create files and readers
        File diccionarioFile = new File("Documentos/diccionario.txt");
        File diccionarioDir = new File("Documentos/Diccionario");
        Scanner reader = null;
        FileWriter writer = null;

        try {
            // Create directory
            if(!diccionarioDir.mkdir()) throw new Exception("Error: Unable to create directory");

            // Read words from diccionario.txt and save them
            ArrayList<String> words = new ArrayList<String>();
            reader = new Scanner(diccionarioFile,"utf-8");
            while(reader.hasNextLine()) {
                words.add(reader.nextLine());  
            }
            reader.close();

            // Create files and write words
            for(int i = 65; i <= 90; i++) {
                String letter = String.format("%s", (char)i).toUpperCase();
                File letterFile = new File(diccionarioDir.getAbsolutePath()+"/"+letter+".txt");
                writer = new FileWriter(letterFile);

                for(String word: words) {
                    String wordFirstLetter = word.substring(0,1).toUpperCase();
                    switch(letter) {
                        case "A":
                            if(wordFirstLetter.matches("[AÁ]")) writer.write(word+"\n");
                            break;
                        case "E":
                            if(wordFirstLetter.matches("[EÉ]")) writer.write(word+"\n");
                            break;
                        case "I":
                            if(wordFirstLetter.matches("[IÍ]")) writer.write(word+"\n");
                            break;
                        case "O":
                            if(wordFirstLetter.matches("[OÓ]")) writer.write(word+"\n");
                            break;
                        case "U":
                            if(wordFirstLetter.matches("[UÚÜ]")) writer.write(word+"\n");
                            break;
                        default: 
                            if(wordFirstLetter.matches(letter)) writer.write(word+"\n");
                            break;
                    }
                }                
                writer.close();
            }
            // Repete for 'Ñ'
            File letterFile = new File(diccionarioDir.getAbsolutePath()+"/Ñ.txt");
            writer = new FileWriter(letterFile);
            for(String word: words) {
                String wordFirstLetter = word.substring(0,1).toUpperCase();
                if(wordFirstLetter.matches("Ñ")) writer.write(word+"\n");
            }
            writer.close();
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        // Program end
        System.out.println("End");
    }
}
