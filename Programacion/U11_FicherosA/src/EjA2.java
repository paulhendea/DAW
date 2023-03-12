
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class EjA2 {
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
					showPathInfo(path, true);
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
	
	private static void showPathInfo(File path, boolean info) throws FileNotFoundException {
		//IF FILE DOSENT EXIST TRHOW EXCEPTION
		if(!path.exists()) throw new FileNotFoundException();
		
		//SHOW OR NOT +INFO
		if(info) {			
			System.out.printf("File size: %s%n", calculateFileSize(path.length()));
			System.out.printf("Last modification: %s%n", calculateDate(path.lastModified()));
		}
		
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
	private static String calculateDate(long ms) {
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
	private static String calculateFileSize(long b) {
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

}
