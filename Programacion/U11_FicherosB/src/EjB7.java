import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class EjB7 {
   public static void main(String[] args) {
        // Create files and reader
        File stopwords = new File("Documentos/stopwords.txt");
        File file = null;
        Scanner reader = null;
        Scanner input = new Scanner(System.in);

        // Instructions
        System.out.println("I show stats about the file name you type");

        try {
            // Read and save the stopwords (words without meaning)
            ArrayList<String> stopwordsList = new ArrayList<String>();
            reader = new Scanner(stopwords,"utf-8");
            while(reader.hasNextLine()) {
                stopwordsList.add(reader.nextLine());
            }
            reader.close();

            // Ask for the book name
            System.out.print("File name? ");
            String bookName = input.nextLine();
            input.close();

            // Open the file
            file = new File("Documentos/Libros/"+bookName);
            reader = new Scanner(file,"utf-8");

            // Read and save data
            HashMap<String, Integer> wordsCount = new HashMap<String, Integer>();
            int numOfRows = 0, numOfWords = 0, numOfChar = 0;
            while(reader.hasNextLine()) {
                // For each row count rows
                String[] words = reader.nextLine().split(" ");
                numOfRows++;
                for(String word: words) {
                    // For each word count words
                    numOfWords++;

                    // Count chars
                    numOfChar += word.length();

                    // Clean the words
                    word = word.toLowerCase();
                    word = word.replaceAll("[^a-zñáéíóúü0-9]", "");

                    // And save the word in wordsCount excluding stopwords
                    if(stopwordsList.contains(word) || word.matches(".?")) continue;
                    else if(!wordsCount.containsKey(word)) wordsCount.put(word, 1);
                    else wordsCount.put(word, wordsCount.get(word)+1);
                }
            }
            reader.close();

            // Save wordsCount into ArrayList and sort
            ArrayList<Entry<String, Integer>> wordsCountList;
            wordsCountList = new ArrayList<Entry<String, Integer>>(wordsCount.entrySet());
            Collections.sort(wordsCountList, Collections.reverseOrder(new Comparator<Entry<String, Integer>>() {
                public int compare(Entry<String, Integer> entry1, Entry<String, Integer> entry2) {
                    return entry1.getValue().compareTo(entry2.getValue());
                }
            }));

            // Show stats
            System.out.printf("Number of rows: %d%n", numOfRows);
            System.out.printf("Number of words: %d%n", numOfWords);
            System.out.printf("Number of characters: %d%n", numOfChar);
            System.out.println("Top 10 most frequent words\n--------------------------");
            for(int i = 0; i < 10; i++) {
                System.out.printf("%s - %d times%n", wordsCountList.get(i).getKey(), wordsCountList.get(i).getValue());
            }

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
   }
}
