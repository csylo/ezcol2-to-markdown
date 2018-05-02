import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/*
 * Replaces all wordpress 2-column ezcol tags with appropriate
 * vertical bars "|".
 *
 * Not done:
 *   -Need to add "| -------- | -------- |" above table
 *   -Need to remove any newlines between table rows
 *   -Should output to file.
 */

public class Formatter{
    public static void main(String[] args){
	try{
	    File myFile = new File("has-ezcol.in");
	    Scanner scan = new Scanner(myFile);
	    ArrayList<String> myList = new ArrayList<String>();
	    while(scan.hasNextLine()){
		myList.add(scan.nextLine());
	    }
	    for(String line : myList){
		String formattedLine = line.replace("[ezcol_1fifth]", "| ");
		formattedLine = formattedLine.replace("[/ezcol_1fifth]", " | ");
		formattedLine = formattedLine.replace("[ezcol_4fifth_end]", "");
		formattedLine = formattedLine.replace("[/ezcol_4fifth_end]", " |");
		System.out.println(formattedLine);
	    }
	    scan.close();
	}
	catch(FileNotFoundException e){
	    System.out.println("@@@FileNotFoundException");
	}
    }
}
