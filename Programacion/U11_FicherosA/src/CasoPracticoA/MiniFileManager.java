package CasoPracticoA;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

public class MiniFileManager {
	// Create File for current path
	private File curentDirectory = null;
	
	// Constructor
	public MiniFileManager(String path) throws FileNotFoundException {
		File destination = new File(path);
		if(!destination.exists()) throw new FileNotFoundException(destination.getAbsolutePath());
		
		this.curentDirectory = new File(destination.getAbsolutePath());
	}
	
	// PRIVATE METHODS
	// Calculates the Date and hour from a millisecond format
	private String calculateDate(long ms) {
		char dateSeparator = '/', hourSeparator = ':';
		Date lastModified = new Date(ms);
		Calendar c = new GregorianCalendar();
		c.setTime(lastModified);
		
		int day, month, year, hour, minute, second;
		   
		day = c.get(Calendar.DATE);
		month = c.get(Calendar.MONTH);
		year = c.get(Calendar.YEAR);
		hour = c.get(Calendar.HOUR_OF_DAY);
		minute = c.get(Calendar.MINUTE);
		second = c.get(Calendar.SECOND);
		
		return String.format("%02d%c%02d%c%d %02d%c%02d%c%02d", 
				day, dateSeparator, month, dateSeparator, year, 
				hour, hourSeparator, minute, hourSeparator, second);
	}
	// Calculates the File Size from bytes
	private String calculateFileSizeSI(long b) {
		double bytes = b;
		if (bytes < 1000.0) return bytes + " B";
		else bytes /= 1000.0;
		
	    CharacterIterator ci = new StringCharacterIterator("kMGTPE");
	    while (bytes >= 1000.0) {
	        bytes /= 1000.0;
	        ci.next();
	    }
	    return String.format("%.1f %cB", bytes, ci.current());
	}
	// Rerturns the absolute path in relation to the current directory 
	private File getAbsolutePath(String path) {
		File absolutePath = new File(path);
		
		// If path is not absolute use curent directory for reference
		if(!absolutePath.isAbsolute()) {	
			absolutePath = readRelativePath(path);	
		}
		
		return absolutePath;
	}
	// Reads relative paths
	private File readRelativePath(String path) {
		File finalPath = new File(curentDirectory.getAbsolutePath());
		String[] steps = path.split("/");
		
		for(String step: steps) {
			if(step.matches("..")) finalPath = new File(finalPath.getParent());
			else finalPath = new File(finalPath.getAbsolutePath()+"/"+step);
		}
		return finalPath;
	}
	
	// METHODS
	// Returns the current directory
	public String getCurrentDirectory() {
		return curentDirectory.getAbsolutePath();
	}
	// Changes the directory
	public boolean changeDir(String dir) throws FileNotFoundException {
		File destination = getAbsolutePath(dir);
		
		// Chek if exists
		if(!destination.exists()) throw new FileNotFoundException(destination.getAbsolutePath());
		
		// If its not a directory dont change it
		if(!destination.isDirectory()) return false;
		
		// Change current path
		curentDirectory = destination;
		return true;		
	}
	// Shows the content of a directory
	public void printList(boolean info) {
		File[] files = curentDirectory.listFiles();
		ArrayList<String> fileList = new ArrayList<String>(); 
		if(files.length != 0) {
			// Save files into array
			for(File f: files) {
				// Save size and last modification info if required
				if(info) {
					if(f.isDirectory()) {
						fileList.add(String.format("[d] %-30s %-20s", f.getName(), 
								calculateDate(f.lastModified())));
					}
					else if(f.isFile()) {
						fileList.add(String.format("[f] %-30s %-20s %-8s", f.getName(), 
								calculateDate(f.lastModified()), calculateFileSizeSI(f.length())));
					}
				}
				else {
					if(f.isDirectory()) fileList.add("[d] "+f.getName());
					else if(f.isFile()) fileList.add("[f] "+f.getName());
				}
			}
			
			// Sort array
			Collections.sort(fileList);
			
			// Print tags
			System.out.printf("%-35s ", "Names");
			if(info) System.out.printf("%-20s %-8s", "Last modification", "Size");
			System.out.print("\n-----------------------------------");
			if(info) System.out.print("-------------------------------");
			
			// Print files
			for(String line: fileList) {
				
				System.out.printf("%n%s", line);
			}
			System.out.println();
		}
	}
	// Creates a new directory in the current directory
	public boolean mkdir(String dirName) {
		File newFile = new File(curentDirectory.getAbsolutePath()+"/"+dirName);
				
		return newFile.mkdir();
	}
	// Removes the given file
	public boolean removeFile(String path) throws FileNotFoundException, Exception {
		File file = getAbsolutePath(path);
		
		boolean res = false;
		
		// Chek if the file exists
		if(!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}
		// If it's a file try to delete
		else if(file.isFile()) res = file.delete();
		// If it's a directory chek content
		else if(file.isDirectory()) {
			
			// If it's not empty try to delete content
			if(file.listFiles().length != 0) {
				throw new Exception("The directory has subdirectories");
			}
			// Then delete the directory
			res = file.delete();
		}
		
		return res;
	}
	// Moves the file1 to the file2 path
	public boolean moveFile(String originPath, String destinationPath) throws FileNotFoundException {
		File origin = getAbsolutePath(originPath);
		File destination = getAbsolutePath(destinationPath);
		
		// Chek if the origin file exists
		if(!origin.exists()) throw new FileNotFoundException(origin.getAbsolutePath());
		
		//Move file
		return origin.renameTo(destination);
	}
}
