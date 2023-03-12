package CasoPracticoA;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MiniTerminal {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		// Define the separator character
		String separator = Pattern.quote(" ");
		
		// Create MiniFileManager
		MiniFileManager manager = null;
		try {
			manager = new MiniFileManager("C:/Users/paulh");
		}
		catch(FileNotFoundException e) {
			System.err.println("Error: File not found");
		}
		
		while(true) {
			// listen for user input
			String in = ask("~");
			
			// If the user types exit then break the loop
			if(in.matches("exit")) break;
			
			// Else split the user imput by the separator
			String[] cmd = in.split(separator);
			cmd[0] = cmd[0].toLowerCase();
			
			// Execute the given command
			try {
				switch(cmd[0]) {
				case "pwd":
					System.out.println(manager.getCurrentDirectory());
					break;
				case "cd":
					if(cmd.length != 2) System.err.println("Wrong parameters");
					else if(!manager.changeDir(cmd[1])) System.err.println("Unable to change directory");
					break;
				case "ls":
					manager.printList(false);
					break;
				case "ll":
					manager.printList(true);
					break;
				case "mkdir":
					if(cmd.length != 2) System.err.println("Wrong parameters");
					else if(!manager.mkdir(cmd[1])) System.err.println("Unable to create directory");
					break;
				case "rm":
					if(cmd.length != 2) System.err.println("Wrong parameters");
					else if(!manager.removeFile(cmd[1])) System.err.println("Unable to remove file");
					break;
				case "mv":
					if(cmd.length != 3) System.err.println("Wrong parameters");
					else if(!manager.moveFile(cmd[1], cmd[2])) System.err.println("Unable to move file");
					break;
				case "help":
					printHelp();
					break;
				default:
					System.err.println("Unknown command, type HELP to show command info");
				}
			}
			catch(FileNotFoundException e) {
				System.err.printf("Error: File '%s' not found%n", e.getMessage());
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
			
			System.out.println();
		} // Loop end
		
		// Program end
		System.out.println("End");
		
	}
	private static String ask(String question) {
		System.out.print(question);
		return input.nextLine();
	}
	private static void printHelp() {
		System.out.println("pwd\t\t\tprint working directory");
		System.out.println("cd <DIR>\t\tchange directory");
		System.out.println("ls\t\t\tlist directory content");
		System.out.println("ll\t\t\tlist directory content with aditional info");
		System.out.println("mkdir <name>\t\tmake directory in current folder");
		System.out.println("rm <DIR>\t\tremove the specified directory");
		System.out.println("mv <FILE1> <FILE2>\tmove the file1 to the file2 path");
		System.out.println("help\t\t\tshow commands related help");
		System.out.println("exit\t\t\texit the MiniTerminal");
	}

}
